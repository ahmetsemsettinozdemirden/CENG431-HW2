package business;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Customer> customerList;
    private List<Order> orderList;

    public Store() {
        this.customerList = new ArrayList<>();
        this.orderList = new ArrayList<>();
    }

    public Customer login(String email, String password) {
        for (Customer customer: customerList) {
            if (customer.checkCredentials(email, password)) {
                return customer;
            }
        }
        throw new RuntimeException("Invalid email or password!");
    }

    public Customer register(String name, String address, double savings, String phone, String email, String password) {
        // TODO: check parameters
        Customer customer = new Customer(customerList.size(), name, address, savings, phone, email, password);
        customerList.add(customer);
        return customer;
    }


    public void chargeCustomer() {

    }

    public void cancelPayment() {

    }

    public void shipOrder() {

    }

    public void deliverOrder() {

    }

}
