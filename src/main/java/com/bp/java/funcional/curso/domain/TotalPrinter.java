package com.bp.java.funcional.curso.domain;

import java.util.function.Function;
import java.util.function.LongToDoubleFunction;

public class TotalPrinter {

    private LongToDoubleFunction totalFinder;

    public TotalPrinter(LongToDoubleFunction totalFinder) {
        this.totalFinder = totalFinder;
    }

    public void printTotal(Long id){
        System.out.println(String.format("total is: %s",this.totalFinder.applyAsDouble(id)));
    }
}
