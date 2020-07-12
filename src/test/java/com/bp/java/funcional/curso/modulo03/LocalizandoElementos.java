package com.bp.java.funcional.curso.modulo03;

import com.bp.java.funcional.curso.domain.Product;
import com.bp.java.funcional.curso.repository.ProductRepository;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

public class LocalizandoElementos {

    private static final BigDecimal MINIMUM_PRICE = BigDecimal.valueOf(10);

    @Test
    public void encontrarProdutosIniciemLetra0Imperativo() {

        List<Product> products = ProductRepository.getProducts();

        String productDescriptionFound = null;

        for (Product product : products) {
            if(product.getDescription().startsWith("O") &&
               product.getPrice().compareTo(MINIMUM_PRICE) > 0){
                productDescriptionFound = product.getDescription();
                break;
            }
        }

        assertThat(productDescriptionFound, is("Orange Juice"));
    }


    @Test
    public void encontrarProdutosIniciemLetra0Declarativo() {

        Predicate<Product> startsWithO = product -> product.getDescription().startsWith("O");
        Predicate<Product> priceHigherThan10 = product -> product.getPrice().compareTo(MINIMUM_PRICE) > 0;

        Optional<String> productDescriptionFound = ProductRepository.getProducts()
                .stream()
                .filter(startsWithO.and(priceHigherThan10))
                .map(Product::getDescription)
                .findFirst();

        assertThat(productDescriptionFound.get(), is("Orange Juice"));

    }
}
