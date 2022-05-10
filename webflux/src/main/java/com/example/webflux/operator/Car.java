package com.example.webflux.operator;

public class Car {

    String color;
    int seq;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", seq=" + seq +
                '}';
    }
}
