package com.company.Items;

import java.util.List;

public class Products {
    private List<Product> products;

    public Products() {
    }

    public Products(List<Product> products) {
        this.products = products;
    }

    public void print(){
        products.forEach( product -> {
            product.print();
            System.out.println();
        });
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}