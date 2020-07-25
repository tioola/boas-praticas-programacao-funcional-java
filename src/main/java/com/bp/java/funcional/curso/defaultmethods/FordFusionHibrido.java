package com.bp.java.funcional.curso.defaultmethods;

public class FordFusionHibrido implements CarroCombustao, CarroEletrico{

    @Override
    public void ligarMotor() {
        System.out.println("Ligando motor ford fusion hibrido");
    }
}
