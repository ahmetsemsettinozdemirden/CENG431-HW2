package business;

import business.orderstate.Transition;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Customer {

    private long id;
    private String name;
    private String address;
    private double savings;
    private String phone;
    private String email;
    private String password;
    private List<Order> orderList;

    // for deserialisation
    public Customer() {}

    public Customer(long id, String name, String address, double savings, String phone, String email, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.savings = savings;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.orderList = new ArrayList<>();
    }

    public Order saveOrder(double weight) {
        Random random = new Random();
        Order order = new Order(getLastOrderId(), 100000 + random.nextInt(899999),
                this, getAddress(), weight);
        orderList.add(order);
        return order;
    }

    public void submitOrder(Order order) {
        order.run(Transition.SUBMIT_ORDER);


        this.savings -= order.getTotalPrice();
    }

    public void cancelOrder(Order order) {
        this.savings += order.getTotalPrice();
        order.run(Transition.CANCEL_ORDER);
    }

    public void deleteOrder(Order order) {
        order.run(Transition.DELETE_ORDER);
    }

    public Order getOrder(long orderId) {
        for (Order order: orderList) {
            if (order.getId() == orderId) {
                return order;
            }
        }
        throw new RuntimeException("order couldn't found!");
    }

    private long getLastOrderId() {
        return orderList.get(orderList.size() - 1).getId();
    }

    public boolean checkCredentials(String email, String password) {
        // TODO: check parameters
        return this.email.equals(email) && this.password.equals(password);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getSavings() {
        return savings;
    }

    public String getPhone() {
        return phone;
    }

    public List<Order> getOrderList() {
        return orderList;
    }
}
