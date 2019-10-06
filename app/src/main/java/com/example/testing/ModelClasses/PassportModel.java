package com.example.testing.ModelClasses;

import android.content.Intent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class PassportModel {
    @SerializedName("PassportNumber")
    @Expose
    private String passportNumber;
    @SerializedName("IssueDate")
    @Expose
    private String issueDate;
    @SerializedName("IssuePlace")
    @Expose
    private String issuePlace;
    @SerializedName("DateOfExpiry")
    @Expose
    private String dateOfExpiry;
    @SerializedName("ProfessionAsPassport")
    @Expose
    private String professionAsPassport;

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssuePlace() {
        return issuePlace;
    }

    public void setIssuePlace(String issuePlace) {
        this.issuePlace = issuePlace;
    }

    public String getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(String dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public String getProfessionAsPassport() {
        return professionAsPassport;
    }

    public void setProfessionAsPassport(String professionAsPassport) {
        this.professionAsPassport = professionAsPassport;
    }

}
