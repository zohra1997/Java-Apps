package ca.jrvs.apps.jdbc;

import ca.jrvs.apps.jdbc.util.DataTransferObject;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Order implements DataTransferObject {
    private long order_id;
    private Date creation_date;
    private BigDecimal total;
    private int customer_id;
    private long salesperson_id;
    private String status;
    private String customer_firstName;
    private String customer_lastName;
    private String customer_email;
    private String sales_firstName;
    private String sales_lastName;
    private String sales_email;
    private List<OrderList> orderLine;

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public long getSalesperson_id() {
        return salesperson_id;
    }

    public void setSalesperson_id(long salesperson_id) {
        this.salesperson_id = salesperson_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomer_firstName() {
        return customer_firstName;
    }

    public void setCustomer_firstName(String customer_firstName) {
        this.customer_firstName = customer_firstName;
    }

    public String getCustomer_lastName() {
        return customer_lastName;
    }

    public void setCustomer_lastName(String customer_lastName) {
        this.customer_lastName = customer_lastName;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getSales_firstName() {
        return sales_firstName;
    }

    public void setSales_firstName(String sales_firstName) {
        this.sales_firstName = sales_firstName;
    }

    public String getSales_lastName() {
        return sales_lastName;
    }

    public void setSales_lastName(String sales_lastName) {
        this.sales_lastName = sales_lastName;
    }

    public String getSales_email() {
        return sales_email;
    }

    public void setSales_email(String sales_email) {
        this.sales_email = sales_email;
    }

    public List<OrderList> getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(List<OrderList> orderLine) {
        this.orderLine = orderLine;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", creation_date=" + creation_date +
                ", total=" + total +
                ", status='" + status + '\'' +
                ", customer_firstName='" + customer_firstName + '\'' +
                ", customer_lastName='" + customer_lastName + '\'' +
                ", customer_email='" + customer_email + '\'' +
                ", sales_firstName='" + sales_firstName + '\'' +
                ", sales_lastName='" + sales_lastName + '\'' +
                ", sales_email='" + sales_email + '\'' +
                ", orderLine=" + orderLine +
                '}';
    }

    @Override
    public long getId() {
        return order_id;
    }
}
