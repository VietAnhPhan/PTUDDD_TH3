package com.example.vietanhphan.lab032;

public class Contact {
    private int id;
    private String name;
    private String phoneNumber;
    public Contact(){

    }
public Contact(String name,String phoneNumber)
{
    this.name=name;
    this.phoneNumber=phoneNumber;
}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String toString(){
        return getName()+"  "+getPhoneNumber();
    }
}
