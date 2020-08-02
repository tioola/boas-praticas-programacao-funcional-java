package com.bp.java.funcional.curso.domain;

import java.util.concurrent.TimeUnit;

public class BadImplementedTppApi {

    private InventoryItem inventoryItem;

    public BadImplementedTppApi(InventoryItem inventoryItem){

        System.out.println("Creating bad implemented tpp api");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.inventoryItem = inventoryItem;
    }

    public Product addToStock(Integer amount) {
        if(isInventoryAvailableForProduct()){
            return inventoryItem.getProduct().increaseAmount(amount);
        }
        return inventoryItem.getProduct();
    }

    private boolean isInventoryAvailableForProduct() {
        return true;
    }
}
