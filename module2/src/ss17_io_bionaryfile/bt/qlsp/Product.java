package ss17_io_bionaryfile.bt.qlsp;

public class Product {
    private String id;
    private String name;
    private String brand;
    private int price;
    private String description;

    public Product() {
    }

    public Product(String id, String name, String brand, int price, String description) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }

    public Product(String str) {
        String[] data = str.split(",");
        this.id = data[0];
        this.name = data[1];
        this.brand = data[2];
        this.price = Integer.parseInt(data[3]);
        this.description = data[4];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInfo() {
        return this.id + "," + this.name + "," + this.brand + "," + this.price + "," + this.description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
