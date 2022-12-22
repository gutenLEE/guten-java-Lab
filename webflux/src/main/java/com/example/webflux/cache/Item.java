package com.example.webflux.cache;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * @author gutenlee
 * @since 2022/12/22
 */
@Document
public class Item {

    @Id
    private String _id;
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Item() {
    }

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}