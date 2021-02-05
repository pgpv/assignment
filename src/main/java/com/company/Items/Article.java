package com.company.Items;

public class Article {
    private String name;
    private int art_id;
    private int stock;

    public Article() {
    }

    public Article(String name, int art_id, int stock) {
        this.name = name;
        this.art_id = art_id;
        this.stock = stock;
    }

    public void print(){
        System.out.println("name: " + name);
        System.out.println("art_id: " + art_id);
        System.out.println("stock: " + stock);
    }

    public String getName() {
        return name;
    }

    public int getArt_id() {
        return art_id;
    }

    public int getStock() {
        return stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArt_id(int art_id) {
        this.art_id = art_id;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
