package com.example.demo.models;

public class Opskrifter {

    private String ingrediens1;
    private String ingrediens2;
    private String ingrediens3;
    private String ingrediens4;
    private String ingrediens5;

    public Opskrifter(String ingrediens1, String ingrediens2, String ingrediens3, String ingrediens4, String ingrediens5) {
        this.ingrediens1 = ingrediens1;
        this.ingrediens2 = ingrediens2;
        this.ingrediens3 = ingrediens3;
        this.ingrediens4 = ingrediens4;
        this.ingrediens5 = ingrediens5;
    }

    public String getIngrediens1() {
        return ingrediens1;
    }

    public String getIngrediens2() {
        return ingrediens2;
    }

    public String getIngrediens3() {
        return ingrediens3;
    }

    public String getIngrediens4() {
        return ingrediens4;
    }

    public String getIngrediens5() {
        return ingrediens5;
    }
}
