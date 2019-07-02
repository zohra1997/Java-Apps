package ca.jrvs.apps.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecuter {
    public static void main(String[] args) {
     DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost","hplussport","postgres", "password");
     try {
         Connection connection = dcm.getConnection();
         CustomerDao customerDao = new CustomerDao(connection);
//         Customer customer = customerDao.findById(1000);
//         System.out.println(customer.getFirstName()+" "+customer.getLastName()+" "+customer.getEmail());
//         customer.setEmail("new@gmail.com");
//         customer = customerDao.update(customer);
//         System.out.println(customer.getFirstName()+" "+customer.getLastName()+" "+customer.getEmail());
         Customer customer = new Customer();
         customer.setFirstName("john");
         customer.setLastName("Mayor");
         customer.setEmail("john@gmail.com");
         customer.setAddress("123 abc street");
         customer.setCity("Toronto");
         customer.setState("ONTARIO");
         customer.setPhone("1234567890");
         customer.setZipCode("12345");
         Customer bdcustomer = customerDao.create(customer);
         System.out.println(bdcustomer);
         bdcustomer = customerDao.findById(bdcustomer.getId());
         System.out.println(bdcustomer);
         bdcustomer.setEmail("update@gmail.com");
         bdcustomer = customerDao.update(bdcustomer);
         System.out.println(bdcustomer);
         customerDao.delete(bdcustomer.getId());

     } catch (SQLException e)
     {
         e.printStackTrace();
     }


    }
}
