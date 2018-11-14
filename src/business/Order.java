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

    public int getTrackingNumber() {
        return trackingNumber;
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getWeight() {
        return weight;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public Date getDateShipped() {
        return dateShipped;
    }

    public Date getDateDelivered() {
        return dateDelivered;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public double getCargoPrice() {
        return cargoPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
