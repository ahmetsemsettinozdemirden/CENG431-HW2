package business;

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

    public Customer(long id, String name, String address, double savings, String phone, String email, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.savings = savings;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public Order saveOrder(double weight) {
        Random random = new Random();
        Order order = new Order(getLastOrderId(), 100000 + random.nextInt(899999),
                getId(), getName(), getAddress(), weight);
        orderList.add(order);
        return order;
    }

    public void submitOrder() {

    }

    public void cancelOrder() {
        // TODO: update savings
    }

    public void deleteOrder() {

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

}
