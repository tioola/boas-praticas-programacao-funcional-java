package com.bp.java.funcional.curso.utils;

import java.util.stream.Stream;

@FunctionalInterface
public interface TailCall<T> {

    TailCall<T> apply();

    default boolean isComplete(){
        return false;
    }

    default T result(){
        throw new IllegalArgumentException("Not possible");
    }

    default T invoke(){

        return Stream.iterate(this, TailCall::apply)
                .filter(TailCall::isComplete)
                .findFirst()
                .get()
                .result();

    }

}
