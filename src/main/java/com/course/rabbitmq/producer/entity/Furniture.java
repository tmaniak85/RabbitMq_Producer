package com.course.rabbitmq.producer.entity;

public class Furniture {

    private String color;

    private String material;

    private String name;

    private int price;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "color='" + color + '\'' +
                ", material='" + material + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
