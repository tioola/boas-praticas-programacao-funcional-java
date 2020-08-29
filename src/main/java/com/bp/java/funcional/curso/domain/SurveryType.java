package com.bp.java.funcional.curso.domain;

import java.util.List;

public enum SurveryType {

    CUSTOMER_SERVICE(List.of("Question1","Question2")),
    PRODUCT_SATISFACTION(List.of("Question3","Question4")),
    DELIVERY(List.of("Question5","Question6"));

    private List<String> questions;

    SurveryType(List<String> questions) {
        this.questions = questions;
    }

    public List<String> getQuestions() {
        return questions;
    }
}
