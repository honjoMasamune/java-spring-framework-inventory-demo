package com.example.demo.domain;

import com.example.demo.validators.ValidDeletePart;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@ValidDeletePart
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="part_type",discriminatorType = DiscriminatorType.INTEGER)
@Table(name="Parts")
public abstract class Part implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    String inhousePartCheck;
    @Min(value = 0, message = "Price value must be positive")
    double price;
    @Min(value = 0, message = "Inventory value must be positive")
    int inv;
    @Min(value = 0, message = "Inventory value must be positive")
    int minPartValue;
    @Max(value = 9999, message = "Inventory can't exceed 9999")
    int maxPartValue;


    @ManyToMany
    @JoinTable(name="product_part", joinColumns = @JoinColumn(name="part_id"),
            inverseJoinColumns=@JoinColumn(name="product_id"))
    Set<Product> products= new HashSet<>();

    public Part() {
        this.inhousePartCheck = "No";
    }

    public Part(String name, String inhousePartCheck, double price, int inv, int minPartValue, int maxPartValue) {
        this.name = name;
        this.inhousePartCheck = inhousePartCheck;
        this.price = price;
        this.inv = inv;
        this.minPartValue = minPartValue;
        this.maxPartValue = maxPartValue;
    }

    public Part(long id, String name, double price, int inv, int minPartValue, int maxPartValue) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.minPartValue = minPartValue;
        this.maxPartValue = maxPartValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInhousePartCheck() {
        return inhousePartCheck;
    }

    public void setInhousePartCheck(String inhousePartCheck) {
        this.inhousePartCheck = inhousePartCheck;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInv() {
        return inv;
    }

    public void setInv(int inv) {
        this.inv = inv;
    }

    // CC-2023-08-015
    public int getMinPartValue() {
        return minPartValue;
    }

    public void setMinPartValue(int minPartValue) {
        this.minPartValue = minPartValue;
    }

    public int getMaxPartValue() {
        return maxPartValue;
    }

    public void setMaxPartValue(int maxPartValue) {
        this.maxPartValue = maxPartValue;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String toString(){
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Part part = (Part) o;

        return id == part.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
