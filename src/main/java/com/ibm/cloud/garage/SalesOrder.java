package com.ibm.cloud.garage;

import java.text.DecimalFormat;
import java.util.List;

public class SalesOrder {
    private Double totalTaxes = 0.00;
    private Double totalPrice = 0.00;

    public String createSalesOrder(List<Product> products) {
        DecimalFormat df = new DecimalFormat("0.00");
        StringBuilder stringBuilder = new StringBuilder();

        for (Product product : products){
            double taxAmount = SalesTaxCalculator.calculateTaxes(product.isImport(), product.isBasicTaxExempt(), product.getPrice()*product.getQuantity());
            double priceWithTax = product.getQuantity()*product.getPrice() + taxAmount;

            totalTaxes += taxAmount;
            totalPrice += priceWithTax;

            if(product.isImport()){
                stringBuilder.append(product.getQuantity() + " imported " + product.getName() + ": " + df.format(priceWithTax) + "\n");
            }
            else {
                stringBuilder.append(product.getQuantity() + " " + product.getName() + ": " + df.format(priceWithTax) + "\n");
            }
        }

        stringBuilder.append("\n");
        stringBuilder.append("Sales Taxes: " + df.format(totalTaxes) + "\n");
        stringBuilder.append("Total: " + df.format(totalPrice));

        String outputString = stringBuilder.toString();

        return outputString;


    }

    public Double getTotalTaxes() {
        return this.totalTaxes;
    }

    public Double getTotalPrice() {
        return this.totalPrice;
    }
}
