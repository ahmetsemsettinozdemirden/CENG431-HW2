import business.Store;
import presentation.Shopping;

public class OnlineShoppingApp {

    public static void main(String[] args) {
        Store store = new Store(); // TODO: load json files
        Shopping shopping = new Shopping(store);
        shopping.start();
    }

}
