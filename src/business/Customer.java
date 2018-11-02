package business;

public class Customer {

    private long id;
    private String name;
    private String address;
    private double savings;
    private String phone;
    private String email;
    private String password;

    public Customer(long id, String name, String address, double savings, String phone, String email, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.savings = savings;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public void saveOrder() {

    }

    public void submitOrder() {

    }

    public void cancelOrder() {
        // TODO: update savings
    }

    public void deleteOrder() {

    }

    public boolean checkCredentials(String email, String password) {

        return false;
    }

}
