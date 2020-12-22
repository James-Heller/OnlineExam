package edu.JamesTang.onlineExam.Model.entity;

import java.io.Serializable;

/**
 * @author JamesTang
 * @date 2020/12/20 22:04
 */

public class User implements Serializable {

    private String ID;
    private String Password;
    private boolean isAdmin;
    private String Name;
    private int Score;
    private String Class;

    public User(String ID,String Password,String Name, int Score, String Class, boolean isAdmin){

        this.ID=ID;
        this.Password=Password;
        this.Name=Name;
        this.Score=Score;
        this.Class=Class;
        this.isAdmin=isAdmin;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPassword() {
        return Password;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean getAdmin(){
        return isAdmin;
    }
}
