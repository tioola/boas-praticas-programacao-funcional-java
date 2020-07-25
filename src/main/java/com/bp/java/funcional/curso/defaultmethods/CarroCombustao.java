package com.bp.java.funcional.curso.defaultmethods;

public interface CarroCombustao extends Veiculo {

    @Override
    default void ligarMotor() {
        System.out.println("Ligando motor a combustao");
    }
}
