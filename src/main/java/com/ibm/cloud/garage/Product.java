package com.ibm.cloud.garage;

public class Product {
    private int quantity;
    private String name;
    private double price;
    private boolean isImport;
    private boolean isBasicTaxExempt;

   public Product(int quantity, String name, double price, boolean isImport, boolean isBasicTaxExempt){
       this.quantity = quantity;
       this.name = name;
       this.price = price;
       this.isImport = isImport;
       this.isBasicTaxExempt = isBasicTaxExempt;
   }

    public int getQuantity() {
        return this.quantity;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public boolean isImport(){
       return this.isImport;
    }

    public boolean isBasicTaxExempt(){
        return this.isBasicTaxExempt;
    }
}
