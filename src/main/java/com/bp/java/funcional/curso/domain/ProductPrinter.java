package com.bp.java.funcional.curso.domain;

import java.util.function.Function;

public class ProductPrinter {

    /*private ProductFinder productFinder;

    public ProductPrinter(ProductFinder productFinder) {
        this.productFinder = productFinder;
    }
*/

    private Function<Long,Product> productFinder;

    public ProductPrinter(Function<Long, Product> productFinder) {
        this.productFinder = productFinder;
    }

    public void printProduct(Long productId) {
        Product product = productFinder.apply(productId);
        System.out.println(product.toString());
    }
}
