package com.example.reminderapp;

public class Medicine {
    private int image;
    private String medicine;
    private String description;
    private String price;

    public Medicine(){}


    public Medicine(int image, String medicine, String description, String price) {
        this.image = image;
        this.medicine = medicine;
        this.description = description;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
