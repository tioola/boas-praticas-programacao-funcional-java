package com.bp.java.funcional.curso.domain;

import com.bp.java.funcional.curso.domain.strategies.SelectProductsStrategy;

import java.util.List;

public interface ProductUtils {


    static int calculateTotalProductsAvailable(List<Product> productList, SelectProductsStrategy strategy){

        int amount = 0;

        for (Product product : productList) {

            if(strategy.isApplicable(product)){
                amount += product.getAmount();
            }

        }

        return amount;
    }

    static int calculateTotalProductsAvailable(List<Product> productList, SelectProductsStrategy... strategies){

        int amount =0;

        for (SelectProductsStrategy strategy : strategies) {
            amount += calculateTotalProductsAvailable(productList, strategy);
        }

        return amount;
    }


}
