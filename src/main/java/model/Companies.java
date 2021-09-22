package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Companies {
    private String id;
    private String nameCompany;
    private String address;
    private String phoneNumber;
    private String inn;
    private LocalDate founded;
    private ArrayList<Securities> securities;

    public String getId() {
        return id;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getInn() {
        return inn;
    }

    public LocalDate getFounded() {
        return founded;
    }

    public String getFormatedFounded(String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return founded.format(formatter);
    }

    public ArrayList<Securities> getSecurities() {
        return securities;
    }

    @Override
    public String toString() {
        return "Companies{" +
                "id='" + id + '\'' +
                ", nameCompany='" + nameCompany + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", inn='" + inn + '\'' +
                ", founded=" + founded +
                ", securities=" + securities +
                '}';
    }
}