package com.bp.java.funcional.curso.modulo05;

import com.bp.java.funcional.curso.domain.EmailOrderRequest;
import com.bp.java.funcional.curso.domain.EmailOrderRequestBuilder;
import com.bp.java.funcional.curso.domain.Product;
import com.bp.java.funcional.curso.domain.ProductBuyer;
import com.bp.java.funcional.curso.repository.ProductRepository;
import org.junit.Test;

public class BuilderELambda {

    @Test
    public void requisitandoProdutoFormatoDefasado() {

        ProductBuyer productBuyer = new ProductBuyer();

        Product productToRequest = ProductRepository.getById(1L);

        EmailOrderRequest emailOrderRequest = new EmailOrderRequestBuilder().createEmailOrderRequest();

        emailOrderRequest.setTo("supplier01@gmail.com");
        emailOrderRequest.setCc("buyingdepartment@gmail.com");
        emailOrderRequest.setSubject("Order request ");
        emailOrderRequest.setBody("Automatic order request");
        emailOrderRequest.setProduct(productToRequest);

        productBuyer.placeOrderByEmailOld(emailOrderRequest);

    }

    @Test(expected = NullPointerException.class)
    public void falhandoAoCriarEmailRequestInvalido() {

        Product productToRequest = ProductRepository.getById(1L);

        String to = null;
        String cc = "buyingdepartment@gmail.com";
        String subject = "Order request ";
        String body = "Automatic order request";

        EmailOrderRequest emailOrderRequest =
                EmailOrderRequest.builder()
                        .setTo(to)
                        .setCc(cc)
                        .setSubject(subject)
                        .setBody(body)
                        .setProduct(productToRequest)
                    .createEmailOrderRequest();

        ProductBuyer.placeOrderByEmail(emailOrderRequest);
        //Processo longo
    }


    @Test
    public void criandoRequisicaoComLambda() {


        Product productToRequest = ProductRepository.getById(1L);

        ProductBuyer.placeOrderByEmail(emailOrderRequestBuilder ->
                emailOrderRequestBuilder
                .setTo("supplier01@gmail.com")
                .setCc("buyingdepartment@gmail.com")
                .setSubject("Order request ")
                .setBody("Automatic order request")
                .setProduct(productToRequest));

    }
}
