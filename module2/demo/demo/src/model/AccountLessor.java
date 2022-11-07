package model;

public class AccountLessor extends Account {
    private float area;
    private String address;
    private int peopleMax;
    private int price;

    public AccountLessor() {
    }

    public AccountLessor(float area, String address, int peopleMax, int price) {
        this.area = area;
        this.address = address;
        this.peopleMax = peopleMax;
        this.price = price;
    }

    public AccountLessor(String idCard, String fullName, String birthday, int gender, boolean status, float area, String address, int peopleMax, int price) {
        super(idCard, fullName, birthday, gender, status);
        this.area = area;
        this.address = address;
        this.peopleMax = peopleMax;
        this.price = price;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPeopleMax() {
        return peopleMax;
    }

    public void setPeopleMax(int peopleMax) {
        this.peopleMax = peopleMax;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "LessorAccount" +
                super.toString() +
                "area=" + area +
                ", address='" + address + '\'' +
                ", peopleMax=" + peopleMax +
                ", price=" + price +
                '}';
    }

    public String getInfo() {
        return getDataWriteFile() + "," + getArea() + "," + getAddress() + "," + getPeopleMax() + "," + getPrice();
    }
}
