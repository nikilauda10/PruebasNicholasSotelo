package com.utez.pruebas.ejercicios;

public class Calculadora {

    // Nivel 1: Código simple y bien hecho para iniciar con pruebas

    // Ejercicio 1: Suma básica
    // Casos de prueba a realizar:
    // 1. Suma de dos números positivos (ej. a=5, b=3 -> 8)
    // 2. Suma de ceros (ej. a=0, b=0 -> 0)
    // 3. Suma de números negativos (ej. a=-2, b=-3 -> -5)
    // 4. Suma de un positivo y un negativo (ej. a=5, b=-2 -> 3)
    public int sumar(int a, int b) {
        return a + b;
    }

    // Ejercicio 2: División segura
    // Casos de prueba a realizar:
    // 1. División exacta (ej. numerador=10, denominador=2 -> 5.0)
    // 2. División con decimales (ej. numerador=5, denominador=2 -> 2.5)
    // 3. División por cero (ej. numerador=10, denominador=0 -> debe lanzar IllegalArgumentException)
    // 4. Numerador cero (ej. numerador=0, denominador=5 -> 0.0)
    public double dividir(double numerador, double denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser cero");
        }
        return (double) numerador / denominador;
    }
}
