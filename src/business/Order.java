package business;

import business.orderstate.Saved;
import business.orderstate.State;
import business.orderstate.Transition;

import java.util.Date;

public class Order {

    private long id;
    private int trackingNumber;
    // TODO: user Customer instead of id and name
    private long customerId;
    private String customerName;
    private double weight;
    private String shippingAddress;
    private Date dateShipped;
    private Date dateDelivered;
    private double productPrice;
    private double cargoPrice;
    // TODO: do we need totalPrice
    private double totalPrice;
    private State state;

    // for deserialisation
    public Order() {}

    public Order(long id, int trackingNumber, long customerId, String customerName, String shippingAddress, double weight) {
        this.id = id;
        this.trackingNumber = trackingNumber;
        this.customerId = customerId;
        this.customerName = customerName;
        this.shippingAddress = shippingAddress;
        this.weight = weight;
        this.state = new Saved();
    }

    public void run(Transition transition) {
        this.state = state.run(this, transition);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(int trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Date getDateShipped() {
        return dateShipped;
    }

    public void setDateShipped(Date dateShipped) {
        this.dateShipped = dateShipped;
    }

    public Date getDateDelivered() {
        return dateDelivered;
    }

    public void setDateDelivered(Date dateDelivered) {
        this.dateDelivered = dateDelivered;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getCargoPrice() {
        return cargoPrice;
    }

    public void setCargoPrice(double cargoPrice) {
        this.cargoPrice = cargoPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
