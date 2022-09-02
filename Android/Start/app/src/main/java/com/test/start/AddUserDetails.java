package com.test.start;

public class AddUserDetails {

    String value, am, cmnt;

    public AddUserDetails(String value, String am, String cmnt) {
        this.value = value;
        this.am = am;
        this.cmnt = cmnt;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAm() {
        return am;
    }

    public void setAm(String am) {
        this.am = am;
    }

    public String getCmnt() {
        return cmnt;
    }

    public void setCmnt(String cmnt) {
        this.cmnt = cmnt;
    }
}
