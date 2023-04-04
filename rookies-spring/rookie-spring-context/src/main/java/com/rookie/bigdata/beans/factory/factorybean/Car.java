package com.rookie.bigdata.beans.factory.factorybean;

/**
 * @Class Car
 * @Description TODO
 * @Author rookie
 * @Date 2023/4/1 13:21
 * @Version 1.0
 */
public class Car {
    private String brand;
    private int maxSpeed;
    private Double price;
    // get/set


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
