package com.example.testing.ModelClasses;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;


public class Model implements Parcelable {

    private static Model model;

    public static Model newInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }


    public static Model getModel() {
        return model;
    }

    private ArrayList<String> ExpectedCountryList;
    private ArrayList<String> JobsList;
    private ArrayList<Long> ApplideJobsList;
    private String FirstName;
    private String lastName;
    private String FatherName;
    private String MotherName;
    private String DateOfBirth;
    private String nationalIdNo;
    private String Height;
    private String weight;
    private String PresentAddress;
    private String PermanentAddress;
    private String passportno;
    private String issuedate;
    private String issueplace;
    private String dateexpire;
    private String ProfessionAsPassport;
    private String PassportSizePhoto;
    private String FullSizePhoto;

    public static void setModel(Model model) {
        Model.model = model;
    }

    public ArrayList<String> getExpectedCountryList() {
        return ExpectedCountryList;
    }

    public void setExpectedCountryList(ArrayList<String> expectedCountryList) {
        ExpectedCountryList = expectedCountryList;
    }

    public ArrayList<String> getJobsList() {
        return JobsList;
    }

    public void setJobsList(ArrayList<String> jobsList) {
        JobsList = jobsList;
    }

    public ArrayList<Long> getApplideJobsList() {
        return ApplideJobsList;
    }

    public void setApplideJobsList(ArrayList<Long> applideJobsList) {
        ApplideJobsList = applideJobsList;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public String getMotherName() {
        return MotherName;
    }

    public void setMotherName(String motherName) {
        MotherName = motherName;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getNationalIdNo() {
        return nationalIdNo;
    }

    public void setNationalIdNo(String nationalIdNo) {
        this.nationalIdNo = nationalIdNo;
    }

    public String getHeight() {
        return Height;
    }

    public void setHeight(String height) {
        Height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPresentAddress() {
        return PresentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        PresentAddress = presentAddress;
    }

    public String getPermanentAddress() {
        return PermanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        PermanentAddress = permanentAddress;
    }

    public String getPassportno() {
        return passportno;
    }

    public void setPassportno(String passportno) {
        this.passportno = passportno;
    }

    public String getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(String issuedate) {
        this.issuedate = issuedate;
    }

    public String getIssueplace() {
        return issueplace;
    }

    public void setIssueplace(String issueplace) {
        this.issueplace = issueplace;
    }

    public String getDateexpire() {
        return dateexpire;
    }

    public void setDateexpire(String dateexpire) {
        this.dateexpire = dateexpire;
    }

    public String getProfessionAsPassport() {
        return ProfessionAsPassport;
    }

    public void setProfessionAsPassport(String professionAsPassport) {
        ProfessionAsPassport = professionAsPassport;
    }

    public String getPassportSizePhoto() {
        return PassportSizePhoto;
    }

    public void setPassportSizePhoto(String passportSizePhoto) {
        PassportSizePhoto = passportSizePhoto;
    }

    public String getFullSizePhoto() {
        return FullSizePhoto;
    }

    public void setFullSizePhoto(String fullSizePhoto) {
        FullSizePhoto = fullSizePhoto;
    }

    @Override
    public String toString() {
        return "Model{" +
                "ExpectedCountryList=" + ExpectedCountryList +
                ", JobsList=" + JobsList +
                ", ApplideJobsList=" + ApplideJobsList +
                ", FirstName='" + FirstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", FatherName='" + FatherName + '\'' +
                ", MotherName='" + MotherName + '\'' +
                ", DateOfBirth='" + DateOfBirth + '\'' +
                ", nationalIdNo='" + nationalIdNo + '\'' +
                ", Height='" + Height + '\'' +
                ", weight='" + weight + '\'' +
                ", PresentAddress='" + PresentAddress + '\'' +
                ", PermanentAddress='" + PermanentAddress + '\'' +
                ", passportno='" + passportno + '\'' +
                ", issuedate='" + issuedate + '\'' +
                ", issueplace='" + issueplace + '\'' +
                ", dateexpire='" + dateexpire + '\'' +
                ", ProfessionAsPassport='" + ProfessionAsPassport + '\'' +
                ", PassportSizePhoto='" + PassportSizePhoto + '\'' +
                ", FullSizePhoto='" + FullSizePhoto + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(this.ExpectedCountryList);
        dest.writeStringList(this.JobsList);
        dest.writeList(this.ApplideJobsList);
        dest.writeString(this.FirstName);
        dest.writeString(this.lastName);
        dest.writeString(this.FatherName);
        dest.writeString(this.MotherName);
        dest.writeString(this.DateOfBirth);
        dest.writeString(this.nationalIdNo);
        dest.writeString(this.Height);
        dest.writeString(this.weight);
        dest.writeString(this.PresentAddress);
        dest.writeString(this.PermanentAddress);
        dest.writeString(this.passportno);
        dest.writeString(this.issuedate);
        dest.writeString(this.issueplace);
        dest.writeString(this.dateexpire);
        dest.writeString(this.ProfessionAsPassport);
        dest.writeString(this.PassportSizePhoto);
        dest.writeString(this.FullSizePhoto);
    }

    public Model() {
    }

    protected Model(Parcel in) {
        this.ExpectedCountryList = in.createStringArrayList();
        this.JobsList = in.createStringArrayList();
        this.ApplideJobsList = new ArrayList<Long>();
        in.readList(this.ApplideJobsList, Long.class.getClassLoader());
        this.FirstName = in.readString();
        this.lastName = in.readString();
        this.FatherName = in.readString();
        this.MotherName = in.readString();
        this.DateOfBirth = in.readString();
        this.nationalIdNo = in.readString();
        this.Height = in.readString();
        this.weight = in.readString();
        this.PresentAddress = in.readString();
        this.PermanentAddress = in.readString();
        this.passportno = in.readString();
        this.issuedate = in.readString();
        this.issueplace = in.readString();
        this.dateexpire = in.readString();
        this.ProfessionAsPassport = in.readString();
        this.PassportSizePhoto = in.readString();
        this.FullSizePhoto = in.readString();
    }

    public static final Parcelable.Creator<Model> CREATOR = new Parcelable.Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel source) {
            return new Model(source);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };
}
