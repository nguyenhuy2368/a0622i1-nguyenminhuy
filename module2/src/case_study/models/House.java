package case_study.models;

public class House extends Facility {
    private String standarRoom;
    private int numberFloor;

    public House() {
    }

    public House(String nameService, int area, int price, int maxPeople, String rentalType, String standarRoom, int numberFloor) {
        super(nameService, area, price, maxPeople, rentalType);
        this.standarRoom = standarRoom;
        this.numberFloor = numberFloor;
    }

    public String getStandarRoom() {
        return standarRoom;
    }

    public void setStandarRoom(String standarRoom) {
        this.standarRoom = standarRoom;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    @Override
    public String toString() {
        return "House{" +
                "standarRoom='" + standarRoom + '\'' +
                ", numberFloor=" + numberFloor +
                '}';
    }
}
