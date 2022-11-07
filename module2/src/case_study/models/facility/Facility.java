package case_study.models.facility;

public abstract class Facility {
    private String nameService;
    private int area;
    private int price;
    private int maxPeople;
    private String typeService;

    public Facility() {
    }

    public Facility(String nameService, int area, int price, int maxPeople, String typeService) {
        this.nameService = nameService;
        this.area = area;
        this.price = price;
        this.maxPeople = maxPeople;
        this.typeService = typeService;
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

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "nameService='" + nameService + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", maxPeople=" + maxPeople +
                ", typeService='" + typeService + '\'' +
                '}';
    }
}
