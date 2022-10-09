package case_study.models;

public abstract class Facility {
    private String nameService;
    private int area;
    private int price;
    private int maxPeople;
    private String rentalType;

    public Facility() {
    }

    public Facility(String nameService, int area, int price, int maxPeople, String rentalType) {
        this.nameService = nameService;
        this.area = area;
        this.price = price;
        this.maxPeople = maxPeople;
        this.rentalType = rentalType;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "nameService='" + nameService + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", maxPeople=" + maxPeople +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
