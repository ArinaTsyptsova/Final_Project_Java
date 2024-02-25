// Класс для игрушек

public class Toy {
    // Поля
    private int id;
    private String name;
    private int quantity;
    private double frequence;

    /**
     * Конструктор
     * 
     * @param id        id игрушки
     * @param name      текстовое название
     * @param quantity  количество
     * @param frequence частота выпадения игрушки (вес в % от 100)
     */
    public Toy(int id, String name, int quantity, double frequence) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.frequence = frequence;
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getFrequence() {
        return frequence;
    }

    public void setFrequence(double frequence) {
        this.frequence = frequence;
    }

}
