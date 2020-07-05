package com.bp.java.funcional.curso.modulo02;

import com.bp.java.funcional.curso.domain.Product;
import com.bp.java.funcional.curso.repository.ProductRepository;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasProperty;

public class ImperativoVsDeclarativo {

    @Test
    public void buscarProdutosModeloImperativo() {

        String productNameContains = "Orange";

        List<Product> products = ProductRepository.getProducts();
        List<Product> productsFound = new ArrayList<>();

        for (Product product : products) {
            if(product.getDescription().contains(productNameContains)){
                productsFound.add(product);
            }
        }

        assertThat(productsFound, contains(
                hasProperty("description", is("Orange")),
                hasProperty("description", is("Orange Juice"))
        ));
    }

    @Test
    public void buscarProdutosModeloDeclarativo() {

        List<Product> productsFound = ProductRepository.getProducts()
                .stream()
                .filter(product -> product.getDescription().contains("Orange"))
                .collect(Collectors.toList());

        assertThat(productsFound, contains(
                hasProperty("description", is("Orange")),
                hasProperty("description", is("Orange Juice"))
        ));

    }

    @Test
    public void somarEstoqueFormaImperativa() {

        String productNameContains = "Orange";
        List<Product> products = ProductRepository.getProducts();

        int total = 0;
        for (Product product : products) {
            if(product.getDescription().contains(productNameContains)){
                total += product.getAmount();
            }
        }

        assertThat(total, is(41));
    }

    @Test
    public void somarEstoqueFormaDeclarativa() {

        int total = ProductRepository.getProducts()
                .stream()
                .filter(product -> product.getDescription().contains("Orange"))
                .mapToInt(Product::getAmount)
                .sum();

        assertThat(total,is(41));

    }
}
