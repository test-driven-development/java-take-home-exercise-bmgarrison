package com.ibm.cloud.garage;

import java.io.File;
import java.util.List;

public class SalesOrderRunner {
    public static void main(String[] args){
        File file = new File("./src/resource/space_delim.txt");
        List<Product> products = FileParser.parseFile(file);
        SalesOrder salesOrder = new SalesOrder();
        System.out.println("Output 1:");
        System.out.println(salesOrder.createSalesOrder(products) + "\n");

        File pipeFile = new File("./src/resource/pipe_delim.txt");
        List<Product> pipeProducts = FileParser.parseFile(pipeFile);
        SalesOrder pipeSalesOrder = new SalesOrder();
        System.out.println("Output 2:");
        System.out.println(pipeSalesOrder.createSalesOrder(pipeProducts) + "\n");

        File commaFile = new File("./src/resource/comma_delim.txt");
        List<Product> commaProducts = FileParser.parseFile(commaFile);
        SalesOrder commaSalesOrder = new SalesOrder();
        System.out.println("Output 3:");
        System.out.println(commaSalesOrder.createSalesOrder(commaProducts));
    }
}
