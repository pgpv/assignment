package com.company;

import com.company.Items.Inventory;
import com.company.Items.Products;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        Inventory inventory = new Inventory();
        Products products = new Products();

        System.out.println(Messages.WELCOME);

        while (true) {
            String command = scanner.next();
            String[] commands = command.split(" ");

            if (commands[0].compareTo("help") == 0) {
                System.out.println(Messages.HELP);

            } else if (commands[0].compareTo("load") == 0 && commands.length > 2) {
                if (commands[1].compareTo("inv") == 0) {
                    inventory = loadInventory(inventory, commands[2]);
                    System.out.println(Messages.LOADED_INV);

                } else if (commands[1].compareTo("prod") == 0) {
                    products = loadProducts(products, commands[2]);
                    System.out.println(Messages.LOADED_PROD);
                }

            } else if (commands[0].compareTo("list") == 0 && commands.length > 1) {
                if (commands[1].compareTo("inv") == 0) {
                    inventory.print();

                } else if (commands[1].compareTo("prod") == 0) {
                    products.print();
                }

            } else if (commands[0].compareTo("exit") == 0) {
                break;
            }
        }
        return;
    }

    static public Inventory loadInventory(Inventory inventory, String filename) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            inventory = objectMapper.readValue(new File("src/main/resources/" + filename), Inventory.class);
        } catch (IOException e) {
            System.err.println("error loading inventory from " + filename);
            e.printStackTrace();
        }

        return inventory;
    }

    static public Products loadProducts(Products products, String filename) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            products = objectMapper.readValue(new File("src/main/resources/" + filename), Products.class);
        } catch (IOException e) {
            System.err.println("error loading products from " + filename);
            e.printStackTrace();
        }

        return products;
    }
}
