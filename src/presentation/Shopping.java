package presentation;

import business.Customer;
import business.Order;
import business.Store;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Shopping {

    private enum MenuState {
        MAIN_MENU,
        LOGIN,
        REGISTER,
        HOME_PAGE,
        ADMIN_PAGE,
    }

    private MenuState currentState;
    private Scanner scanner;
    private Store store;
    private Customer customer;
    private Order order;

    public Shopping(Store store) {
        this.scanner = new Scanner(System.in);
        this.store = store;
    }

    public void start() {
        this.currentState = MenuState.MAIN_MENU;
        while (true) {
            try {
                switch (currentState) {
                    case MAIN_MENU:
                        mainMenu();
                        break;
                    case LOGIN:
                        login();
                        break;
                    case REGISTER:
                        register();
                        break;
                    case HOME_PAGE:
                        homePage();
                        break;
                    case ADMIN_PAGE:
                        adminPage();
                        break;
                }
            } catch (Exception e) {
                System.out.println("[ERROR] " + e.getMessage() + "\n");
            }
        }
    }

    private void mainMenu() {

        System.out.print("     Shopping - MainMenu \n" +
                "1) Login\n" +
                "2) Register\n" +
                "3) Login as Store\n" +
                "4) Exit\n");

        System.out.print("choose menu item: ");
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                this.currentState = MenuState.LOGIN;
                break;
            case 2:
                this.currentState = MenuState.REGISTER;
                break;
            case 3:
                this.currentState = MenuState.ADMIN_PAGE;
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.print("Invalid choice.\n");
        }
    }

    private void login() {
        try {
            System.out.println("    Shopping - Login\nplease type your email: ");
            String email = scanner.nextLine();
            System.out.println("please type your password: ");
            String password = scanner.nextLine();
            this.customer = store.login(email, password);
            this.currentState = MenuState.HOME_PAGE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.currentState = MenuState.MAIN_MENU;
        }
    }

    private void register() {
        try {
            System.out.println("     Shopping - Register\nplease type your name: ");
            String name = scanner.nextLine();
            System.out.println("please type your address: ");
            String address = scanner.nextLine();
            System.out.println("please type your savings: ");
            double savings = Double.parseDouble(scanner.nextLine());
            System.out.println("please type your phone: ");
            String phone = scanner.nextLine();
            System.out.println("please type your email: ");
            String email = scanner.nextLine();
            System.out.println("please type your password: ");
            String password = scanner.nextLine();
            this.customer = store.register(name, address, savings, phone, email, password);
            this.currentState = MenuState.HOME_PAGE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.currentState = MenuState.MAIN_MENU;
        }
    }

    private void homePage() {

        System.out.print("     Shopping - Home Page\nWelcome " + customer.getName() + "!\n" +
                "1) Save order\n" +
                "2) Submit order\n" +
                "3) Cancel order\n" +
                "4) Delete order\n" +
                "5) Back to Menu\n");

        System.out.print("choose menu item: ");
        long orderId;
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                System.out.println("please type weight: ");
                double weight = Double.parseDouble(scanner.nextLine());
                Order order = customer.saveOrder(weight);
                System.out.println("Order with id of " + order.getId() + " saved!");
                break;
            case 2:
                orderId = Long.parseLong(scanner.nextLine());
                order = customer.getOrder(orderId);
                customer.submitOrder(order);
                break;
            case 3:
                orderId = Long.parseLong(scanner.nextLine());
                order = customer.getOrder(orderId);
                customer.cancelOrder(order);
                break;
            case 4:
                orderId = Long.parseLong(scanner.nextLine());
                order = customer.getOrder(orderId);
                customer.deleteOrder(order);
                break;
            case 5:
                this.customer = null;
                this.currentState = MenuState.MAIN_MENU;
                break;
            default:
                System.out.print("Invalid choice.\n");
        }
    }

    private void adminPage() {

        System.out.print("     Shopping - Admin Page \n" +
                "1) list orders\n" +
                "2) charge customer\n" +
                "3) cancel payment\n" +
                "4) ship order\n" +
                "5) deliver order\n" +
                "6) Back to Menu\n");

        System.out.print("choose menu item: ");
        long orderId;
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                List<Order> orderList = store.getOrders();
                for (Order order: orderList) {
                    System.out.println("* " + order.getId() + ", weight: " + order.getWeight() + ", price: " + order.getTotalPrice() + ", customer: " + order.getCustomer().getName());
                }
                break;
            case 2:
                orderId = Long.parseLong(scanner.nextLine());
                order = customer.getOrder(orderId);
                store.chargeCustomer(order);
                break;
            case 3:
                orderId = Long.parseLong(scanner.nextLine());
                order = customer.getOrder(orderId);
                store.cancelPayment(order);
                break;
            case 4:
                orderId = Long.parseLong(scanner.nextLine());
                order = customer.getOrder(orderId);
                store.shipOrder(order);
                break;
            case 5:
                orderId = Long.parseLong(scanner.nextLine());
                order = customer.getOrder(orderId);
                store.deliverOrder(order);
                break;
            case 6:
                this.currentState = MenuState.MAIN_MENU;
                break;
            default:
                System.out.print("Invalid choice.\n");
        }
    }
}
