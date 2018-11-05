package com.ibm.cloud.garage;

public class SalesTaxCalculator {

    public static double calculateTaxes(boolean isImport, boolean isBasicTaxExempt, double price){
        double taxAmount = 0;

        if(!isBasicTaxExempt){
            taxAmount = (price*10)/100;
        }

        if(isImport){
            taxAmount += (price*5)/100;
        }
        return rounder(taxAmount);
    }

    public static double rounder(double tax){return Math.round(tax * 100.0 / 5.0) * 5.0 / 100.0;}
}
