package com.utez.pruebas.ejercicios;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CuentaBancariaTest {

    public static CuentaBancaria cuentaBancaria;
    String titular;
    double saldoInicial;
    double monto;
    boolean resultadoActiva;


    @BeforeAll
    public static void iniciar(){}

    @BeforeEach
    public void resetVariables(){
        titular = "";
        saldoInicial = 0;
        monto = 0;
        resultadoActiva = false;
        cuentaBancaria = new CuentaBancaria("Juan Pérez", 500.0);
    }


@Test
public void crearCuentaExitosa() {
    titular = "Juan Pérez";
    saldoInicial = 500.0;
    cuentaBancaria = new CuentaBancaria(titular, saldoInicial);

    assertEquals("Juan Pérez", cuentaBancaria.getTitular());
    assertEquals(500.0, cuentaBancaria.getSaldo());
    assertTrue(cuentaBancaria.isActiva());
}


@Test
public void crearCuentaTitularVacio() {
    titular = "";
    saldoInicial = 100.0;

    try {
        new CuentaBancaria(titular, saldoInicial);
        // Si el código llega aquí, es que NO lanzó la excepción, por lo tanto el test debe fallar
        fail("La prueba falló: Se esperaba IllegalArgumentException por titular vacío pero no se lanzó.");
    } catch (IllegalArgumentException e) {
        // Si entra aquí, verificamos que el mensaje sea el correcto
        assertEquals("El titular no puede estar vacío", e.getMessage());
    }
}



    @Test
    public void crearCuentaSaldoNegativo() {
        titular = "Juan Pérez";
        saldoInicial = -50.0;

        try {
            new CuentaBancaria(titular, saldoInicial);
            // Si llega a esta línea, el test falló porque no detectó el saldo negativo
            fail("La prueba falló: Se esperaba IllegalArgumentException por saldo negativo pero no se lanzó.");
        } catch (IllegalArgumentException e) {
            // Verificamos que el mensaje de error sea el que definimos en la clase CuentaBancaria
            assertEquals("El saldo inicial no puede ser negativo", e.getMessage());
        }
    }


    @Test
    public void depositarMontoValido() {
        // Forzamos el saldo inicial para que coincida con el ejemplo
        cuentaBancaria = new CuentaBancaria("Juan Pérez", 100.0);
        monto = 50.0;

        cuentaBancaria.depositar(monto);

        assertEquals(150.0, cuentaBancaria.getSaldo(), 0.001);
    }


    @Test
    public void depositarMontoCero() {
        monto = 0.0;

        try {
            cuentaBancaria.depositar(monto);
            fail("Falló: Se esperaba IllegalArgumentException por monto cero.");
        } catch (IllegalArgumentException e) {
            assertEquals("El monto a depositar debe ser mayor a cero", e.getMessage());
        }
    }


    @Test
    public void depositarMontoNegativo() {
        monto = -10.0;
        try {
            cuentaBancaria.depositar(monto);
            fail("Debería haber lanzado IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("El monto a depositar debe ser mayor a cero", e.getMessage());
        }
    }

    @Test
    public void depositarEnCuentaInactiva() {
        monto = 50.0;
        cuentaBancaria.desactivar();
        try {
            cuentaBancaria.depositar(monto);
            fail("Debería haber lanzado IllegalStateException");
        } catch (IllegalStateException e) {
            assertEquals("La cuenta está inactiva", e.getMessage());
        }
    }


    @Test
    public void retirarMontoParcial() {
        cuentaBancaria = new CuentaBancaria("Juan Pérez", 100.0);
        monto = 50.0;

        cuentaBancaria.retirar(monto);

        assertEquals(50.0, cuentaBancaria.getSaldo(), 0.001);
    }


    @Test
    public void retirarSaldoTotal() {
        cuentaBancaria = new CuentaBancaria("Juan Pérez", 100.0);
        monto = 100.0;

        cuentaBancaria.retirar(monto);

        assertEquals(0.0, cuentaBancaria.getSaldo(), 0.001);
    }


    @Test
    public void retirarSaldoInsuficiente() {
        cuentaBancaria = new CuentaBancaria("Juan Pérez", 100.0);
        monto = 150.0;

        try {
            cuentaBancaria.retirar(monto);
            fail("Falló: Se esperaba IllegalArgumentException por saldo insuficiente.");
        } catch (IllegalArgumentException e) {
            assertEquals("Saldo insuficiente", e.getMessage());
        }
    }


    @Test
    public void retirarMontoInvalido() {
        monto = 0.0;
        try {
            cuentaBancaria.retirar(monto);
            fail("Debería haber lanzado IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("El monto a retirar debe ser mayor a cero", e.getMessage());
        }
    }

    @Test
    public void retirarEnCuentaInactiva() {
        monto = 10.0;
        cuentaBancaria.desactivar();

        try {
            cuentaBancaria.retirar(monto);
            fail("Falló: Se esperaba IllegalStateException por cuenta inactiva.");
        } catch (IllegalStateException e) {
            assertEquals("La cuenta está inactiva", e.getMessage());
        }
    }


    @Test
    public void desactivarCuentaActiva() {
        // La cuenta ya viene activa desde el BeforeEach
        cuentaBancaria.desactivar();

        assertFalse(cuentaBancaria.isActiva());
    }

    @Test
    public void desactivarCuentaYaInactiva() {
        cuentaBancaria.desactivar(); // Primera vez
        assertFalse(cuentaBancaria.isActiva());

        cuentaBancaria.desactivar(); // Segunda vez
        assertFalse(cuentaBancaria.isActiva());
    }

    @Test
    public void operacionPostDesactivacion() {
        monto = 20.0;
        cuentaBancaria.desactivar();

        try {
            cuentaBancaria.retirar(monto);
            fail("Falló: Se esperaba IllegalStateException al intentar retirar de cuenta inactiva.");
        } catch (IllegalStateException e) {
            assertEquals("La cuenta está inactiva", e.getMessage());
        }
    }


    }


