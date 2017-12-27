package com.example.user.e_commerceproductsstorage.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by SHOVON on 12/26/2017.
 */

public class Product implements Serializable{

    private int productID;
    private String productName;
    private String productDescription;
    private String productPrice;
    private String productImage;
    private String productRating;

    public Product(String productName, String productDescription, String productPrice) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public Product(String productName, String productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Product(int productID, String productName, String productDescription, String productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public String getProductRating() {
        return productRating;
    }

    public void setProductRating(String productRating) {
        this.productRating = productRating;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

}
