package model;

public class Division {
    private String divisionlId;
    private String divisionName;

    public Division(String levelId, String levelName) {
        this.divisionlId = levelId;
        this.divisionName = levelName;
    }

    public String getDivisionlId() {
        return divisionlId;
    }

    public void setDivisionlId(String divisionlId) {
        this.divisionlId = divisionlId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }
}
