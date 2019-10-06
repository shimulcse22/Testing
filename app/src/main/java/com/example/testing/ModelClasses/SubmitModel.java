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
    @SerializedName("DateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("NationalIdNumber")
    @Expose
    private String nationalIdNumber;
    @SerializedName("PresentAddress")
    @Expose
    private String presentAddress;
    @SerializedName("PermanentAddress")
    @Expose
    private String permanentAddress;
    @SerializedName("OrganizationID")
    @Expose
    private Long organizationId;

    @SerializedName("Height")
    @Expose
    private Double height;
    @SerializedName("Weight")
    @Expose
    private Double weight;
    @SerializedName("ExpectedCountryList")
    @Expose
    private List<String> expectedCountryList = null;
    @SerializedName("ApplideJobsList")
    @Expose
    private List<Long> expectedJobList = null;
    @SerializedName("PassportDetails")
    @Expose
    private PassportModel passportModel=null;


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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationalIdNumber() {
        return nationalIdNumber;
    }

    public void setNationalIdNumber(String nationalIdNumber) {
        this.nationalIdNumber = nationalIdNumber;
    }

    public PassportModel getPassportModel() {
        return passportModel;
    }

    public void setPassportModel(PassportModel passportModel) {
        this.passportModel = passportModel;
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


    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public List<String> getExpectedCountryList() {
        return expectedCountryList;
    }

    public void setExpectedCountryList(List<String> expectedCountryList) {
        this.expectedCountryList = expectedCountryList;
    }

    public List<Long> getExpectedJobList() {
        return expectedJobList;
    }

    public void setExpectedJobList(List<Long> expectedJobList) {
        this.expectedJobList = expectedJobList;
    }

    @Override
    public String toString() {
        return "SubmitModel{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", nationalIdNumber='" + nationalIdNumber + '\'' +
                ", presentAddress='" + presentAddress + '\'' +
                ", permanentAddress='" + permanentAddress + '\'' +
                ", organizationId='" + organizationId + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", expectedCountryList=" + expectedCountryList +
                ", expectedJobList=" + expectedJobList +
                '}';
    }
}
