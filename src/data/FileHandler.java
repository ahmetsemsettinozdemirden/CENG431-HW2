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

    private File appdataFolder;
    private final String customersFile = "customers.json";
    private final String ordersFile = "orders.json";

    private ObjectMapper objectMapper;

    public FileHandler() {
        this.objectMapper = new ObjectMapper();
        appdataFolder = new File("appdata");

        if (!appdataFolder.exists() || !appdataFolder.isDirectory())
            throw new AppdataFolderNotFoundException("Appdata folder not found!");
    }

    public void saveCustomers(List<Customer> customers){

        try {

            objectMapper.writeValue(getSaveFile(customersFile), customers);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveOrders(List<Order> orders) {

        try {


            objectMapper.writeValue(getSaveFile(ordersFile) , orders);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> loadCustomers() {

        List<Customer> customerList = new ArrayList<>();
        try {

            customerList = objectMapper.readValue(getSaveFile(customersFile), new TypeReference<List<Customer>>(){});

        } catch (IOException e) {
            e.printStackTrace();
        }

        return customerList;
    }

    public List<Order> loadOrders() {

        List<Order> ordersList = new ArrayList<>();
        try {

            ordersList = objectMapper.readValue(getSaveFile(ordersFile), new TypeReference<List<Customer>>(){});

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ordersList;
    }

    private File getSaveFile(String fileName) throws IOException {
        File saveFile = new File(appdataFolder + "/" + fileName);

        if (!saveFile.exists()) {
            if(saveFile.createNewFile()) {
                System.out.println(fileName +  " file created..");
            }
        }

        return saveFile;
    }

    public static class AppdataFolderNotFoundException extends RuntimeException {
        public AppdataFolderNotFoundException(String error) {
            super(error);
        }
    }

}
