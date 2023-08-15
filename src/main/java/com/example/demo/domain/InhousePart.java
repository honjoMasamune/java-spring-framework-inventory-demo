package com.example.demo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@DiscriminatorValue("1")
public class InhousePart extends Part{
    int partId;

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

    public InhousePart() {
        this.inhousePartCheck = "Yes";
    }

    public InhousePart(String name, String inhousePartCheck,double price, int inv, int minPartValue, int maxPartValue) {
        this.name = name;
        this.inhousePartCheck = inhousePartCheck;
        this.price = price;
        this.inv = inv;
        this.minPartValue = minPartValue;
        this.maxPartValue = maxPartValue;
    }

    public InhousePart(int partId, String name, String inhousePartCheck,double price, int inv, int minPartValue, int maxPartValue) {
        this.partId = partId;
        this.name = name;
        this.inhousePartCheck = inhousePartCheck;
        this.price = price;
        this.inv = inv;
        this.minPartValue = minPartValue;
        this.maxPartValue = maxPartValue;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getInhousePartCheck() {
        return inhousePartCheck;
    }

    @Override
    public void setInhousePartCheck(String inhousePartCheck) {
        this.inhousePartCheck = inhousePartCheck;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int getInv() {
        return inv;
    }

    @Override
    public void setInv(int inv) {
        this.inv = inv;
    }

    @Override
    public int getMinPartValue() {
        return minPartValue;
    }

    @Override
    public void setMinPartValue(int minPartValue) {
        this.minPartValue = minPartValue;
    }

    @Override
    public int getMaxPartValue() {
        return maxPartValue;
    }

    @Override
    public void setMaxPartValue(int maxPartValue) {
        this.maxPartValue = maxPartValue;
    }

    @Override
    public String toString() {
        return name;
    }
}
