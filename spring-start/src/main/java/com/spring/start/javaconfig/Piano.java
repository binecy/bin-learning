package com.spring.start.javaconfig;

public class Piano {
    private Integer price;
    private String brand;


    public Piano(Integer price, String brand) {
        this.price = price;
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
