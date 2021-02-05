package com.company.Items;

import java.util.List;

public class Inventory {
    private List<Article> inventory;

    public Inventory() {
    }

    public Inventory(List<Article> inventory) {
        this.inventory = inventory;
    }

    public void print() {
        if (inventory != null) {
            inventory.forEach(article -> {
                article.print();
                System.out.println();
            });
        }
    }

    public void decreaseArticle( String name, int quantity ){
        if (inventory != null) {
            inventory.forEach(article -> {
                if( article.getName().compareToIgnoreCase( name ) == 0 ) {
                    article.setStock( article.getStock() - quantity );
                }
            });
        }
    }

    public void decreaseArticle( int art_id, int quantity ){

        if (inventory != null) {
            inventory.forEach(article -> {
                if( article.getArt_id() == art_id ) {
                    article.setStock( article.getStock() - quantity );
                }
            });
        }
    }

    public List<Article> getInventory() {
        return inventory;
    }

    public void setInventory(List<Article> inventory) {
        this.inventory = inventory;
    }
}
