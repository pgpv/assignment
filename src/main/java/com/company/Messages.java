package com.company;

public class Messages {
    public static String WELCOME = "welcome to company's warehouse management tool\n" +
            "please insert your command:";

    public static String HELP = "Load products file: load prod filename\n" +
            "Load inventory file: load inv filename\n" +
            "Sell product: sell product_name\n" +
            "List products: list prod\n" +
            "List inventory: list inv\n" +
            "Exit: exit";

    public static String SOLD = "product sold";
    public static String LOADED_INV = "loaded inventory";
    public static String LOADED_PROD = "loaded products";
    public static String UNRECOGNISED_COMMAND = "unrecognised command. please use help for a list of commands";
}
