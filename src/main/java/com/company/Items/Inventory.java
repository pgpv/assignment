package com.company.Items;

import java.util.List;

public class Inventory {
    private List<Article> inventory;

    public Inventory() {
    }

    public Inventory(List<Article> inventory) {
        this.inventory = inventory;
    }

    public void print(){
        inventory.forEach( article -> {
            article.print();
            System.out.println();
        });
    }

    public List<Article> getInventory() {
        return inventory;
    }

    public void setInventory(List<Article> inventory) {
        this.inventory = inventory;
    }
}
