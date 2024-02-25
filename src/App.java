import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        Store store = new Store();

        store.toyAdd(1, "Car", 20, 10);
        store.toyAdd(2, "Doll", 15, 40);
        store.toyAdd(3, "Helicopter", 35, 80);
        store.toyAdd(4, "Bus", 5, 30);

        store.setToyfrequence(2, 30);

        store.getDraw();
    }
}
