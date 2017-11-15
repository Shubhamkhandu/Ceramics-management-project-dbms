package com.example.sg_22.ceramics2;

/**
 * Created by SG-22 on 10/29/2017.
 */

public class Customers {
    //private variables
    int _customer_id;
    String _first_name;
    String _last_name;
    String _email_id;
    String _contact;
    String _address;
    String _city;
    String _state;
    String _country;
    String _pin;
    static int i = 1;
    // Empty constructor
    public Customers(){

    }
    // constructor
    public Customers(int customer_id, String first_name, String last_name, String email_id,
                     String contact, String address, String city, String state,
                     String country, String pin){
        this._customer_id = customer_id;
        this._first_name = first_name;
        this._last_name = last_name;
        this._email_id = email_id;
        this._contact = contact;
        this._address = address;
        this._city = city;
        this._state = state;
        this._country = country;
        this._pin = pin;
    }

    // constructor
    public Customers(String first_name, String last_name, String email_id,
                     String contact, String address, String city, String state,
                     String country, String pin){
        this._first_name = first_name;
        this._last_name = last_name;
        this._email_id = email_id;
        this._contact = contact;
        this._address = address;
        this._city = city;
        this._state = state;
        this._country = country;
        this._pin = pin;
    }
    // getting ID
    public int getID(){
        return this._customer_id;
    }

    // setting id
    public void setID(int customer_id){
        this._customer_id = i;
        i++;
    }

    // getting name
    public String getfirstName(){
        return this._first_name;
    }

    // setting name
    public void setfirstName(String firstname){
        this._first_name = firstname;
    }

    public String getlastName(){
        return this._last_name;
    }

    // setting name
    public void setlastName(String lastname){
        this._last_name = lastname;
    }

    public String getemailid(){
        return this._email_id;
    }

    // setting name
    public void setemailid(String emaiid){
        this._email_id = emaiid;
    }

    // getting phone number
    public String getContact(){
        return this._contact;
    }

    // setting phone number
    public void setContact(String contact){
        this._contact = contact;
    }

    public String getaddress(){
        return this._address;
    }

    // setting name
    public void setaddress(String address){
        this._address = address;
    }

    public String getcity(){
        return this._city;
    }

    // setting name
    public void setcity(String city){
        this._city = city;
    }

    public String getstate(){
        return this._state;
    }

    // setting name
    public void setstate(String state){
        this._state = state;
    }

    public String getcountry(){
        return this._country;
    }

    // setting name
    public void setcountry(String country){
        this._country = country;
    }

    public String getpin(){
        return this._pin;
    }

    // setting name
    public void setpin(String pin){
        this._pin = pin;
    }

}
