package com.company;

public class ContainedArticles {
    private int art_id;
    private int amount_of;

    public ContainedArticles() {
    }

    public ContainedArticles(int art_id, int amount_of) {
        this.art_id = art_id;
        this.amount_of = amount_of;
    }

    public void print(){
        System.out.println(art_id);
        System.out.println(amount_of);
    }

    public int getArt_id() {
        return art_id;
    }

    public int getAmount_of() {
        return amount_of;
    }

    public void setArt_id(int art_id) {
        this.art_id = art_id;
    }

    public void setAmount_of(int amount_of) {
        this.amount_of = amount_of;
    }
}
