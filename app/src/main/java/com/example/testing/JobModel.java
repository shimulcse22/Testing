package com.example.testing;

import java.util.Locale;

public class JobModel {
    private Long JobID;
    private Long organizationID;
    private String Name_En;
    private String Name_Bn;
    private Long code;

    public Long getJobID() {
        return JobID;
    }

    public void setJobID(Long jobID) {
        JobID = jobID;
    }

    public Long getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(Long organizationID) {
        this.organizationID = organizationID;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName_En() {
        return Name_En;
    }

    public void setName_En(String name_En) {
        Name_En = name_En;
    }

    public String getName_Bn() {
        return Name_Bn;
    }

    public void setName_Bn(String name_Bn) {
        Name_Bn = name_Bn;
    }
}
