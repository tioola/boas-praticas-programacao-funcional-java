package com.bp.java.funcional.curso.domain;

import java.util.function.Consumer;

public class ProductBuyer {

    public void placeOrderByEmailOld(EmailOrderRequest emailOrderRequest){
        System.out.println(String.format("Executar envio do email produto %s", emailOrderRequest));
    }

    public static void placeOrderByEmail(EmailOrderRequest emailOrderRequest){
        System.out.println(String.format("Executar envio do email produto %s", emailOrderRequest));
    }

    public static void placeOrderByEmail(Consumer<EmailOrderRequestBuilder> consumer){
        EmailOrderRequestBuilder builder = EmailOrderRequest.builder();
        consumer.accept(builder);
        placeOrderByEmail(builder.createEmailOrderRequest());
    }

}
