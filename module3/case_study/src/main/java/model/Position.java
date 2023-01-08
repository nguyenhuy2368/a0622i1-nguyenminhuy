package model;

public class Position {
    private String positionId;
    private String positionName;

    public Position(String departmentId, String DepartmentName) {
        this.positionId = departmentId;
        this.positionName = DepartmentName;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
