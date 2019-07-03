package com.example.g10_excercise.userprofile;

import java.io.Serializable;

public class UserProfileModel implements Serializable {
    private String email;
    private String name;
    private String contact;
    private String imageURL;
    public String getImageURL() {
        return imageURL;
    }
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
    public String getContact() {
        return contact;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }


    public UserProfileModel(String email, String name, String contact, String imageURL) {
        this.email = email;
        this.name = name;
        this.contact = contact;
        this.imageURL = imageURL;
    }
}