package com.ibm.cloud.garage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileParser {
    final static String PIPE = "pipe:", SPACE = "space:", COMMA = "comma:";

    public static  List<Product> parseFile(File file) {
        List<Product> products = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            String firstLine = scanner.nextLine().trim().toLowerCase();

            switch (firstLine){
                case PIPE:
                    Pattern pipePattern = Pattern.compile("^(.*)?\\s\\|\\s?(\\d+) (.*) \\| ([0-9]+\\.[0-9]{2})$");
                    while (scanner.hasNextLine()) {
                        boolean isImport = false, isBasicTaxExempt = false;
                        String line = scanner.nextLine();
                        Matcher matcher = pipePattern.matcher(line);
                        if (matcher.find()){
                            int quantity = Integer.parseInt(matcher.group(2));
                            Double inputPrice = Double.parseDouble(matcher.group(4));
                            String name = matcher.group(3);
                            if(matcher.group(1) != null && !matcher.group(1).isEmpty() && matcher.group(1).equalsIgnoreCase("Imported")){
                                isImport = true;
                            }

                            isBasicTaxExempt = isBasicTaxExempt(isBasicTaxExempt, name);

                            Product product = new Product(quantity, name, inputPrice, isImport, isBasicTaxExempt);
                            products.add(product);
                        }
                    }
                    break;

                case SPACE:
                    Pattern spacePattern = Pattern.compile("^(\\d) (.*) ([0-9]+\\.[0-9]{2})$");
                    while (scanner.hasNextLine()) {
                        boolean isImport = false, isBasicTaxExempt = false;
                        String line = scanner.nextLine();
                        Matcher matcher = spacePattern.matcher(line);
                        if (matcher.find()){
                            int quantity = Integer.parseInt(matcher.group(1));
                            Double inputPrice = Double.parseDouble(matcher.group(3));
                            String name = matcher.group(2);

                            isBasicTaxExempt = isBasicTaxExempt(isBasicTaxExempt, name);

                            Product product = new Product(quantity, name, inputPrice, isImport, isBasicTaxExempt);
                            products.add(product);
                        }
                    }
                    break;

                case COMMA:
                    Pattern commaPattern = Pattern.compile("^(\\d) (.*), ([0-9]+\\.[0-9]{2}),?\\s?(imported)?$");
                    while (scanner.hasNextLine()) {
                        boolean isImport = false, isBasicTaxExempt = false;
                        String line = scanner.nextLine();
                        Matcher matcher = commaPattern.matcher(line);
                        if (matcher.find()){
                            int quantity = Integer.parseInt(matcher.group(1));
                            Double inputPrice = Double.parseDouble(matcher.group(3));
                            String name = matcher.group(2);

                            if(matcher.group(4) != null && !matcher.group(4).isEmpty() && matcher.group(4).equalsIgnoreCase("Imported")){
                                isImport = true;
                            }

                            isBasicTaxExempt = isBasicTaxExempt(isBasicTaxExempt, name);

                            Product product = new Product(quantity, name, inputPrice, isImport, isBasicTaxExempt);
                            products.add(product);
                        }
                    }
                    break;
            }

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }

    private static boolean isBasicTaxExempt(boolean isBasicTaxExempt, String name) {
        if (name.contains("book") || name.contains("chocolate") || name.contains("pill")) {
            isBasicTaxExempt = true;
        }
        return isBasicTaxExempt;
    }
}