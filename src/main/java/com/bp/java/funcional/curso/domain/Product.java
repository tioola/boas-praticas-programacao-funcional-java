package com.bp.java.funcional.curso.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private Long id;

    private String description;

    private ProductType type;

    private BigDecimal price;

    private int amount;

    private Product(Long id, String description, ProductType type, BigDecimal price, int amount) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.price = price;
        this.amount = amount;
    }

    public static Product createProduct(Long id, String description, ProductType type, BigDecimal bigDecimal, int amount){
        return new Product(id,description,type,bigDecimal,amount);
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    // Isto não deveria ser feito
    public void setDescription(String description) {
        this.description = description;
    }

    public Product changeDescription(String newDescription){
        return new Product(this.id, newDescription,this.type,this.price,this.amount);
    }

    public Product increaseAmount(Integer amount) {
        return new Product(this.id, this.description,this.type,this.price,amount);
    }

    public ProductType getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "{\"Product\":{"
                + "                        \"id\":\"" + id + "\""
                + ",                         \"description\":\"" + description + "\""
                + ",                         \"type\":\"" + type + "\""
                + ",                         \"price\":\"" + price + "\""
                + ",                         \"amount\":\"" + amount + "\""
                + "}}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
