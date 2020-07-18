package com.bp.java.funcional.curso.repository;

import com.bp.java.funcional.curso.domain.Product;
import com.bp.java.funcional.curso.domain.ProductType;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProductRepository {

    private static final List<Product> PRODUCTS = Collections.unmodifiableList(
            Arrays.asList(
                    Product.createProduct(1L, "Orange", ProductType.FOOD, BigDecimal.valueOf(3.14), 7),
                    Product.createProduct(2L, "Basic T-Shirt Black", ProductType.CLOTHING, BigDecimal.valueOf(12.0), 12),
                    Product.createProduct(3L, "Grape", ProductType.FOOD, BigDecimal.valueOf(5.33), 12),
                    Product.createProduct(4L, "Macbook Pro", ProductType.ELECTRONIC, BigDecimal.valueOf(12000.00), 1),
                    Product.createProduct(5L, "Lemon", ProductType.FOOD, BigDecimal.valueOf(1.0), 20),
                    Product.createProduct(6L, "White Socks", ProductType.CLOTHING, BigDecimal.valueOf(2.0), 53),
                    Product.createProduct(7L, "Basic T-Shirt White", ProductType.CLOTHING, BigDecimal.valueOf(12.0), 4),
                    Product.createProduct(8L, "Red Label", ProductType.DRINK, BigDecimal.valueOf(60.0), 12),
                    Product.createProduct(9L, "Banana", ProductType.FOOD, BigDecimal.valueOf(2.13), 9),
                    Product.createProduct(10L, "Jeans", ProductType.CLOTHING, BigDecimal.valueOf(20.0), 3),
                    Product.createProduct(11L, "Smirnoff Vodka", ProductType.DRINK, BigDecimal.valueOf(25.0), 14),
                    Product.createProduct(12L, "Black Socks", ProductType.CLOTHING, BigDecimal.valueOf(2.0), 35),
                    Product.createProduct(13L, "Coca-cola", ProductType.DRINK, BigDecimal.valueOf(2.0), 103),
                    Product.createProduct(14L, "Notebook Lenovo", ProductType.ELECTRONIC, BigDecimal.valueOf(4999.00), 2),
                    Product.createProduct(15L, "Sparkling Water", ProductType.DRINK, BigDecimal.valueOf(1.50), 111),
                    Product.createProduct(16L, "Orange Juice", ProductType.DRINK, BigDecimal.valueOf(10.59), 34),
                    Product.createProduct(17L, "Apple Watch", ProductType.ELECTRONIC, BigDecimal.valueOf(2999.00), 3)
                    ));

    private static final List<Product> PRODUCTS_FROM_EXTERNAL_ELECTRONIC_TPP = Collections.unmodifiableList(
            Arrays.asList(
                    Product.createProduct(10001L, "Samsung S10", ProductType.ELECTRONIC, BigDecimal.valueOf(1020.4), 2),
                    Product.createProduct(10002L, "Samsung S20", ProductType.ELECTRONIC, BigDecimal.valueOf(2030.1), 5),
                    Product.createProduct(10003L, "LG TV", ProductType.ELECTRONIC, BigDecimal.valueOf(1000.14), 8),
                    Product.createProduct(10003L, "SONY TV", ProductType.ELECTRONIC, BigDecimal.valueOf(3002,6), 7)
            )
    );

    private static final List<Product> PRODUCTS_FROM_EXTERNAL_CLOTHES_TPP = Collections.unmodifiableList(
            Arrays.asList(
                    Product.createProduct(10001L, "Tommy T-SHIRT", ProductType.FOOD, BigDecimal.valueOf(110.14), 20),
                    Product.createProduct(10002L, "Lacoste T-SHIRT", ProductType.FOOD, BigDecimal.valueOf(150.14), 45),
                    Product.createProduct(10003L, "Polo", ProductType.FOOD, BigDecimal.valueOf(3.14), 7)
            )
    );

    public static List<Product> getProducts() {
        return PRODUCTS;
    }

    public static List<Product> getProductsFromElectronicExternalTpp(){
        return PRODUCTS_FROM_EXTERNAL_ELECTRONIC_TPP;
    }

    public static List<Product> getProductsFromClothesExternalTpp(){
        return PRODUCTS_FROM_EXTERNAL_CLOTHES_TPP;
    }

}

