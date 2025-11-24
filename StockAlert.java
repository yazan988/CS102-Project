/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManager;

/**
 *
 * @author yazan
 */

//  Add StockAlert class to notify low quantity
public class StockAlert {
    private Product product;
    private int threshold;

    public StockAlert(Product product, int threshold) {
        this.product = product;
        this.threshold = threshold;
    }

    public boolean isLow() {
        return product.getQuantity() <= threshold;
    }

    public boolean isOutOfStock() {
        return product.getQuantity() == 0;
    }

    @Override
    public String toString() {
        if (isOutOfStock()) {
            return " OUT OF STOCK: " + product.getName() + "  Qty: 0";
        }
        if (isLow()) {
            return " LOW STOCK: " + product.getName() +
                   " | Qty: " + product.getQuantity();
        }
        return product.getName() + " stock is OK.";
    }
}
