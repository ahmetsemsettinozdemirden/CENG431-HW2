package business;

import business.orderstate.Saved;
import business.orderstate.State;

import java.util.Date;

public class Order {

    private int id;
    private int trackingNumber;
    // TODO: user Customer instead of id and name
    private int customerId;
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

    public Order(int id, int trackingNumber, int customerId, String customerName, String shippingAddress, double weight) {
        this.id = id;
        this.trackingNumber = trackingNumber;
        this.customerId = customerId;
        this.customerName = customerName;
        this.shippingAddress = shippingAddress;
        this.weight = weight;
        this.state = new Saved();
    }

    public void run() {
        state.run(this);
    }

}
