package data;

import business.Customer;
import business.Order;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class FileHandler {

    private ObjectMapper objectMapper;

    private FileHandler() {
        this.objectMapper = new ObjectMapper();
    }

    public void saveCustomers(List<Customer> customers) {

    }

    public void saveOrders(List<Order> orders) {

    }

    public List<Customer> loadCustomers() {

        return null;
    }

    public List<Order> loadOrders() {

        return null;
    }

}
