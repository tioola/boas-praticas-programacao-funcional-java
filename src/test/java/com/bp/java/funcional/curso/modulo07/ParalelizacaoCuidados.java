package com.bp.java.funcional.curso.modulo07;

import org.junit.Test;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParalelizacaoCuidados {

    @Test
    public void streamInfinita() {

        Instant start = Instant.now();

        Stream.iterate(1, (n) -> n+1)
                .parallel()
                .limit(100)
                .forEach(System.out::println);

        Instant end = Instant.now();

        long duration = Duration.between(start, end).toMillis();

        System.out.println(String.format("Time in millis %s", duration));
    }


    @Test
    public void countComParallel() {

        Instant start = Instant.now();

        long count = LongStream.rangeClosed(2, 2000000L)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();

        Instant end = Instant.now();

        long duration = Duration.between(start, end).toMillis();

        System.out.println(String.format("Time in millis %s", duration));

    }
}
