package com.ibm.cloud.garage.exercise;

import com.ibm.cloud.garage.FileParser;
import com.ibm.cloud.garage.Product;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class FileParserTest {
    @Test
    public void testSpaceDelimitedFile() {
        File file = new File("./src/resource/space_delim.txt");
        List<Product> products = FileParser.parseFile(file);

        Assert.assertEquals(1, products.get(0).getQuantity());
        Assert.assertEquals("book", products.get(0).getName());
        Assert.assertEquals(12.49, products.get(0).getPrice(), 0);
        Assert.assertTrue(products.get(0).isBasicTaxExempt());
        Assert.assertFalse(products.get(0).isImport());

        Assert.assertEquals(1, products.get(1).getQuantity());
        Assert.assertEquals("music CD", products.get(1).getName());
        Assert.assertEquals(14.99, products.get(1).getPrice(), 0);
        Assert.assertFalse(products.get(1).isBasicTaxExempt());
        Assert.assertFalse(products.get(1).isImport());

        Assert.assertEquals(1, products.get(2).getQuantity());
        Assert.assertEquals("chocolate bar", products.get(2).getName());
        Assert.assertEquals(0.85, products.get(2).getPrice(), 0);
        Assert.assertTrue(products.get(2).isBasicTaxExempt());
        Assert.assertFalse(products.get(2).isImport());

    }

    @Test
    public void testPipeDelimitedFile() {
        File file = new File("./src/resource/pipe_delim.txt");
        List<Product> products = FileParser.parseFile(file);

        Assert.assertEquals(1, products.get(0).getQuantity());
        Assert.assertEquals("bottle of perfume", products.get(0).getName());
        Assert.assertEquals(47.50, products.get(0).getPrice(), 0);
        Assert.assertFalse(products.get(0).isBasicTaxExempt());
        Assert.assertTrue(products.get(0).isImport());

        Assert.assertEquals(1, products.get(1).getQuantity());
        Assert.assertEquals("box of chocolates", products.get(1).getName());
        Assert.assertEquals(10.00, products.get(1).getPrice(), 0);
        Assert.assertTrue(products.get(1).isBasicTaxExempt());
        Assert.assertTrue(products.get(1).isImport());
    }

    @Test
    public void testCommaDelimitedFile() {
        File file = new File("./src/resource/comma_delim.txt");
        List<Product> products = FileParser.parseFile(file);

        Assert.assertEquals(1, products.get(0).getQuantity());
        Assert.assertEquals("bottle of perfume", products.get(0).getName());
        Assert.assertEquals(27.99, products.get(0).getPrice(), 0);
        Assert.assertFalse(products.get(0).isBasicTaxExempt());
        Assert.assertTrue(products.get(0).isImport());

        Assert.assertEquals(1, products.get(1).getQuantity());
        Assert.assertEquals("bottle of perfume", products.get(1).getName());
        Assert.assertEquals(18.99, products.get(1).getPrice(), 0);
        Assert.assertFalse(products.get(1).isBasicTaxExempt());
        Assert.assertFalse(products.get(1).isImport());

        Assert.assertEquals(1, products.get(2).getQuantity());
        Assert.assertEquals("packet of headache pills", products.get(2).getName());
        Assert.assertEquals(9.75, products.get(2).getPrice(), 0);
        Assert.assertTrue(products.get(2).isBasicTaxExempt());
        Assert.assertFalse(products.get(2).isImport());

        Assert.assertEquals(1, products.get(3).getQuantity());
        Assert.assertEquals("box of chocolates", products.get(3).getName());
        Assert.assertEquals(11.25, products.get(3).getPrice(), 0);
        Assert.assertTrue(products.get(3).isBasicTaxExempt());
        Assert.assertTrue(products.get(3).isImport());
    }
}
