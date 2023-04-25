package com.ctu.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserReceiveDTO {
    private String userPhone;
    private String userAvt;
    private String userDisplayname;
    private String userBio;

    public UserReceiveDTO() {}

    @JsonIgnore
    public boolean isUpdatable(){
        if (this.userPhone != null) {
            return true;
        }
        if (this.userAvt != null) {
            return true;
        }
        if (this.userDisplayname != null) {
            return true;
        }
        if (this.userBio != null) {
            return true;
        }
        return false;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAvt() {
        return userAvt;
    }

    public void setUserAvt(String userAvt) {
        this.userAvt = userAvt;
    }

    public String getUserDisplayname() {
        return userDisplayname;
    }

    public void setUserDisplayname(String userDisplayname) {
        this.userDisplayname = userDisplayname;
    }

    public String getUserBio() {
        return userBio;
    }

    public void setUserBio(String userBio) {
        this.userBio = userBio;
    }

    

    
}
