package com.example.demo.models;

public class Opskrifter {

    private String name;
    private String url;
    private String text;

    public Opskrifter(String name, String url, String text) {
        this.name = name;
        this.url = url;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}