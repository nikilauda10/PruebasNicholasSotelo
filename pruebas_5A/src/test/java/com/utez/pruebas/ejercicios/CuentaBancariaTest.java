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

// Casos de prueba a realizar:
// 1. Creación exitosa (ej. titular="Juan Pérez", saldo=500.0 -> objeto creado, activa=true)
    /*
    ID: PC_CuentaBancaria_001
    Titulo: Creación exitosa de cuenta
    Prioridad: Alta
    Precondiciones: s
    Datos de prueba:
        -titular="Juan Pérez"
        -saldoInicial=500.0
    Pasos a ejecutar:
        1° Asignar "Juan Pérez" a titular y 500.0 a saldoInicial.
        2° Instanciar cuentaBancaria.
    Resultado esperado:
        titular="Juan Pérez", saldo=500.0, activa=true.
    */
@Test
public void crearCuentaExitosa() {
    titular = "Juan Pérez";
    saldoInicial = 500.0;
    cuentaBancaria = new CuentaBancaria(titular, saldoInicial);

    assertEquals("Juan Pérez", cuentaBancaria.getTitular());
    assertEquals(500.0, cuentaBancaria.getSaldo());
    assertTrue(cuentaBancaria.isActiva());
}

// 2. Creación con titular nulo o vacío (debe lanzar IllegalArgumentException)
   /*
    ID: PC_CuentaBancaria_002
    Titulo: Verificar error al crear cuenta con titular vacío
    Prioridad: Alta
    Precondiciones:
        - Instancia de CuentaBancaria declarada.
        - Variables titular y saldoInicial listas para asignar.
    Datos de prueba:
        - titular = "";
        - saldoInicial = 100.0;
    Pasos a ejecutar:
        1° Asignar los valores a las variables titular y saldoInicial.
        2° Intentar instanciar new CuentaBancaria(titular, saldoInicial) dentro de un bloque try-catch.
    Resultado esperado:
        Se debe capturar una IllegalArgumentException con el mensaje "El titular no puede estar vacío".
    */
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


    // 3. Creación con saldo negativo (debe lanzar IllegalArgumentException)
    /*
    ID: PC_CuentaBancaria_003
    Titulo: Verificar error al crear cuenta con saldo inicial negativo
    Prioridad: Alta
    Precondiciones:
        - Instancia de CuentaBancaria declarada.
        - Variables titular y saldoInicial listas para asignar.
    Datos de prueba:
        - titular = "Juan Pérez";
        - saldoInicial = -50.0;
    Pasos a ejecutar:
        1° Asignar los valores a las variables titular y saldoInicial.
        2° Intentar instanciar new CuentaBancaria(titular, saldoInicial) dentro de un bloque try-catch.
    Resultado esperado:
        Se debe capturar una IllegalArgumentException con el mensaje "El saldo inicial no puede ser negativo".
    */
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

    // --- Ejercicio 1: Depositar ---

    // 1. Depósito válido (ej. cuenta activa con saldo 100.0, monto 50.0 -> saldo resultante 150.0)
    /*
    ID: PC_CuentaBancaria_004
    Titulo: Verificar depósito válido en cuenta activa
    Prioridad: Alta
    Precondiciones:
        - Instancia de cuentaBancaria inicializada con 100.0 en el resetVariables.
    Datos de prueba:
        - monto = 50.0;
    Pasos a ejecutar:
        1° Asignar el valor a la variable monto.
        2° Ejecutar el método cuentaBancaria.depositar(monto).
    Resultado esperado:
        El saldo actual debe ser 150.0.
    */
    @Test
    public void depositarMontoValido() {
        // Forzamos el saldo inicial para que coincida con el ejemplo
        cuentaBancaria = new CuentaBancaria("Juan Pérez", 100.0);
        monto = 50.0;

        cuentaBancaria.depositar(monto);

        assertEquals(150.0, cuentaBancaria.getSaldo(), 0.001);
    }

    // 2. Depósito de monto cero (monto = 0.0 -> debe lanzar IllegalArgumentException)
    /*
    ID: PC_CuentaBancaria_005
    Titulo: Verificar error al depositar monto de cero
    Prioridad: Media
    Precondiciones:
        - Instancia de cuentaBancaria inicializada.
    Datos de prueba:
        - monto = 0.0;
    Pasos a ejecutar:
        1° Asignar el valor 0.0 a la variable monto.
        2° Intentar ejecutar cuentaBancaria.depositar(monto) en un bloque try-catch.
    Resultado esperado:
        Lanza IllegalArgumentException: "El monto a depositar debe ser mayor a cero".
    */
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

    // 3. Depósito de monto negativo (monto = -10.0 -> debe lanzar IllegalArgumentException)
    /*
    ID: PC_CuentaBancaria_006
    Titulo: Verificar error al depositar monto negativo
    Prioridad: Alta
    Precondiciones:
        - Instancia de cuentaBancaria inicializada.
    Datos de prueba:
        - monto = -10.0;
    Pasos a ejecutar:
        1° Asignar el valor -10.0 a la variable monto.
        2° Intentar ejecutar cuentaBancaria.depositar(monto) en un bloque try-catch.
    Resultado esperado:
        Lanza IllegalArgumentException: "El monto a depositar debe ser mayor a cero".
    */
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

    // 4. Depósito en cuenta inactiva (monto = 50.0 -> debe lanzar IllegalStateException)
    /*
    ID: PC_CuentaBancaria_007
    Titulo: Verificar error al depositar en cuenta inactiva
    Prioridad: Alta
    Precondiciones:
        - Instancia de cuentaBancaria inicializada y desactivada.
    Datos de prueba:
        - monto = 50.0;
    Pasos a ejecutar:
        1° Desactivar la cuenta con cuentaBancaria.desactivar().
        2° Intentar ejecutar cuentaBancaria.depositar(monto) en un bloque try-catch.
    Resultado esperado:
        Lanza IllegalStateException: "La cuenta está inactiva".
    */
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

// --- Ejercicio 2: Retirar ---

    // 1. Retiro válido parcial (ej. cuenta con saldo 100.0, monto 50.0 -> saldo resultante 50.0)
    /*
    ID: PC_CuentaBancaria_008
    Titulo: Verificar retiro válido parcial
    Prioridad: Alta
    Precondiciones:
        - Instancia de cuentaBancaria con saldo de 100.0.
    Datos de prueba:
        - monto = 50.0;
    Pasos a ejecutar:
        1° Crear instancia con saldoInicial de 100.0.
        2° Ejecutar el metodo cuantaBancaria.retirar(monto)
    Resultado esperado:
        El saldo resultante debe ser 50.0.
    */
    @Test
    public void retirarMontoParcial() {
        cuentaBancaria = new CuentaBancaria("Juan Pérez", 100.0);
        monto = 50.0;

        cuentaBancaria.retirar(monto);

        assertEquals(50.0, cuentaBancaria.getSaldo(), 0.001);
    }

    // 2. Retiro que deja el saldo en exactamente 0 (monto 100.0 -> saldo 0.0)
    /*
    ID: PC_CuentaBancaria_009
    Titulo: Verificar retiro del saldo total (deja en cero)
    Prioridad: Alta
    Precondiciones:
        - Instancia de cuentaBancaria con saldo de 100.0.
    Datos de prueba:
        - monto = 100.0;
    Pasos a ejecutar:
        1° Crear instancia con saldoInicial de 100.0.
        2° Ejecutar el metodo cuantaBancaria.retirar(monto)
    Resultado esperado:
        El saldo resultante debe ser 0.0.
    */
    @Test
    public void retirarSaldoTotal() {
        cuentaBancaria = new CuentaBancaria("Juan Pérez", 100.0);
        monto = 100.0;

        cuentaBancaria.retirar(monto);

        assertEquals(0.0, cuentaBancaria.getSaldo(), 0.001);
    }

    // 3. Retiro de monto mayor al saldo (monto 150.0 -> debe lanzar IllegalArgumentException)
    /*
    ID: PC_CuentaBancaria_010
    Titulo: Verificar error por saldo insuficiente
    Prioridad: Alta
    Precondiciones:
        - Instancia de cuentaBancaria con saldo de 100.0.
    Datos de prueba:
        - monto = 150.0;
    Pasos a ejecutar:
        1° Intentar ejecutar cuentaBancaria.retirar(monto) en un bloque try-catch.
    Resultado esperado:
        Lanza IllegalArgumentException: "Saldo insuficiente".
    */
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

    // 4. Retiro de monto cero o negativo (monto = 0.0 -> debe lanzar IllegalArgumentException)
    /*
    ID: PC_CuentaBancaria_011
    Titulo: Verificar error al retirar monto inválido (cero)
    Prioridad: Media
    Precondiciones:
        - Instancia de cuentaBancaria inicializada.
    Datos de prueba:
        - monto = 0.0;
    Pasos a ejecutar:
        1° Intentar ejecutar cuentaBancaria.retirar(monto) en un bloque try-catch.
    Resultado esperado:
        Lanza IllegalArgumentException: "El monto a retirar debe ser mayor a cero".
    */
    @Test
    public void retirarMontoInvalido() {
        monto = 0.0;
        try {
            cuentaBancaria.retirar(monto);
            fail("Debería haber lanzado IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Atrapamos el error de monto mayor a cero ✅
            assertEquals("El monto a retirar debe ser mayor a cero", e.getMessage());
        }
    }

    // 5. Retiro en cuenta inactiva (monto = 10.0 -> debe lanzar IllegalStateException)
    /*
    ID: PC_CuentaBancaria_012
    Titulo: Verificar error al retirar en cuenta inactiva
    Prioridad: Alta
    Precondiciones:
        - Instancia de cuentaBancaria desactivada.
    Datos de prueba:
        - monto = 10.0;
    Pasos a ejecutar:
        1° Desactivar la cuenta.
        2° Intentar ejecutar cuentaBancaria.retirar(monto) en un bloque try-catch.
    Resultado esperado:
        Lanza IllegalStateException: "La cuenta está inactiva".
    */
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


// --- Ejercicio 3: Desactivar cuenta ---

    // 1. Desactivar cuenta activa (ej. la cuenta pasa a inactiva=false)
    /*
    ID: PC_CuentaBancaria_013
    Titulo: Verificar desactivación de cuenta activa
    Prioridad: Media
    Precondiciones:
        - Instancia de cuentaBancaria activa (por defecto al crear).
    Datos de prueba: N/A
    Pasos a ejecutar:
        1° Llamar al método cuentaBancaria.desactivar().
        2° Verificar el estado con cuentaBancaria.isActiva().
    Resultado esperado:
        El método isActiva() debe retornar false.
    */
    @Test
    public void desactivarCuentaActiva() {
        // La cuenta ya viene activa desde el BeforeEach
        cuentaBancaria.desactivar();

        assertFalse(cuentaBancaria.isActiva());
    }

    // 2. Desactivar cuenta ya inactiva (ej. el estado no cambia, no lanza error)
    /*
    ID: PC_CuentaBancaria_014
    Titulo: Verificar desactivación de cuenta que ya estaba inactiva
    Prioridad: Baja
    Precondiciones:
        - Instancia de cuentaBancaria previamente desactivada.
    Datos de prueba: N/A
    Pasos a ejecutar:
        1° Llamar a cuentaBancaria.desactivar() por primera vez.
        2° Llamar a cuentaBancaria.desactivar() por segunda vez.
    Resultado esperado:
        No debe lanzar errores y el estado debe seguir siendo false.
    */
    @Test
    public void desactivarCuentaYaInactiva() {
        cuentaBancaria.desactivar(); // Primera vez
        assertFalse(cuentaBancaria.isActiva());

        cuentaBancaria.desactivar(); // Segunda vez
        assertFalse(cuentaBancaria.isActiva());
    }

    // 3. Intentar realizar una operación después de desactivar (verificar que lanza IllegalStateException)
    /*
    ID: PC_CuentaBancaria_015
    Titulo: Verificar que no se puede retirar tras desactivar la cuenta
    Prioridad: Alta
    Precondiciones:
        - Instancia de cuentaBancaria inicializada y desactivada.
    Datos de prueba:
        - monto = 20.0;
    Pasos a ejecutar:
        1° Llamar a cuentaBancaria.desactivar().
        2° Intentar ejecutar cuentaBancaria.retirar(monto) en un bloque try-catch.
    Resultado esperado:
        Lanza IllegalStateException: "La cuenta está inactiva".
    */
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


