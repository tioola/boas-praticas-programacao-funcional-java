package com.bp.java.funcional.curso.modulo06;

import com.bp.java.funcional.curso.domain.InventoryItem;
import com.bp.java.funcional.curso.domain.Product;
import com.bp.java.funcional.curso.domain.ProductType;
import com.bp.java.funcional.curso.repository.ProductRepository;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Procrastinando {

    @Test
    public void adicionandoProdutosEletronicos() {

        List<Product> products = ProductRepository.getProducts();

        Integer amountToAdd = 2;

        List<Product> productsWithNewAmount = products.stream()
                .filter(product -> product.getType() == ProductType.ELECTRONIC)
                .map(InventoryItem::new)
                .map(inventoryItem -> inventoryItem.addToStock(2))
                .collect(Collectors.toList());

        System.out.println(productsWithNewAmount);

    }
}
