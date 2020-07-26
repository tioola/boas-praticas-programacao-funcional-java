package com.bp.java.funcional.curso.domain.strategies;

import com.bp.java.funcional.curso.domain.Product;
import com.bp.java.funcional.curso.domain.ProductType;

public class SelectFoodStrategy implements  SelectProductsStrategy {
    @Override
    public boolean isApplicable(Product product) {
        return product.getType() == ProductType.FOOD;
    }
}
