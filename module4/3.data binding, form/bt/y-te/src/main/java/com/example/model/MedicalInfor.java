package com.example.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MedicalInfor {
    private String name;
    private int yearBirth;
    private String gender;
    private String nationality;
    private String citizenId;
    private String vehicle;
    private String vehicleId;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date startDate;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date endDate;

    public MedicalInfor() {
    }

    public MedicalInfor(String name, int yearBirth, String gender, String nationality, String citizenId, String vehicle, String vehicleId, Date startDate, Date endDate) {
        this.name = name;
        this.yearBirth = yearBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.citizenId = citizenId;
        this.vehicle = vehicle;
        this.vehicleId = vehicleId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
