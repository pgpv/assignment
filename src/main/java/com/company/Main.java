package com.company;

import com.company.Items.Inventory;
import com.company.Items.Products;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        ObjectMapper objectMapper = new ObjectMapper();
        Inventory inventory = new Inventory();
        Products products = new Products();

        System.out.println("welcome to company's warehouse management tool\n" +
                "please insert your command:");

        while (true) {
            String command = scanner.next();
            String[] commands = command.split(" ");

            if (commands[0].compareTo("help") == 0) {
                System.out.println("load prod filename\n" +
                        "load inv filename\n" +
                        "sell product_name\n" +
                        "list prod\n" +
                        "list inv\n" +
                        "exit");
            }

            if (commands[0].compareTo("exit") == 0) {
                break;
            }
        }

        return;
    }
}
