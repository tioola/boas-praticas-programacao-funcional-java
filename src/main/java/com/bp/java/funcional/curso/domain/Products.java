package com.bp.java.funcional.curso.domain;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Products {

    private static final BigDecimal MINIMUM_PRICE = BigDecimal.valueOf(10);

    // Não é o melhor formato.
    public static Predicate<Product> startsWithO = product -> product.getDescription().startsWith("O");
    public static Predicate<Product> priceHigherThan10 = product -> product.getPrice().compareTo(MINIMUM_PRICE) > 0;

    public static Predicate<Product> ofType(ProductType productType){
        return product -> product.getType() == productType;
    }

    private Products() { }

    public static Predicate<Product> startsWith(final String letter){
        return product -> product.getDescription().startsWith(letter);
    }

    public static Predicate<Product> priceHigherThan(BigDecimal value){
        return product -> product.getPrice().compareTo(value) > 0;
    }

    public static Comparator<Product> priceDifference = Comparator.comparing(Product::getPrice);

    public static Comparator<Product> amountDifference = Comparator.comparing(Product::getAmount);

    Function<String, Predicate<Product>> startsWithFunction = letter -> product -> product.getDescription().startsWith(letter);

    public static int calculateTotalProducts(List<Product> productList, Predicate<Product> predicate){
        return productList.stream()
                .filter(predicate)
                .mapToInt(Product::getAmount)
                .sum();
    }




}
