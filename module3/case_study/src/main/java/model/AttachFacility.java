package model;

public class AttachFacility {
    private int attachFacilityId;
    private String attachFacilityName;
    private double cost;
    private String unit;


    public AttachFacility() {
    }

    public AttachFacility(int attachFacilityId, String attachFacilityName, double cost, String unit) {
        this.attachFacilityId = attachFacilityId;
        this.attachFacilityName = attachFacilityName;
        this.cost = cost;
        this.unit = unit;

    }

    public AttachFacility(int attachFacilityId, String attachFacilityName) {
        this.attachFacilityId = attachFacilityId;
        this.attachFacilityName = attachFacilityName;
    }

    public int getAttachFacilityId() {
        return attachFacilityId;
    }

    public void setAttachFacilityId(int attachFacilityId) {
        this.attachFacilityId = attachFacilityId;
    }

    public String getAttachFacilityName() {
        return attachFacilityName;
    }

    public void setAttachFacilityName(String attachFacilityName) {
        this.attachFacilityName = attachFacilityName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
