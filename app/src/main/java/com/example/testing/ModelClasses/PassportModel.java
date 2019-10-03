package com.example.testing.ModelClasses;

import android.content.Intent;

import java.util.Date;

public class PassportModel {
    private Integer PassportNumber;
    private Date IssueDate;
    private String IssuePlace;
    private Date DateOfExpiry;
    private String ProfessionAsPassport;

    public Integer getPassportNumber() {
        return PassportNumber;
    }

    public void setPassportNumber(Integer passportNumber) {
        PassportNumber = passportNumber;
    }

    public Date getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(Date issueDate) {
        IssueDate = issueDate;
    }

    public String getIssuePlace() {
        return IssuePlace;
    }

    public void setIssuePlace(String issuePlace) {
        IssuePlace = issuePlace;
    }

    public Date getDateOfExpiry() {
        return DateOfExpiry;
    }

    public void setDateOfExpiry(Date dateOfExpiry) {
        DateOfExpiry = dateOfExpiry;
    }

    public String getProfessionAsPassport() {
        return ProfessionAsPassport;
    }

    public void setProfessionAsPassport(String professionAsPassport) {
        ProfessionAsPassport = professionAsPassport;
    }


}
