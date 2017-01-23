package com.example.indianic1.sqlitedemo.model;

/**
 * Created by indianic1 on 06/01/16.
 */
public class CustomerModel {
    private String ID;
    private String Name;
    private String Phone;

    public CustomerModel() {
    }

    public CustomerModel(String ID, String name, String phone) {
        this.ID = ID;
        Name = name;
        Phone = phone;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
