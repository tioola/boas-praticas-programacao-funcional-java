package com.bp.java.funcional.curso.domain;

import java.util.Objects;

public class EmailOrderRequest {

    private String to;

    private String cc;

    private String subject;

    private String body;

    private Product product;

    // Não deveria existir este construtor em uma situação real
    public EmailOrderRequest(){ }

    public EmailOrderRequest(String to, String cc, String subject, String body, Product product) {
        Objects.requireNonNull(to,"To: should not be null");
        Objects.requireNonNull(subject, "Subject: should not be null");
        Objects.requireNonNull(product, "Product: should not be null");

        this.to = to;
        this.cc = cc;
        this.subject = subject;
        this.body = body;
        this.product = product;
    }

    public static EmailOrderRequestBuilder builder(){
        return new EmailOrderRequestBuilder();
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "{\"EmailOrderRequest\":{"
                + "                        \"to\":\"" + to + "\""
                + ",                         \"cc\":\"" + cc + "\""
                + ",                         \"subject\":\"" + subject + "\""
                + ",                         \"body\":\"" + body + "\""
                + ",                         \"product\":" + product
                + "}}";
    }
}
