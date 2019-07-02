package ca.jrvs.apps.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Connection;

public class DatabaseConnectionManager {
    private final String url;
    private final Properties properties;
    public DatabaseConnectionManager(String host, String databaseName, String Username, String Password){
        this.url = "jdbc:postgresql://"+host+"/"+databaseName;
        this.properties = new Properties();
        this.properties.setProperty("user",Username);
        this.properties.setProperty("password",Password);

    }

    public Connection getConnection()throws SQLException {
        return DriverManager.getConnection(this.url,this.properties);

    }

}
