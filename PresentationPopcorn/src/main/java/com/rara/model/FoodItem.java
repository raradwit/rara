package com.rara.model;

/**
 * Created by sparkle on 8/28/15.
 */
public class FoodItem {
    public FoodItem(int id, String foodName, int quantity, float price) {
        this.id = id;
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
    }

    public FoodItem() {
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String foodName;
    private int quantity;
    private float price;


}
