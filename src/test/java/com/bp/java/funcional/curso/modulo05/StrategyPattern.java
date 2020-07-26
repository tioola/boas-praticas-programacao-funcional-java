package com.bp.java.funcional.curso.modulo05;

import com.bp.java.funcional.curso.domain.Product;
import com.bp.java.funcional.curso.domain.ProductType;
import com.bp.java.funcional.curso.domain.ProductUtils;
import com.bp.java.funcional.curso.domain.Products;
import com.bp.java.funcional.curso.domain.strategies.SelectElectronicsStrategy;
import com.bp.java.funcional.curso.domain.strategies.SelectFoodStrategy;
import com.bp.java.funcional.curso.domain.strategies.SelectProductsStrategy;
import com.bp.java.funcional.curso.repository.ProductRepository;
import org.junit.Test;

import java.util.List;

import static com.bp.java.funcional.curso.domain.Products.calculateTotalProducts;
import static com.bp.java.funcional.curso.domain.Products.ofType;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StrategyPattern {


    @Test
    public void calcularQuantidadeProdutosStrategy() {

        List<Product> products = ProductRepository.getProducts();

        int totalElectronics = ProductUtils.calculateTotalProductsAvailable(products, new SelectProductsStrategy() {
            @Override
            public boolean isApplicable(Product product) {
                return product.getType() == ProductType.ELECTRONIC;
            }
        });


        int totalFood = ProductUtils.calculateTotalProductsAvailable(products, new SelectProductsStrategy() {
            @Override
            public boolean isApplicable(Product product) {
                return product.getType() == ProductType.FOOD;
            }
        });

        int totalFoodAndElectronic = ProductUtils.calculateTotalProductsAvailable(products, new SelectProductsStrategy() {
            @Override
            public boolean isApplicable(Product product) {
                return product.getType() == ProductType.FOOD || product.getType() == ProductType.ELECTRONIC;
            }
        });

        assertThat(totalElectronics, is(6));
        assertThat(totalFood, is(58));
        assertThat(totalFoodAndElectronic, is(64));

    }

    @Test
    public void calcularQuantidadeProdutosStrategyMelhorado() {

        List<Product> products = ProductRepository.getProducts();

        int totalElectronics = ProductUtils.calculateTotalProductsAvailable(products,new SelectElectronicsStrategy());
        int totalFood = ProductUtils.calculateTotalProductsAvailable(products, new SelectFoodStrategy());
        int totalFoodAndElectronic = ProductUtils.calculateTotalProductsAvailable(products,
                new SelectElectronicsStrategy(), new SelectFoodStrategy());

        assertThat(totalElectronics, is(6));
        assertThat(totalFood, is(58));
        assertThat(totalFoodAndElectronic, is(64));

    }

    @Test
    public void calcularQuantidadeProdutosLambda() {

        List<Product> products = ProductRepository.getProducts();

        int totalElectronics = calculateTotalProducts(products, product -> product.getType() == ProductType.ELECTRONIC);
        int totalFood = calculateTotalProducts(products, product -> product.getType() == ProductType.FOOD);
        int totalFoodAndElectronic = calculateTotalProducts(products, product -> product.getType() == ProductType.FOOD || product.getType() == ProductType.ELECTRONIC);

        assertThat(totalElectronics, is(6));
        assertThat(totalFood, is(58));
        assertThat(totalFoodAndElectronic, is(64));
    }


    @Test
    public void calcularQuantidadeProdutosLambdaMelhorado() {

        List<Product> products = ProductRepository.getProducts();

        int totalElectronics = calculateTotalProducts(products,ofType(ProductType.ELECTRONIC));
        int totalFood = calculateTotalProducts(products, ofType(ProductType.FOOD));
        int totalFoodAndElectronic = calculateTotalProducts(products, ofType(ProductType.ELECTRONIC).or(ofType(ProductType.FOOD)));

        assertThat(totalElectronics, is(6));
        assertThat(totalFood, is(58));
        assertThat(totalFoodAndElectronic, is(64));
    }
}
