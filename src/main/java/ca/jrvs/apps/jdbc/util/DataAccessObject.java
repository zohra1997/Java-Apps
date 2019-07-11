package ca.jrvs.apps.jdbc.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class DataAccessObject <T extends DataTransferObject>{

    protected final Connection connection;
    protected final static String LAST_VAL = "SELECT max(customer_id) from customer";
    protected final static String CUSTOMER_SEQUENCE = "hq_customer_sequence";

    public DataAccessObject(Connection connection ){
        super();
        this.connection= connection;

    }

    /**
     *
     * @param id
     * @return Generic Object type T
     */

    public abstract T findById(long id);

    /**
     *
     * @return list of all object from specified table
     */
    public abstract List<T> findAll();

    /**
     *
     * @param dto
     * @return updated version of dto object
     */
    public abstract T update ( T dto);

    /**
     *
     * @param dto
     * @return created dto object
     */
    public abstract T create (T dto);

    /**
     *
     * @param id
     * this method deletes the object with corresponding Id from table
     */
    public abstract void delete (long id);

    /**
     *
     * @param sequence
     * @return ID of last entry of the table
     */
    protected int getLastVal(String sequence){
        int key = 0;
        String sql = LAST_VAL;
        try(Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next())
            {
              key = rs.getInt(1);

            }
            return key;
        } catch (SQLException e){

            e.printStackTrace();
            throw new RuntimeException(e);

        }

    }

}
