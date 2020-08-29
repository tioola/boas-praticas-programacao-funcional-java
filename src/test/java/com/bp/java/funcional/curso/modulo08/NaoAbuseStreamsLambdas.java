package com.bp.java.funcional.curso.modulo08;

import com.bp.java.funcional.curso.domain.Product;
import com.bp.java.funcional.curso.domain.ProductSurvey;
import com.bp.java.funcional.curso.domain.SurveryType;
import com.bp.java.funcional.curso.repository.ProductRepository;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class NaoAbuseStreamsLambdas {

    @Test
    public void streamsAndLambdasAnagramDirty() {

        ProductRepository.getProducts()
                .stream()
                .map(product -> product.getDescription().toUpperCase())
                .collect(groupingBy(
                        word -> word.chars().sorted()
                                .collect(StringBuilder::new,
                                        ((stringBuilder, value) -> stringBuilder.append((char) value)),
                                        StringBuilder::append).toString()
                )).values().stream()
                .filter(group -> group.size() >= 2)
                .map(group -> group.size() + ": " + group)
                .forEach(System.out::println);
    }

    @Test
    public void streamsAndLambdasAnagramReadable() {
        ProductRepository.getProducts()
                .stream()
                .map(product -> product.getDescription().toUpperCase())
                .collect(groupingBy(this::alphabetize))
                .forEach(this::printIfHasAnagram);

    }

    private String alphabetize(String word){
        return word.chars()
                .sorted()
                .collect(StringBuilder::new,
                        ((stringBuilder, value) -> stringBuilder.append((char) value)),
                        StringBuilder::append).toString();

    }

    private void printIfHasAnagram(String key, List<String> anagrams){
        if(anagrams.size() > 1){
            System.out.println(String.format("group %s found: %s", key, anagrams));
        }
    }


    @Test
    public void createProductSurveyPerPurchase() {



    }

    private List<ProductSurvey> createAllSuerveysForPurchasedProducts(List<Product> products){

        List<ProductSurvey> surveys = new ArrayList<>();
        for (Product product : products) {
            for (SurveryType surveryType : SurveryType.values()) {
                surveys.add(new ProductSurvey(product,surveryType));
            }
        }

        return Collections.unmodifiableList(surveys);
    }

    private List<ProductSurvey> createAllSuerveysForPurchasedProductsStreams(List<Product> products){

        return Stream.of(SurveryType.values())
                .flatMap(surveryType -> products.stream().map(product -> new ProductSurvey(product, surveryType)))
                .collect(Collectors.toList());

    }

    private BigDecimal calculateProductTotal(Product product){
        return Optional.ofNullable(product)
                .map(productToMap -> productToMap.getPrice().multiply(BigDecimal.valueOf(productToMap.getAmount())))
                .orElseGet(() -> BigDecimal.ZERO);
    }

    private BigDecimal calculateProductTotalLegivel(Product product){

        if(product == null){
            return BigDecimal.ZERO;
        }

        return product.getPrice().multiply(BigDecimal.valueOf(product.getAmount()));
    }
}
