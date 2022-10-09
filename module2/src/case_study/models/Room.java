package case_study.models;

public class Room extends Facility{
    private String freeSevice;

    public Room() {
    }

    public Room(String nameService, int area, int price, int maxPeople, String rentalType, String freeSevice) {
        super(nameService, area, price, maxPeople, rentalType);
        this.freeSevice = freeSevice;
    }

    public String getFreeSevice() {
        return freeSevice;
    }

    public void setFreeSevice(String freeSevice) {
        this.freeSevice = freeSevice;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeSevice='" + freeSevice + '\'' +
                '}';
    }
}
