package model;

public class FacilityType {
    private int facilityId;
    private String facilityName;

    public FacilityType() {
    }

    public FacilityType(int facilityId, String facilityName) {
        this.facilityId = facilityId;
        this.facilityName = facilityName;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }
}
