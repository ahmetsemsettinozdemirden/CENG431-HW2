package data;

import business.Customer;
import business.Order;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private final String dataFolder = "appdata";
    private final String customersFile = "customers.json";
    private final String ordersFile = "orders.json";

    private ObjectMapper objectMapper;

    private FileHandler() {
        this.objectMapper = new ObjectMapper();
    }

    public void saveCustomers(List<Customer> customers){

        try {
            objectMapper.writeValue(new File(dataFolder + "/" + customersFile), customers);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveOrders(List<Order> orders) {

        try {

            objectMapper.writeValue(new File(dataFolder + "/" + ordersFile), orders);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> loadCustomers() {

        List<Customer> customerList = new ArrayList<>();
        try {

            customerList = objectMapper.readValue(
                    new File(dataFolder + "/" + customersFile),
                    new TypeReference<List<Customer>>(){});

        } catch (IOException e) {
            e.printStackTrace();
        }

        return customerList;
    }

    public List<Order> loadOrders() {

        List<Order> ordersList = new ArrayList<>();
        try {

            ordersList = objectMapper.readValue(
                    new File(dataFolder + "/" + ordersFile),
                    new TypeReference<List<Customer>>(){});

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ordersList;
    }

    public static class AppdataFolderNotFoundException extends RuntimeException {
        public AppdataFolderNotFoundException(String error) {
            super(error);
        }
    }

}
