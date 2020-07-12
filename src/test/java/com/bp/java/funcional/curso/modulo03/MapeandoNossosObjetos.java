package com.bp.java.funcional.curso.modulo03;

import com.bp.java.funcional.curso.domain.Product;
import com.bp.java.funcional.curso.repository.ProductRepository;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.bp.java.funcional.curso.utils.FullStringUpperCaseMatcher.isFullUpperCase;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Every.everyItem;

public class MapeandoNossosObjetos {

    @Test
    public void testeIteracaoMutavel() {

        List<Product> products = ProductRepository.getProducts();

        for (Product product : products) {
            productToUpperCase(product);
        }

        assertThat(products, everyItem(hasProperty("description",
                isFullUpperCase())));
    }

    @Test
    public void testProblemaComThreads() throws InterruptedException {

        // Execucao Mutavel
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(() -> {

            List<Product> products = ProductRepository.getProducts();

            for (Product product : products) {
                productToUpperCase(product);
            }

        });

        final List<Product> productsFound = new ArrayList<>();

        CountDownLatch latch  = new CountDownLatch(1);

        executorService.submit(() -> {
            try {
                // Processamento pesado ocorrendo
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            productsFound.addAll(ProductRepository.getProducts().stream()
                    .filter(product -> product.getDescription().contains("Orange"))
                    .collect(Collectors.toList()));

            latch.countDown();
        });

        latch.await();

        assertThat(productsFound, hasSize(greaterThan(0)));
    }

    @Test
    public void testeIteracaoImutavel() {

        List<Product> productsFound = ProductRepository.getProducts()
                .stream()
                .map(product -> product.changeDescription(product.getDescription().toUpperCase()))
                .collect(Collectors.toList());

        assertThat(productsFound, everyItem(hasProperty("description",
                isFullUpperCase())));
    }


    @Test
    public void solucaoProblemThread() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //Execucao imutavel
        executorService.submit(() -> {
            List<Product> productsFound = ProductRepository.getProducts()
                    .stream()
                    .map(product -> product.changeDescription(product.getDescription().toUpperCase()))
                    .collect(Collectors.toList());

            System.out.println(productsFound);
        });

        final List<Product> productsFound = new ArrayList<>();
        CountDownLatch latch  = new CountDownLatch(1);

        executorService.submit(() -> {
            try {
                // Processamento pesado ocorrendo
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            productsFound.addAll(ProductRepository.getProducts().stream()
                    .filter(product -> product.getDescription().contains("Orange"))
                    .collect(Collectors.toList()));

            latch.countDown();
        });

        latch.await();

        assertThat(productsFound, hasSize(greaterThan(0)));

    }

    private void productToUpperCase(Product product){
        product.setDescription(product.getDescription().toUpperCase());
    }
}
