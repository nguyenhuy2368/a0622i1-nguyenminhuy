package model;

public class AccountRenter extends Account {

    private float minArea;
    private float maxArea;
    private int minPrice;
    private int maxPrice;

    public AccountRenter(String idCard, String fullName, String birthday, int gender, boolean status, float minArea, float maxArea, int minPrice, int maxPrice) {
        super(idCard, fullName, birthday, gender, status);
        this.minArea = minArea;
        this.maxArea = maxArea;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public AccountRenter(String string) {
        String[] data = string.split(",");
        setIdCard(data[0]);
        setFullName(data[1]);
        setBirthday((data[2]));
        setGender(Integer.parseInt(data[3]));
//        setStatus(data[4]);
        setMinArea(Float.parseFloat(data[5]));
        setMaxArea(Float.parseFloat(data[6]));
        setMinPrice(Integer.parseInt(data[7]));
        setMinPrice(Integer.parseInt(data[8]));
    }

    public AccountRenter() {
    }

    public float getMinArea() {
        return minArea;
    }

    public void setMinArea(float minArea) {
        this.minArea = minArea;
    }

    public float getMaxArea() {
        return maxArea;
    }

    public void setMaxArea(float maxArea) {
        this.maxArea = maxArea;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public String toString() {
        return "RenterAccount" +
                super.toString() +
                "minArea=" + minArea +
                ", maxArea=" + maxArea +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                '}';
    }

    public String getInfo() {
        return getDataWriteFile() + "," + getMinArea() + "," + getMaxArea() + "," + getMinPrice() + "," + getMaxPrice();
    }
}
