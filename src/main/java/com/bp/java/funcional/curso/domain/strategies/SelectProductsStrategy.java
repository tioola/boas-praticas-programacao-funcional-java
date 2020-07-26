package com.bp.java.funcional.curso.domain.strategies;

import com.bp.java.funcional.curso.domain.Product;

public interface SelectProductsStrategy {

    boolean isApplicable(Product product);

}
