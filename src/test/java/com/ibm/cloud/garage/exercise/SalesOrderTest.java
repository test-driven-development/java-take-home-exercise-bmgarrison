package com.ibm.cloud.garage.exercise;

import com.ibm.cloud.garage.Product;
import com.ibm.cloud.garage.SalesOrder;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SalesOrderTest {

    @Test
    public void emptyProductsListTest() {
        List<Product> products = new ArrayList<>();
        SalesOrder salesOrder = new SalesOrder();
        String report = salesOrder.createSalesOrder(products);
        Assert.assertEquals("\nSales Taxes: 0.00\nTotal: 0.00", report);
        Assert.assertEquals(0.00, salesOrder.getTotalTaxes(), 0);
        Assert.assertEquals(0.00, salesOrder.getTotalPrice(), 0);
    }

    @Test
    public void oneItemNonTaxExemptNonImportTest() {
        List<Product> products = new ArrayList<>();
        Product product = new Product(1, "playstation", 300.43, false, false);
        products.add(product);
        SalesOrder salesOrder = new SalesOrder();
        String report = salesOrder.createSalesOrder(products);
        Assert.assertEquals("1 playstation: 330.48\n\nSales Taxes: 30.05\nTotal: 330.48", report);
        Assert.assertEquals(30.05, salesOrder.getTotalTaxes(), 0);
        Assert.assertEquals(330.48, salesOrder.getTotalPrice(), 0);
    }

    @Test
    public void oneItemNonExemptImportTest() {
        List<Product> products = new ArrayList<>();
        Product product = new Product(1, "cup", 5.00, true, false);
        products.add(product);
        SalesOrder salesOrder = new SalesOrder();
        String report = salesOrder.createSalesOrder(products);
        Assert.assertEquals("1 imported cup: 5.75\n\nSales Taxes: 0.75\nTotal: 5.75", report);
        Assert.assertEquals(0.75, salesOrder.getTotalTaxes(), 0);
        Assert.assertEquals(5.75, salesOrder.getTotalPrice(), 0);
    }

    @Test
    public void oneItemExemptImportTest() {
        List<Product> products = new ArrayList<>();
        Product product = new Product(1, "tea", 11.25, true, true);
        products.add(product);
        SalesOrder salesOrder = new SalesOrder();
        String report = salesOrder.createSalesOrder(products);
        Assert.assertEquals("1 imported tea: 11.80\n\nSales Taxes: 0.55\nTotal: 11.80", report);
        Assert.assertEquals(0.55, salesOrder.getTotalTaxes(), 0);
        Assert.assertEquals(11.80, salesOrder.getTotalPrice(), 0);
    }

    @Test
    public void multiItemTest() {
        List<Product> products = new ArrayList<>();
        Product product = new Product(1, "playstation", 300.43, false, false);
        Product productTwo = new Product(2, "xbox", 249.99, false, false);
        products.add(product);
        products.add(productTwo);
        SalesOrder salesOrder = new SalesOrder();
        String report = salesOrder.createSalesOrder(products);
        Assert.assertEquals("1 playstation: 330.48\n2 xbox: 549.98\n\nSales Taxes: 80.05\nTotal: 880.46", report);
        Assert.assertEquals(80.05, salesOrder.getTotalTaxes(), 0);
        Assert.assertEquals(880.46, salesOrder.getTotalPrice(), 0);
    }
}
