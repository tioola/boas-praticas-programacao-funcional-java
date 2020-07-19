package com.bp.java.funcional.curso.modulo04;

import com.bp.java.funcional.curso.domain.ImmutableSetCollectors;
import com.bp.java.funcional.curso.domain.Product;
import com.bp.java.funcional.curso.repository.ProductRepository;
import com.google.common.collect.ImmutableSet;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.summarizingDouble;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

public class CollectorsApi {

    @Test
    public void comoNaoColetarNossoObjetos() {

        List<Product> products = ProductRepository.getProducts();
        List<Product> collectedProducts = new ArrayList<>();

        products.forEach(product -> {
            if(product.getPrice().compareTo(BigDecimal.valueOf(2.0)) < 0){
                collectedProducts.add(product);
            }
        });

        System.out.println(collectedProducts);
    }

    @Test
    public void comoColetar() {

        List<Product> collectedProducts = ProductRepository.getProducts()
                .stream()
                .filter(product -> product.getPrice().compareTo(BigDecimal.valueOf(2.0)) < 0)
                .collect(Collectors.toList());

        assertThat(collectedProducts, contains(
                hasProperty("description", is("Lemon")),
                hasProperty("description", is("Sparkling Water"))
        ));
    }

    @Test
    public void coletarSet() {

        Set<Product> collectedProducts = ProductRepository.getProducts()
                .stream()
                .filter(product -> product.getPrice().compareTo(BigDecimal.valueOf(2.0)) < 0)
                .collect(Collectors.toSet());


        assertThat(collectedProducts, contains(
                hasProperty("description", is("Lemon")),
                hasProperty("description", is("Sparkling Water"))
        ));
    }

    @Test
    public void funcionamentoDoColletor() {

        List<Product> collectedProducts = ProductRepository.getProducts()
                .stream()
                .filter(product -> product.getPrice().compareTo(BigDecimal.valueOf(2.0)) < 0)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        assertThat(collectedProducts, contains(
                hasProperty("description", is("Lemon")),
                hasProperty("description", is("Sparkling Water"))
        ));
    }

    @Test
    public void testCustomCollector() {
        ImmutableSet<Product> collectedProducts = ProductRepository.getProducts()
                .stream()
                .filter(product -> product.getPrice().compareTo(BigDecimal.valueOf(2.0)) < 0)
                .collect(ImmutableSetCollectors.toImmutableSet());

        assertThat(collectedProducts , contains(
                hasProperty("description", is("Lemon")),
                hasProperty("description", is("Sparkling Water"))
        ));
    }

    @Test
    public void testCriarListaImutavel() {

        List<Product> collectedProducts = ProductRepository.getProducts()
                .stream()
                .filter(product -> product.getPrice().compareTo(BigDecimal.valueOf(2.0)) < 0)
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));

        collectedProducts.add(ProductRepository.getProducts().stream().findFirst().get());

        assertThat(collectedProducts , contains(
                hasProperty("description", is("Lemon")),
                hasProperty("description", is("Sparkling Water"))
        ));
    }

    @Test
    public void calcularInfomacoesDosProdutos() {

        DoubleSummaryStatistics statistics = ProductRepository.getProducts()
                .stream()
                .map(Product::getPrice)
                .collect(summarizingDouble(BigDecimal::doubleValue));

        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getSum());

    }
}
