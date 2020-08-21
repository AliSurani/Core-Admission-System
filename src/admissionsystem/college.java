/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admissionsystem;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class college {
    private String name, city, address, email, phone, password;
    private int year, strength, subs;
    private double male, female, fees;
    private boolean status;
    ArrayList<String> subjects;
    ArrayList<String> teachers;
    

    public college() {
        this.subjects = new ArrayList();
        this.teachers = new ArrayList();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setSubs(int subs) {
        this.subs = subs;
    }

    public void setMale(double male) {
        this.male = male;
    }

    public void setFemale(double female) {
        this.female = female;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public int getYear() {
        return year;
    }

    public int getStrength() {
        return strength;
    }

    public int getSubs() {
        return subs;
    }

    public double getMale() {
        return male;
    }

    public double getFemale() {
        return female;
    }

    public double getFees() {
        return fees;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }
    
}
