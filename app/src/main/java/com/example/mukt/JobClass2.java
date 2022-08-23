package com.example.mukt;

public class JobClass2 {

    String name;
    int logo;
    String orgName;
    int id;

    public JobClass2(String name, int logo, String orgName, int id) {
        this.name = name;
        this.logo = logo;
        this.orgName = orgName;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getLogo() {
        return logo;
    }

    public String getOrgName() {
        return orgName;
    }

    public int getId() {
        return id;
    }
}
