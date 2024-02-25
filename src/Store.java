import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

// Класс для магазина и организации в нем розыгрыша
public class Store {
    // Поля
    private PriorityQueue<Toy> toyQueue;
    private List<Toy> toysWin;

    /**
     * Конструктор
     * 
     * @param toysWin  Список угирушек победителей
     * @param toyQueue Очередь всех игрушек
     */
    public Store() {
        this.toysWin = new ArrayList<>();
        this.toyQueue = new PriorityQueue<>(Comparator.comparingDouble(Toy::getFrequence));
    }

    // Метод добавление новых игрушек
    public void toyAdd(int id, String name, int quantity, double frequence) {
        Toy toy = new Toy(id, name, quantity, frequence);
        toyQueue.offer(toy);
    }

    // Метод для возомжности изменения веса (частоты выпадения игрушки)
    public void setToyfrequence(int id, double frequence) {
        for (Toy toy : toyQueue) {
            if (toy.getId() == id) {
                toy.setFrequence(frequence);
                break;
            }
        }
    }

    // Методя для определения выйгришной игрушки
    public void getDraw() {
        double commonFreq = 0;
        for (Toy toy : toyQueue) {
            commonFreq += toy.getFrequence();
        }

        Random rand = new Random();
        double randomNum = rand.nextDouble() * commonFreq;

        Toy winToy = null;
        for (Toy toy : toyQueue) {
            if (randomNum < toy.getFrequence()) {
                winToy = toy;
                break;
            }
            randomNum -= toy.getFrequence();
        }
        if (winToy != null && winToy.getQuantity() > 0) {
            toysWin.add(winToy);
            winToy.setQuantity(winToy.getQuantity() - 1);

        }
        try (PrintWriter writer = new PrintWriter(new FileWriter("Results.txt"))) {
            writer.write(winToy.getId() + ", " + winToy.getName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
