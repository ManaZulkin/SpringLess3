package com.tasks;

import java.io.Serializable;

public class Costumer implements Serializable {
     String name;
     String car;
     Double price;
     Integer count = 0;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Costumer{" +
                "name='" + name + '\'' +
                ", car='" + car + '\'' +
                ", price=" + price +
                '}';
    }

    public Costumer() {
    }

    public Costumer(String name, String car, Double price) {
        this.name = name;
        this.car = car;
        this.price = price;
    }
}
