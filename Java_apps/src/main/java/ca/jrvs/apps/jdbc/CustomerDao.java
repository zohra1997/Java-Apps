package ca.jrvs.apps.jdbc;

import ca.jrvs.apps.jdbc.util.DataAccessObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerDao extends DataAccessObject<Customer>  {
    private static final String INSERT = "insert into customer (first_name, last_name, email, phone, address, city, state, zipcode)" +
            " Values (?,?,?,?,?,?,?,?)";
    private static final String GET_ONE = "select customer_id, first_name , last_name, " +
            "email, phone, address, city, state, zipcode  from customer where customer_id = ?";

    public CustomerDao(Connection connection) {
        super(connection);
    }

    @Override
    public Customer findById(long id) {
        Customer customer = new Customer();
        try (PreparedStatement statement = this.connection.prepareStatement(GET_ONE)){
            statement.setLong(1,id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){

                customer.setId(rs.getLong("customer_id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setEmail(rs.getString("email"));
                customer.setPhone(rs.getString("phone"));
                customer.setAddress(rs.getString("address"));
                customer.setCity(rs.getString("city"));
                customer.setState(rs.getString("state"));
                customer.setZipCode(rs.getString("zipCode"));
            }
         return null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer update(Customer dto) {
        return null;
    }

    @Override
    public Customer create(Customer dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT)){

         statement.setString(1, dto.getFirstName());
         statement.setString(2, dto.getLastName());
         statement.setString(3, dto.getCity());
         statement.setString(4,dto.getPhone());
         statement.setString(5, dto.getAddress());
         statement.setString(6,dto.getCity());
         statement.setString(7,dto.getState());
         statement.setString(8, dto.toString());
         statement.execute();
         int id = this.getLastVal(CUSTOMER_SQQUENCE);
         return this.findById(id);
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(long id) {

    }
}
