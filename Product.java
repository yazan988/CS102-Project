/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManager;

/**
 *
 * @author yazan
 */
  // Create abstract Product class to enforce abstraction and encapsulation
public abstract class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;

    public Product(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Encapsulation: Getters & Setters
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    // Polymorphism
    public abstract String getProductType();

    @Override
    public String toString() {
        return "[" + getProductType() + "] " +
                name + " | ID: " + id +
                " | Price: " + price +
                " | Qty: " + quantity;
    }
}
