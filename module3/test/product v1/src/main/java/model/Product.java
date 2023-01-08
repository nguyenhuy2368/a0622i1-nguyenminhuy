package model;

public class Product {
    int id;
    String name;
    double count;
    int amount;
    String color;
    String described;
    Category category;

    public Product(int id, String name, double count, int amount, String color, String described, Category category) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.amount = amount;
        this.color = color;
        this.described = described;
        this.category = category;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescribed() {
        return described;
    }

    public void setDescribed(String described) {
        this.described = described;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
