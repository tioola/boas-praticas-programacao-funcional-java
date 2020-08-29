package com.bp.java.funcional.curso.modulo08;

import com.bp.java.funcional.curso.utils.TailCall;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static com.bp.java.funcional.curso.utils.TailCalls.call;
import static com.bp.java.funcional.curso.utils.TailCalls.done;

public class TailCallTest {

    @Test
    public void recursionProblem() {

        class FactorialCalculator {

            public int calculateFactorialRec(final int number){

                if(number == 1) return number;

                return number * calculateFactorialRec(number-1);

            }

        }

        FactorialCalculator factorialCalculator = new FactorialCalculator();
        System.out.println(factorialCalculator.calculateFactorialRec(30000));

    }


    @Test
    public void fixingRecursionWithTailCall() {

        System.out.println(factorial(BigInteger.valueOf(30000)));

    }

    private static BigInteger factorial(final BigInteger number){
        return factorialTailRec(BigInteger.ONE, number).invoke();
    }

    private static TailCall<BigInteger> factorialTailRec(final BigInteger factorial, final BigInteger number){

        if(number.equals(BigInteger.ONE)){
            return done(factorial);
        }else {
            return call(() -> factorialTailRec(factorial.multiply(number), number.subtract(BigInteger.ONE)));
        }

    }

}
