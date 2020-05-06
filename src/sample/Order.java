package sample;

import java.io.Serializable;

public class Order implements Serializable {
    private String nameOfFood;
    private String name;
    private int price;

    public Order(String nameOfFood, String name, int price) {
        this.nameOfFood = nameOfFood;
        this.name = name;
        this.price = price;
    }

    public String getNameOfFood() {
        return nameOfFood;
    }

    public void setNameOfFood(String nameOfFood) {
        this.nameOfFood = nameOfFood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "nameOfFood='" + nameOfFood + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
