import business.Store;
import data.FileHandler;
import presentation.Shopping;

public class OnlineShoppingApp {

    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();

        Store store = new Store(fileHandler); // TODO: load json files
        Shopping shopping = new Shopping(store);
        shopping.start();
    }

}
