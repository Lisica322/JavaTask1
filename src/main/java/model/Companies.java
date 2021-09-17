package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Companies {
    String id;
    String nameCompany;
    String address;
    String phoneNumber;
    String inn;
    LocalDate founded;
    ArrayList<Securities> securities;

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

    public ArrayList<Securities> getFilterSecurities() {
        LocalDate today = LocalDate.now();
        securities.stream()
                .filter(s -> s.getDate().isBefore(today));
        return securities;
    }
}
