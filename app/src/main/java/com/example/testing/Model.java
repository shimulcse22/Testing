package com.example.testing;


import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Calendar;


public class Model implements Parcelable {
    private static Model model;

    public static Model newInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    private ArrayList<String> country;
    private ArrayList<String> job;
    private String name;
    private String fathername;
    private String mothername;
    private String dateofbirth;
    private String height;
    private String weight;
    private String presentadreess;
    private String permanentaddress;
    private String passportno=null;
    private String issuedate=null;
    private String issueplace=null;
    private String dateexpire=null;
    private String profession=null;
    private String im1;
    private String im2;


    public static Model getModel() {
        return model;
    }

    public static void setModel(Model model) {
        Model.model = model;
    }

    public ArrayList<String> getCountry() {
        return country;
    }

    public void setCountry(ArrayList<String> country) {
        this.country = country;
    }

    public ArrayList<String> getJob() {
        return job;
    }

    public void setJob(ArrayList<String> job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getMothername() {
        return mothername;
    }

    public void setMothername(String mothername) {
        this.mothername = mothername;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPresentadreess() {
        return presentadreess;
    }

    public void setPresentadreess(String presentadreess) {
        this.presentadreess = presentadreess;
    }

    public String getPermanentaddress() {
        return permanentaddress;
    }

    public void setPermanentaddress(String permanentaddress) {
        this.permanentaddress = permanentaddress;
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getIm1() {
        return im1;
    }

    public void setIm1(String im1) {
        this.im1 = im1;
    }

    public String getIm2() {
        return im2;
    }

    public void setIm2(String im2) {
        this.im2 = im2;
    }

    @Override
    public String toString() {
        return "Model{" +
                "country=" + country +
                ", job=" + job +
                ", name='" + name + '\'' +
                ", fathername='" + fathername + '\'' +
                ", mothername='" + mothername + '\'' +
                ", dateofbirth='" + dateofbirth + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", presentadreess='" + presentadreess + '\'' +
                ", permanentaddress='" + permanentaddress + '\'' +
                ", passportno='" + passportno + '\'' +
                ", issuedate='" + issuedate + '\'' +
                ", issueplace='" + issueplace + '\'' +
                ", dateexpire='" + dateexpire + '\'' +
                ", profession='" + profession + '\'' +
                ", im1=" + im1 +
                ", im2=" + im2 +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(this.country);
        dest.writeStringList(this.job);
        dest.writeString(this.name);
        dest.writeString(this.fathername);
        dest.writeString(this.mothername);
        dest.writeString(this.dateofbirth);
        dest.writeString(this.height);
        dest.writeString(this.weight);
        dest.writeString(this.presentadreess);
        dest.writeString(this.permanentaddress);
        dest.writeString(this.passportno);
        dest.writeString(this.issuedate);
        dest.writeString(this.issueplace);
        dest.writeString(this.dateexpire);
        dest.writeString(this.profession);
        dest.writeString(this.im1);
        dest.writeString(this.im2);
    }

    public Model() {
    }

    protected Model(Parcel in) {
        this.country = in.createStringArrayList();
        this.job = in.createStringArrayList();
        this.name = in.readString();
        this.fathername = in.readString();
        this.mothername = in.readString();
        this.dateofbirth = in.readString();
        this.height = in.readString();
        this.weight = in.readString();
        this.presentadreess = in.readString();
        this.permanentaddress = in.readString();
        this.passportno = in.readString();
        this.issuedate = in.readString();
        this.issueplace = in.readString();
        this.dateexpire = in.readString();
        this.profession = in.readString();
        this.im1 = in.readString();
        this.im2 = in.readString();
    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {
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
