/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManager;

/**
 *
 * @author yazan
 */
// Add CategoryProduct subclass extending Product
public class CategoryProduct extends Product {
    private Category category;

    public CategoryProduct(String id, String name, double price, int quantity, Category category) {
        super(id, name, price, quantity);
        this.category = category;
    }

    public Category getCategory() { return category; }

    @Override
    public String getProductType() {
        return category.getName();
    }
}
