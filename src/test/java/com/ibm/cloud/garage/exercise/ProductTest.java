package com.ibm.cloud.garage.exercise;

import com.ibm.cloud.garage.Product;
import org.junit.Test;
import org.junit.Assert;

public class ProductTest {

    @Test
  public void testProductCreated() {
        Product product = new Product(1, "playstation", 300.43, false, false);
        Assert.assertEquals(1, product.getQuantity());
        Assert.assertEquals("playstation", product.getName());
        Assert.assertEquals(300.43, product.getPrice(), 0);
        Assert.assertFalse(product.isImport());
        Assert.assertFalse(product.isBasicTaxExempt());
    }
}
