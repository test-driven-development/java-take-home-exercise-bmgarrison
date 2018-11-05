package com.ibm.cloud.garage.exercise;

import com.ibm.cloud.garage.SalesTaxCalculator;
import org.junit.Test;
import org.junit.Assert;

public class SalesTaxCalculatorTest {


    @Test
    public void testNonImportNonTaxExemptRoundDown() {
        Assert.assertEquals(4.00, SalesTaxCalculator.calculateTaxes(false, false, 40.02), 0);
    }

    @Test
    public void testNonImportNonTaxExemptRoundUp() {
        Assert.assertEquals(4.05, SalesTaxCalculator.calculateTaxes(false, false, 40.29), 0);
    }

    @Test
    public void testNonImportTaxExempt() {
        Assert.assertEquals(0.00, SalesTaxCalculator.calculateTaxes(false, true, 45.55), 0);
    }

    @Test
    public void testImportTaxExempt() {
        Assert.assertEquals(1.55, SalesTaxCalculator.calculateTaxes(true, true, 30.77), 0);
    }

    @Test
    public void testImportNonTaxExempt() {
        Assert.assertEquals(4.60, SalesTaxCalculator.calculateTaxes(true, false, 30.77), 0);
    }
}
