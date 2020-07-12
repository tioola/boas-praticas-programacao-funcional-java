package com.bp.java.funcional.curso.modulo03;

import com.bp.java.funcional.curso.domain.Product;
import com.bp.java.funcional.curso.repository.ProductRepository;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.bp.java.funcional.curso.domain.Products.priceHigherThan;
import static com.bp.java.funcional.curso.domain.Products.priceHigherThan10;
import static com.bp.java.funcional.curso.domain.Products.startsWith;
import static com.bp.java.funcional.curso.domain.Products.startsWithO;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class EscopoLexico {

    @Test
    public void encontrarProdutosIniciemLetraBDeclarativo() {

        List<Product> productsFound = ProductRepository.getProducts()
                .stream()
                .filter(startsWith("B").and(priceHigherThan(BigDecimal.valueOf(10.0))))
                .collect(Collectors.toList());

        assertThat(productsFound.size(), greaterThan(0));
    }

}
