package ca.jrvs.apps.jdbc;

import ca.jrvs.apps.jdbc.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class orderDao extends DataAccessObject<Order> {

    private static final String query = String.format("select c.first_name, c.last_name, c.email, o.order_id,o.creation_date, o.total_due, o.status,s.first_name, s.last_name, s.email,ol.quantity ,p.code, p.name, p.size, p.variety, p.price from orders o join customer c on o.customer_id = c.customer_id join salesperson s on o.salesperson_id=s.salesperson_id join order_item ol on ol.order_id=o.order_id join product p on ol.product_id = p.product_id where o.order_id = ?");

    public orderDao(Connection connection) {
        super(connection);
    }

    @Override
    public Order findById(long id) {
        Order order = new Order();
        List<OrderList> orderLists = new ArrayList<>();
        OrderList orderItem = new OrderList();
        try (PreparedStatement statement = this.connection.prepareStatement(query)) {
            statement.setLong(1, id);
            long order_id = 0;
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                if (order_id == 0) {
                    order.setCustomer_firstName(result.getString(1));
                    order.setCustomer_lastName(result.getString(2));
                    order.setCustomer_email(result.getString(3));
                    order.setOrder_id(result.getLong(4));
                    order_id = order.getOrder_id();
                    order.setCreation_date(new Date(result.getDate(5).getTime()));
                    order.setTotal(result.getBigDecimal(6));
                    order.setStatus(result.getString(7));
                    order.setSales_firstName(result.getString(8));
                    order.setSales_lastName(result.getString(9));
                    order.setSales_email(result.getString(10));
                }
                orderItem.setQuantity(result.getBigDecimal(11));
                orderItem.setCode(result.getString(12));
                orderItem.setpName(result.getString(13));
                orderItem.setSize(result.getLong(14));
                orderItem.setVariety(result.getString(15));
                orderItem.setPrice(result.getBigDecimal(16));
                orderLists.add(orderItem);
            }

            order.setOrderLine(orderLists);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order update(Order dto) {
        return null;
    }

    @Override
    public Order create(Order dto) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
