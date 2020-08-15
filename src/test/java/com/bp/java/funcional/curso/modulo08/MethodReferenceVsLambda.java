package com.bp.java.funcional.curso.modulo08;

import com.bp.java.funcional.curso.domain.Product;
import com.bp.java.funcional.curso.domain.ProductType;
import com.bp.java.funcional.curso.repository.ForeignerDollarQuotationTppIntegration;
import com.bp.java.funcional.curso.repository.ProductRepository;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.bp.java.funcional.curso.repository.ForeignerDollarQuotationTppIntegration.getDollarQuotation;

public class MethodReferenceVsLambda {

    @Test
    public void methodReference() {

        Map<ProductType, Integer> collect = ProductRepository.getProducts()
                .stream()
                .collect(Collectors.groupingBy(Product::getType
                        , Collectors.reducing(0, Product::getAmount, Integer::sum)));


        System.out.println(collect);

    }

    @Test
    public void lambda() {
        recalculateProductsInDollar(() -> getDollarQuotation());
    }

    @Test
    public void staticMethodReference() {
        recalculateProductsInDollar(ForeignerDollarQuotationTppIntegration::getDollarQuotation);
    }

    @Test
    public void constructorMethodReference() {

        List<Integer> integers = Arrays.asList(10, 20, 30, 40);

        integers.stream()
                .map(BigDecimal::new)
                .collect(Collectors.toList());

    }

    @Test
    public void unboundMethodReference() {

        ProductRepository.getProducts()
                .stream()
                .map(Product::getPrice)
                .collect(Collectors.toList());

    }

    @Test
    public void boundMethodReference() {

        BigDecimal valueToAdd = BigDecimal.valueOf(10);

        Stream<BigDecimal> bigDecimalStream = ProductRepository.getProducts()
                .stream()
                .map(Product::getPrice)
                .map(valueToAdd::add);


    }

    private void recalculateProductsInDollar(Supplier<BigDecimal> dollar){

        //Executar o processamento
        System.out.println(dollar.get());
    }
}
