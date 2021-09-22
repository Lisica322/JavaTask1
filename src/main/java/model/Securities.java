package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Securities {
    private String name;
    private ArrayList<String> currency;
    private String code;
    private LocalDate date;

    public String getName() {
        return name;
    }

    public ArrayList<String> getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Securities{" +
                "name='" + name + '\'' +
                ", currency=" + currency +
                ", code='" + code + '\'' +
                ", date=" + date +
                '}';
    }
}