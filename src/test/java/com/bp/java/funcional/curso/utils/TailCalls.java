package com.bp.java.funcional.curso.utils;

public class TailCalls<T> {

    public static <T> TailCall<T> call(final TailCall<T> next){
        return next;
    }

    public static <T> TailCall<T> done(final T value){

        return new TailCall<T>() {
            @Override
            public TailCall<T> apply() {
                throw new IllegalArgumentException("Should not be called in done.");
            }

            @Override
            public boolean isComplete() {
                return true;
            }

            @Override
            public T result() {
                return value;
            }
        };

    }

}
