package com.bp.java.funcional.curso.domain;

@FunctionalInterface
public interface ProductFinder {

    Product findProduct(Long id);

}
