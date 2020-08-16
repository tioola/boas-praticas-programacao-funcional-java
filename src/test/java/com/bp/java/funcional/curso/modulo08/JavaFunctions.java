package com.bp.java.funcional.curso.modulo08;

import com.bp.java.funcional.curso.domain.Product;
import com.bp.java.funcional.curso.domain.ProductPrinter;
import com.bp.java.funcional.curso.domain.TotalPrinter;
import com.bp.java.funcional.curso.repository.ProductRepository;
import org.junit.Test;

import java.math.BigDecimal;

public class JavaFunctions {

    @Test
    public void functionCall() {
        ProductPrinter productPrinter = new ProductPrinter(ProductRepository::getById);
        productPrinter.printProduct(10L);
    }

    @Test
    public void totalFunctionCall() {

        TotalPrinter totalPrinter = new TotalPrinter(productId -> {
            Product product = ProductRepository.getById(productId);
            return product.getPrice().multiply(BigDecimal.valueOf(product.getAmount())).doubleValue();
        });

        totalPrinter.printTotal(10L);
    }
}
