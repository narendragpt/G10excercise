package com.example.g10_excercise.restapiexample;

public class RestDataModel {
    private String uriimage;
    private String firstname;
    private String email;

    public RestDataModel( String uriimage ,String firstname,  String email) {
        this.uriimage = uriimage;
        this.firstname = firstname;
        this.email = email; }

    public String getUriimage() { return uriimage; }
    public String getFirstname() { return firstname; }
    public String getEmail() { return email;}
   }
