package case_study.models;

public class Villa extends Facility{
    private String standarRoom;
    private int poolArea;
    private int numberFloor;

    public Villa() {
    }

    public Villa(String nameService, int area, int price, int maxPeople, String rentalType, String standarRoom, int poolArea, int numberFloor) {
        super(nameService, area, price, maxPeople, rentalType);
        this.standarRoom = standarRoom;
        this.poolArea = poolArea;
        this.numberFloor = numberFloor;
    }

    public String getStandarRoom() {
        return standarRoom;
    }

    public void setStandarRoom(String standarRoom) {
        this.standarRoom = standarRoom;
    }

    public int getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(int poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "standarRoom='" + standarRoom + '\'' +
                ", poolArea=" + poolArea +
                ", numberFloor=" + numberFloor +
                '}';
    }
}
