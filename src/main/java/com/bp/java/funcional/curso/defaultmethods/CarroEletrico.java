package com.bp.java.funcional.curso.defaultmethods;

public interface CarroEletrico extends Veiculo{

    @Override
    default void ligarMotor() {
        System.out.println("Ligando motor eletrico");
    }
}
