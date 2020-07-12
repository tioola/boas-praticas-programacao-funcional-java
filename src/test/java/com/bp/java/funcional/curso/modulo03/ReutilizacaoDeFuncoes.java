package com.bp.java.funcional.curso.modulo03;

import com.bp.java.funcional.curso.domain.Product;
import com.bp.java.funcional.curso.repository.ProductRepository;
import org.junit.Test;

import java.util.Optional;

import static com.bp.java.funcional.curso.domain.Products.priceHigherThan10;
import static com.bp.java.funcional.curso.domain.Products.startsWithO;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReutilizacaoDeFuncoes {

    @Test
    public void encontrarProdutosIniciemLetra0Declarativo() {

        Optional<String> productDescriptionFound = ProductRepository.getProducts()
                .stream()
                .filter(startsWithO.and(priceHigherThan10))
                .map(Product::getDescription)
                .findFirst();

        assertThat(productDescriptionFound.get(), is("Orange Juice"));

    }

}
