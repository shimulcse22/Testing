package com.example.testing.ModelClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubmitModel {
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("FatherName")
    @Expose
    private String fatherName;
    @SerializedName("MotherName")
    @Expose
    private String motherName;

    @SerializedName("NationalIdNumber")
    @Expose
    private String nationalIdNumber;
    @SerializedName("PresentAddress")
    @Expose
    private String presentAddress;
    @SerializedName("PermanentAddress")
    @Expose
    private String permanentAddress;

    @SerializedName("Height")
    @Expose
    private Double height;
    @SerializedName("Weight")
    @Expose
    private Double weight;
    @SerializedName("PresentWork")
    @Expose
    private String presentWork;
    @SerializedName("PresentWorkPlace")
    @Expose
    private String presentWorkPlace;

    @SerializedName("ExpectedCountryList")
    @Expose
    private List<String> expectedCountryList = null;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getNationalIdNumber() {
        return nationalIdNumber;
    }

    public void setNationalIdNumber(String nationalIdNumber) {
        this.nationalIdNumber = nationalIdNumber;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getPresentWork() {
        return presentWork;
    }

    public void setPresentWork(String presentWork) {
        this.presentWork = presentWork;
    }

    public String getPresentWorkPlace() {
        return presentWorkPlace;
    }

    public void setPresentWorkPlace(String presentWorkPlace) {
        this.presentWorkPlace = presentWorkPlace;
    }

    public List<String> getExpectedCountryList() {
        return expectedCountryList;
    }

    public void setExpectedCountryList(List<String> expectedCountryList) {
        this.expectedCountryList = expectedCountryList;
    }

    @Override
    public String toString() {
        return "SubmitModel{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", nationalIdNumber='" + nationalIdNumber + '\'' +
                ", presentAddress='" + presentAddress + '\'' +
                ", permanentAddress='" + permanentAddress + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", presentWork='" + presentWork + '\'' +
                ", presentWorkPlace='" + presentWorkPlace + '\'' +
                ", expectedCountryList=" + expectedCountryList +
                '}';
    }
}
