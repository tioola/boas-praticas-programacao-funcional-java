package com.bp.java.funcional.curso.domain;

public class EmailOrderRequestBuilder {
    private String to;
    private String cc;
    private String subject;
    private String body;
    private Product product;

    public EmailOrderRequestBuilder setTo(String to) {
        this.to = to;
        return this;
    }

    public EmailOrderRequestBuilder setCc(String cc) {
        this.cc = cc;
        return this;
    }

    public EmailOrderRequestBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public EmailOrderRequestBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    public EmailOrderRequestBuilder setProduct(Product product) {
        this.product = product;
        return this;
    }

    public EmailOrderRequest createEmailOrderRequest() {
        return new EmailOrderRequest(to, cc, subject, body, product);
    }
}