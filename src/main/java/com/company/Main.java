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

            if (commands[0].compareToIgnoreCase("help") == 0) {
                System.out.println(Messages.HELP);

            } else if (commands[0].compareToIgnoreCase("load") == 0 && commands.length > 2) {
                if (commands[1].compareToIgnoreCase("inv") == 0) {
                    inventory = loadInventory(inventory, commands[2]);
                    if( inventory.getInventory() != null ) System.out.println( Messages.LOADED_INV );
                    else System.out.println( Messages.NOT_LOADED_INV );

                } else if (commands[1].compareToIgnoreCase("prod") == 0) {
                    products = loadProducts(products, commands[2]);
                    if( products.getProducts() != null ) System.out.println(Messages.LOADED_PROD);
                    else System.out.println( Messages.NOT_LOADED_PROD );
                }

            } else if (commands[0].compareToIgnoreCase("list") == 0 && commands.length > 1) {
                if (commands[1].compareToIgnoreCase("inv") == 0) {
                    inventory.print();

                } else if (commands[1].compareToIgnoreCase("prod") == 0) {
                    products.print(inventory);
                }

            } else if (commands[0].compareToIgnoreCase("sell") == 0 && commands.length > 1) {
                String productName = command.split(" ", 2)[1];
                if (sellProduct(products, inventory, productName, 1)) System.out.println(Messages.SOLD);
                 else System.out.println(Messages.NOT_SOLD);

            } else if (commands[0].compareToIgnoreCase("exit") == 0) {
                break;

            } else {
                System.out.println(Messages.UNRECOGNISED_COMMAND);
            }
        }
        return;
    }

    static public boolean sellProduct(Products products, Inventory inventory, String productName, int quantity) {
        return products.sellProduct(inventory, productName, quantity);
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
