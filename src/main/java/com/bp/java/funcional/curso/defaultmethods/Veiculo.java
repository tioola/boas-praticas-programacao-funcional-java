package com.bp.java.funcional.curso.defaultmethods;

public interface Veiculo {

    default void ligarMotor(){
        System.out.println("Ligando motor");
    }

    default void buzina(){
        System.out.println("Beep beep!");
    }


}
