package ca.jrvs.apps.jdbc;


import java.math.BigDecimal;

public class OrderList {

    private BigDecimal quantity;
    private String code;
    private String pName;
    private long size;
    private String variety;
    private BigDecimal price;

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "OrderList{" +
                "quantity=" + quantity +
                ", code='" + code + '\'' +
                ", pName='" + pName + '\'' +
                ", size=" + size +
                ", variety='" + variety + '\'' +
                ", price=" + price +
                '}';
    }
}
