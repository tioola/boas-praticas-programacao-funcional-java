package com.bp.java.funcional.curso.defaultmethods;

public abstract class CarroHibrido implements CarroCombustao, CarroEletrico {

    private String mensagemPainel = "Ligando carro hibrido";

    /*@Override
    public void ligarMotor() {
        System.out.println(mensagemPainel);
    }*/

    public abstract void ligarMotor();
}
