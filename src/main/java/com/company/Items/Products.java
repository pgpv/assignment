package com.company.Items;

import java.util.List;

public class Products {
    private List<Product> products;

    public Products() {
    }

    public Products(List<Product> products) {
        this.products = products;
    }

    public void print(Inventory inventory) {
        if (products != null) {
            products.forEach(product -> {
                product.print();
                System.out.println("available stock: " + getAvailableStock(inventory, product));
                System.out.println();
            });
        }
    }

    public void sellProduct(Inventory inventory, String productName, int quantity) {

        if (products != null) {
            products.forEach(product -> {
                if (product.getName().compareToIgnoreCase(productName) == 0) {
                    int availableStock = getAvailableStock(inventory, product);

                    if (availableStock >= quantity) {
                        product.getContain_articles().forEach(containedArticle -> {
                            inventory.decreaseArticle(containedArticle.getArt_id(), quantity * containedArticle.getAmount_of());
                        });
                    }
                }
            });
        }
    }

    private int getAvailableStock(Inventory inventory, String productName) {
        int availableStock = 0;

        for (Product product : products) {
            if (product.getName().compareToIgnoreCase(productName) == 0) {
                availableStock = getAvailableStock(inventory, product);
            }
        }

        return availableStock;
    }

    private int getAvailableStock(Inventory inventory, Product product) {
        int availableStock = -1;

        for (ContainedArticle containedArticle : product.getContain_articles()) {
            for (Article article : inventory.getInventory()) {

                if (containedArticle.getArt_id() == article.getArt_id()) {
                    int tempStock = 0;

                    if (article.getStock() > 0 && containedArticle.getAmount_of() > 0) {
                        tempStock = article.getStock() / containedArticle.getAmount_of();
                    }

                    if (availableStock == -1) {
                        availableStock = tempStock;
                    } else if (tempStock < availableStock) {
                        availableStock = tempStock;
                    }

                    break;
                }
            }

            if (availableStock == 0) {
                break;
            }
        }

        return availableStock;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
