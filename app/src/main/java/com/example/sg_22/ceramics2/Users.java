package com.example.sg_22.ceramics2;

/**
 * Created by SG-22 on 10/29/2017.
 */

public class Users {
    int _user_id;
    String _username;
    String _password;

    // Empty constructor
    public Users(){

    }
    // constructor
    public Users(int user_id, String username, String password){
        this._user_id = user_id;
        this._username = username;
        this._password = password;
    }

    // constructor
    public Users(String username, String password){
        this._username = username;
        this._password = password;
    }
    // getting ID
    public int getUserID(){
        return this._user_id;
    }

    // setting id
    public void setUserID(int userid){
        this._user_id = userid;
    }

    // getting name
    public String getusername(){
        return this._username;
    }

    // setting name
    public void setusername(String username){
        this._username = username;
    }

    public String getpassword(){
        return this._password;
    }

    // setting name
    public void setpassword(String password){
        this._password = password;
    }

}
