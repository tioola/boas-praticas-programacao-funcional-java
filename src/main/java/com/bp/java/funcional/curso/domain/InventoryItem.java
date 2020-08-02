package com.bp.java.funcional.curso.domain;

import java.util.function.Supplier;

public class InventoryItem {

    private Product product;

    private Supplier<BadImplementedTppApi> badImplementedTppApiSupplier = () -> getBadImplementedTppApi();

    public InventoryItem(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public Product addToStock(Integer amount){
        return this.badImplementedTppApiSupplier.get().addToStock(amount);
    }

    public synchronized BadImplementedTppApi getBadImplementedTppApi() {
        if(!BadImplementedTppApiHolder.class.isInstance(badImplementedTppApiSupplier)){
            this.badImplementedTppApiSupplier = new BadImplementedTppApiHolder(this);
        }
        return badImplementedTppApiSupplier.get();
    }
}

class BadImplementedTppApiHolder implements Supplier<BadImplementedTppApi> {

    private BadImplementedTppApi badImplementedTppApi;

    public BadImplementedTppApiHolder(InventoryItem inventoryItem) {
        this.badImplementedTppApi = new BadImplementedTppApi(inventoryItem);
    }

    @Override
    public BadImplementedTppApi get() {
        return badImplementedTppApi;
    }
}
