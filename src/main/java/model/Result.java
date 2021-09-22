package model;

import java.util.List;

public class Result {
    private String id;
    private List<String> codes;

    public Result(String id, List<String> codes) {
        this.id = id;
        this.codes = codes;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id='" + id + '\'' +
                ", codes=" + codes +
                '}';
    }
}