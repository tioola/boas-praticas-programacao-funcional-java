package com.bp.java.funcional.curso.modulo04;

import com.bp.java.funcional.curso.domain.Product;
import com.bp.java.funcional.curso.repository.ProductRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static com.bp.java.funcional.curso.domain.Products.amountDifference;
import static com.bp.java.funcional.curso.domain.Products.priceDifference;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Comparators {

    @Test
    public void sortModeloAntigo() {

        List<Product> products = ProductRepository.getProducts();
        List<Product> mutableListProducts = new ArrayList<>();

        mutableListProducts.addAll(products);

        mutableListProducts.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice().compareTo(o2.getPrice());
            }
        });

        for (Product mutableListProduct : mutableListProducts) {
            System.out.println(mutableListProduct.getPrice());
        }
    }


    @Test
    public void sortModeloDeclarativo() {

        ProductRepository.getProducts()
                .stream()
                .sorted(priceDifference)
                .map(Product::getPrice)
                .forEach(System.out::println);

    }

    @Test
    public void sortReversoModeloDeclarativo() {

        Comparator<Product> reversedPriceDifference = priceDifference.reversed();


        ProductRepository.getProducts()
                .stream()
                .sorted(reversedPriceDifference)
                .map(Product::getPrice)
                .forEach(System.out::println);

    }

    @Test
    public void utilizarMaisDeUmComparator() {

        ProductRepository.getProducts()
                .stream()
                .sorted(priceDifference.thenComparing(amountDifference))
                .forEach(System.out::println);

    }


    @Test
    public void buscarMenorPreco() {

        Optional<Product> product = ProductRepository.getProducts()
                .stream()
                .min(priceDifference);

        assertThat(product.get().getDescription(), is("Lemon"));
    }

    @Test
    public void buscarMaiorValor() {
        Optional<Product> product = ProductRepository.getProducts()
                .stream()
                .max(priceDifference);

        assertThat(product.get().getDescription(), is("Macbook Pro"));
    }
}
