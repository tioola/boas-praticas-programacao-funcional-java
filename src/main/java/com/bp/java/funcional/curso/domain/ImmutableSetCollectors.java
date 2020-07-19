package com.bp.java.funcional.curso.domain;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ImmutableSetCollectors<T> implements Collector<T, ImmutableSet.Builder, ImmutableSet<T>> {
    @Override
    public Supplier<ImmutableSet.Builder> supplier() {
        return ImmutableSet::builder;
    }

    @Override
    public BiConsumer<ImmutableSet.Builder, T> accumulator() {
        return ImmutableSet.Builder::add;
    }

    @Override
    public BinaryOperator<ImmutableSet.Builder> combiner() {
        return (left, right) -> left.add(right.build());
    }

    @Override
    public Function<ImmutableSet.Builder, ImmutableSet<T>> finisher() {
        return ImmutableSet.Builder::build;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Sets.immutableEnumSet(Characteristics.UNORDERED);
    }

    public static <T> ImmutableSetCollectors<T> toImmutableSet(){
        return new ImmutableSetCollectors<>();
    }

}
