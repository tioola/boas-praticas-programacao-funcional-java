package com.bp.java.funcional.curso.domain;

import java.util.Map;
import java.util.stream.Collectors;

public class ProductSurvey {

    private Product product;
    private SurveryType type;
    private Map<String, String> questionsAndAnswers;

    public ProductSurvey(Product product, SurveryType type) {
        this.product = product;
        this.type = type;
        this.questionsAndAnswers = type.getQuestions()
                .stream()
                .collect(Collectors.toMap(data -> data, data -> ""));
    }
}
