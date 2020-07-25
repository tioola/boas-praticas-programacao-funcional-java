package com.bp.java.funcional.curso.modulo05;

import com.bp.java.funcional.curso.defaultmethods.CarroHibrido;
import com.bp.java.funcional.curso.defaultmethods.FordFusionHibrido;
import com.bp.java.funcional.curso.defaultmethods.Mustang;
import com.bp.java.funcional.curso.defaultmethods.Tesla;
import org.junit.Test;

public class TesteDefault {

    @Test
    public void testVeiculoCombustao() {

        Mustang mustang = new Mustang();

        mustang.ligarMotor();
    }

    @Test
    public void testVeiculoEletrico() {

        Tesla tesla = new Tesla();

        tesla.ligarMotor();

    }

    @Test
    public void testCarroHibrido() {

        FordFusionHibrido fordFusionHibrido = new FordFusionHibrido();

        fordFusionHibrido.ligarMotor();

    }
}
