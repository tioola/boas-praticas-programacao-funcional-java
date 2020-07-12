package com.bp.java.funcional.curso.domain;

import java.math.BigDecimal;
import java.util.function.Predicate;

public class Products {

    private static final BigDecimal MINIMUM_PRICE = BigDecimal.valueOf(10);

    public static Predicate<Product> startsWithO = product -> product.getDescription().startsWith("O");

    public static Predicate<Product> priceHigherThan10 = product -> product.getPrice().compareTo(MINIMUM_PRICE) > 0;

    private Products() { }

}
