/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author yazan
 */
public class InventoryManager {
    private static ArrayList<Product> products = new ArrayList<>();
    private static HashMap<String, Category> categories = new HashMap<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        seedData();

        int choice;
        do {
            System.out.println("\n   INVENTORY MANAGER   ");
            System.out.println("1- Add Product");
            System.out.println("2- View All Products");
            System.out.println("3- Check Stock Alerts");
            System.out.println("4- Remove Product");
            System.out.println("5- Exit");
            System.out.print("Choose: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> addProduct(input);
                case 2 -> viewProducts();
                case 3 -> checkAlerts();
                case 4 -> removeProduct(input);
                case 5 -> System.out.println("Goodbye <3");
                default -> System.out.println("Invalid choice ;{");
            }
        } while (choice != 5);
    }

    private static void addProduct(Scanner input) {
        System.out.print("Product ID: ");
        String id = input.nextLine();

        System.out.print("Name: ");
        String name = input.nextLine();

        System.out.print("Price: ");
        double price = input.nextDouble();

        System.out.print("Quantity: ");
        int qty = input.nextInt();
        input.nextLine();

        System.out.print("Category Name: ");
        String catName = input.nextLine();

        Category cat = categories.get(catName);
        if (cat == null) {
            System.out.print("Category description: ");
            String desc = input.nextLine();
            cat = new Category(catName, desc);
            categories.put(catName, cat);
        }

        Product p = new CategoryProduct(id, name, price, qty, cat);
        products.add(p);

        System.out.println("Product Added Successfully ");
    }

    private static void viewProducts() {
        System.out.println("  PRODUCT LIST  ");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    private static void checkAlerts() {
        System.out.println("  STOCK ALERTS  ");
        for (Product p : products) {
            StockAlert alert = new StockAlert(p, 5);
            if (alert.isLow() || alert.isOutOfStock())
                System.out.println(alert);
        }
    }

    private static void removeProduct(Scanner input) {
        System.out.print("Enter Product ID to remove: ");
        String id = input.nextLine();

        Product toRemove = null;

        for (Product p : products) {
            if (p.getId().equalsIgnoreCase(id)) {
                toRemove = p;
                break;
            }
        }

        if (toRemove != null) {
            products.remove(toRemove);
            System.out.println("Product '" + toRemove.getName() + "' removed successfully.");
        } else {
            System.out.println("Product with ID " + id + " not found!");
        }
    }

    private static void seedData() {
        Category electronics = new Category("Electronics", "Devices & gadgets");
        Category food = new Category("Food", "Snacks & ingredients");

        categories.put("Electronics", electronics);
        categories.put("Food", food);

        products.add(new CategoryProduct("P001", "Laptop", 3500, 3, electronics));
        products.add(new CategoryProduct("P002", "Chocolate", 8, 25, food));
        products.add(new CategoryProduct("P003", "Headphones", 150, 0, electronics));
    }
}
