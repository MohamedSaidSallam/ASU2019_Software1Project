package com.company.cinema;

public enum ViewingOption {
    Normal("Normal",30),
    IMAX("IMAX",100),
    Dolby("Dolby",60),
    VIP("VIP",80);

    private String name;
    private int price;

    ViewingOption(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}