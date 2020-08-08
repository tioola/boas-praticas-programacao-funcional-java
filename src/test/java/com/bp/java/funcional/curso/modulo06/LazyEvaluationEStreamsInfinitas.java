package com.bp.java.funcional.curso.modulo06;

import com.bp.java.funcional.curso.domain.Product;
import com.bp.java.funcional.curso.domain.ProductType;
import com.bp.java.funcional.curso.repository.ProductRepository;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.bp.java.funcional.curso.modulo06.PrimesUtils.calculatePrimes;
import static com.google.common.math.LongMath.isPrime;

public class LazyEvaluationEStreamsInfinitas {

    @Test
    public void testLazyEvaluation() {

        List<Integer> primes = calculatePrimes(5, 10);

        System.out.println(primes);

    }
}

class PrimesUtils {

    private static int primeAfter(final int number){
        int nextInt = number +1;
        if (isPrime(nextInt)){
            return nextInt;
        } else {
            return primeAfter(nextInt);
        }

    }


    public static List<Integer> calculatePrimes(final int from, final int count){

        int startNumber = from - 1;

        return Stream.iterate(primeAfter(startNumber), PrimesUtils::primeAfter)
                .limit(count)
                .collect(Collectors.toList());
    }

}