package com.example.projectproject;

public class MODEL {
    String productimage,productname,productquantity,productprice;
    /*int productquantity,productprice;*/

    public MODEL() {
    }

    public MODEL(String productimage, String productname, String productquantity, String productprice) {
        this.productimage = productimage;
        this.productname = productname;
        this.productquantity = productquantity;
        this.productprice = productprice;
    }

    public String getProductimage() {
        return productimage;
    }

    public void setProductimage(String productimage) {
        this.productimage = productimage;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductquantity() {
        return productquantity;
    }

    public void setProductquantity(String productquantity) {
        this.productquantity = productquantity;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }
}
