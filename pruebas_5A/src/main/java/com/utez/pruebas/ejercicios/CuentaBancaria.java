package com.utez.pruebas.ejercicios;

public class CuentaBancaria {

    // Nivel 4: Objeto con estado, comportamiento complejo y manejo de excepciones.
    // Bien hecha, pero requiere escenarios de prueba exhaustivos (pruebas de caja blanca y negra).

    private String titular;
    private double saldo;
    private boolean activa;

    // Constructor
    // Casos de prueba a realizar:
    // 1. Creación exitosa (ej. titular="Juan Pérez", saldo=500.0 -> objeto creado, activa=true)
    // 2. Creación con titular nulo o vacío (debe lanzar IllegalArgumentException)
    // 3. Creación con saldo negativo (debe lanzar IllegalArgumentException)
    public CuentaBancaria(String titular, double saldoInicial) {
        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("El titular no puede estar vacío");
        }
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
        this.titular = titular;
        this.saldo = saldoInicial;
        this.activa = true;
    }

    // Ejercicio 1: Depositar
    // Casos de prueba a realizar:
    // 1. Depósito válido (ej. cuenta activa con saldo 100.0, monto 50.0 -> saldo resultante 150.0)
    // 2. Depósito de monto cero (ej. monto = 0.0 -> debe lanzar IllegalArgumentException)
    // 3. Depósito de monto negativo (ej. monto = -10.0 -> debe lanzar IllegalArgumentException)
    // 4. Depósito en cuenta inactiva (ej. monto = 50.0 -> debe lanzar IllegalStateException)
    public void depositar(double monto) {
        if (!activa) {
            throw new IllegalStateException("La cuenta está inactiva");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser mayor a cero");
        }
        this.saldo += monto;
    }

    // Ejercicio 2: Retirar
    // Casos de prueba a realizar:
    // 1. Retiro válido parcial (ej. cuenta con saldo 100.0, monto 50.0 -> saldo resultante 50.0)
    // 2. Retiro que deja el saldo en exactamente 0 (ej. cuenta con saldo 100.0, monto 100.0 -> saldo 0.0)
    // 3. Retiro de monto mayor al saldo (ej. cuenta con saldo 100.0, monto 150.0 -> debe lanzar IllegalArgumentException o una exepción custom de SaldoInsuficiente)
    // 4. Retiro de monto cero o negativo (ej. monto = 0.0 -> debe lanzar IllegalArgumentException)
    // 5. Retiro en cuenta inactiva (ej. monto = 10.0 -> debe lanzar IllegalStateException)
    public void retirar(double monto) {
        if (!activa) {
            throw new IllegalStateException("La cuenta está inactiva");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor a cero");
        }
        if (monto > this.saldo) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        this.saldo -= monto;
    }

    // Ejercicio 3: Desactivar cuenta
    // Casos de prueba a realizar:
    // 1. Desactivar cuenta activa (ej. la cuenta pasa a inactiva=false)
    // 2. Desactivar cuenta ya inactiva (ej. el estado no cambia, no lanza error)
    // 3. Intentar realizar una operación después de desactivar (verificar que lanza IllegalStateException)
    public void desactivar() {
        this.activa = false;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isActiva() {
        return activa;
    }
    
    public String getTitular() {
        return titular;
    }
}
