package com.bp.java.funcional.curso.modulo03;

import com.bp.java.funcional.curso.domain.Product;
import com.bp.java.funcional.curso.repository.ProductRepository;
import org.junit.Test;

import java.util.List;

public class IteracaoSimplificadaSideEffects {

    @Test
    public void forIndex() {
        List<Product> products = ProductRepository.getProducts();
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }
    }

    @Test
    public void forEach() {
        List<Product> products = ProductRepository.getProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Test
    public void forEachStream() {
        List<Product> products = ProductRepository.getProducts();
        products.forEach(System.out::println);
    }

    @Test
    public void forEachMisused() {

        List<Product> products = ProductRepository.getProducts();

        products.forEach(product -> product.setDescription(product.getDescription().toUpperCase()));
        // Utilize somente em casos onde você necessita printar a informação e não mutar o objeto

    }
}
