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
            File saveFile = new File(dataFolder + "/" + customersFile);

            objectMapper.writeValue(saveFile, customers);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveOrders(List<Order> orders) {

        try {
            File saveFile = new File(dataFolder + "/" + ordersFile);

            objectMapper.writeValue(saveFile, orders);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> loadCustomers() {

        List<Customer> customerList = new ArrayList<>();
        try {
            File saveFile = new File(dataFolder + "/" + customersFile);

            // Convert object to JSON string and save into a file directly
            customerList = objectMapper.readValue(saveFile, new TypeReference<List<Customer>>(){});

        } catch (IOException e) {
            e.printStackTrace();
        }

        return customerList;
    }

    public List<Order> loadOrders() {

        List<Order> ordersList = new ArrayList<>();
        try {
            File saveFile = new File(dataFolder + "/" + ordersFile);

            // Convert object to JSON string and save into a file directly
            ordersList = objectMapper.readValue(saveFile, new TypeReference<List<Customer>>(){});

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ordersList;
    }

}
