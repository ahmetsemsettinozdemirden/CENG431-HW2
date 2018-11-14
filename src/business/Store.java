package business;

import data.FileHandler;

import java.util.List;

public class Store {

	private FileHandler fileHandler;
    private int lastCustomerId;
    private List<Customer> customerList;

    public Store(FileHandler fileHandler) {
    	this.fileHandler = fileHandler;
        this.customerList = fileHandler.loadCustomers();
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
        Customer customer = new Customer(getLastCustomerId(), name, address, savings, phone, email, password);
        customerList.add(customer);

        saveCustomerList();
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

    public int getLastCustomerId() {
        return ++lastCustomerId;
    }

    private void saveCustomerList() {
    	fileHandler.saveCustomers(customerList);
	}


}
