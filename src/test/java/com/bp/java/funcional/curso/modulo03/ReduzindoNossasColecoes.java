package com.bp.java.funcional.curso.modulo03;

import com.bp.java.funcional.curso.domain.Product;
import com.bp.java.funcional.curso.domain.ProductType;
import com.bp.java.funcional.curso.repository.ProductRepository;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.function.BinaryOperator.*;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReduzindoNossasColecoes {

    @Test
    public void printarItemsImperativo() {

        List<Product> products = ProductRepository.getProducts();


        String descricoes = "";
        for (int i = 0; i < products.size(); i++) {
            if(i == products.size() - 1){
                descricoes += products.get(i).getDescription();
            }else {
                descricoes += products.get(i).getDescription() + ",";
            }
        }

        System.out.println(descricoes);
    }

    @Test
    public void printarItemsDeclarativo(){

        String descricoes = ProductRepository.getProducts()
                .stream()
                .map(Product::getDescription)
                .collect(Collectors.joining(", "));

        System.out.println(descricoes);
    }

    @Test
    public void somarTotalImperativo() {

        List<Product> products = ProductRepository.getProducts();
        BigDecimal total = BigDecimal.ZERO;

        for (Product product : products) {
            total = total.add(product.getPrice());
        }

        System.out.println(total);
    }

    @Test
    public void somarTotalDeclarativo() {

        BigDecimal total = ProductRepository.getProducts()
                .stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println(total);
    }

    @Test
    public void somarTotalDeDuasFontesDiferentes() {

        List<Product> tppClothes = ProductRepository.getProductsFromClothesExternalTpp();
        List<Product> tppElectronics = ProductRepository.getProductsFromElectronicExternalTpp();

        BigDecimal total = Stream.of(tppClothes, tppElectronics)
                .flatMap(Collection::stream)
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println(total);

    }

    @Test
    public void agruparPorTipoDeProdutosImperativo() {

        ProductType[] productTypeValues = ProductType.values();
        Map<ProductType, List<Product>> groupedProducts = new HashMap<>();

        for (ProductType value : productTypeValues) {
            groupedProducts.put(value, new ArrayList<>());
        }

        List<Product> products = ProductRepository.getProducts();

        for (Product product : products) {
            groupedProducts.get(product.getType()).add(product);
        }

        assertThat(groupedProducts.get(ProductType.CLOTHING).size(), is(5));
    }

    @Test
    public void agruparPorTipoProdutosDeclarativo(){

        Map<ProductType, List<Product>> groupedProducts = ProductRepository.getProducts()
                .stream()
                .collect(groupingBy(Product::getType));

        assertThat(groupedProducts.get(ProductType.CLOTHING).size(), is(5));
    }

    @Test
    public void agruparPorTipoENomeDeclarativo() {

        Map<ProductType, List<String>> collect = ProductRepository.getProducts()
                .stream()
                .collect(groupingBy(Product::getType, mapping(Product::getDescription, toList())));

        System.out.println(collect);
    }

    @Test
    public void agruparPorTipoValorTotalEmProdutosDeclarativo() {

        Map<ProductType, BigDecimal> totalPorCategoria = ProductRepository.getProducts()
                .stream()
                .collect(groupingBy(Product::getType,
                        reducing(BigDecimal.ZERO, Product::getPrice, BigDecimal::add)));

        System.out.println(totalPorCategoria);

    }

    @Test
    public void produtoMaisCaroPorCategoria() {

        Map<ProductType, Optional<Product>> collect = ProductRepository.getProducts()
                .stream()
                .collect(groupingBy(Product::getType,
                        reducing(maxBy(comparing(Product::getPrice)))));

        System.out.println(collect);

    }
}
