package com.utez.pruebas.ejercicios;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculadoraTest {
    // Ejercicio 1: Suma básica
   public static Calculadora calculadora;  //Definicion de variables globales. y tienen que estar estatic para aseeurar mas la estancia y que no cambie durante la ejecucion de la prueba
    int a=0 ,b=0;
    int result=0;
    @BeforeAll //iniciar metodos variables instancias para todas las pruebas
    public static void iniciarCalculadora(){
         calculadora = new Calculadora();
    }

    @BeforeEach // Esto funciona antes de cada prueba
    public void resetVariables(){
        a=0;
        b=0;
        result=0;
    }

    // Casos de prueba a realizar:
    // 1. Suma de dos números positivos (ej. a=5, b=3 -> 8)
    /*
    ID: CP_CALCULADORA_001
    Titulo: Suma de dos numeros positivos
    Prioridad: Alta
    Precondiciones:
        -Instancia de calculadora iniciada.
        -Variabes a,b y result estan inicializadas en 0
    Datos de prueba:
        -a=5
        -b=3
    Pasos a ejecutar:
        1° Asignar los valores a las variables a y b
        2° Asignar a reslut lo que retorna calulcadora.suma
            2.1 Colocar el valor de a como primer parametro.
            2.2 Colocar el valor de b como segundo parametro.
    Resultado esperado:
        result=8
     */
    @Test
    public void sumaPositivosTest(){
        a=5;
        b=3;
        result= calculadora.sumar(a,b);
        //Evaluar el resultado esperado
        assertEquals(8,result);
    }

    // 2. Suma de ceros (ej. a=0, b=0 -> 0)
     /*
    ID: CP_CALCULADORA_002
    Titulo: Suma de ceros
    Prioridad: Alta
    Precondiciones:
        -Instancia de calculadora iniciada.
        -Variabes a,b y result estan inicializadas en 0
    Datos de prueba:
        -a=0
        -b=0
    Pasos a ejecutar:
        1° Asignar los valores a las variables a y b
        2° Asignar a reslut lo que retorna calulcadora.suma
            2.1 Colocar el valor de a como primer parametro.
            2.2 Colocar el valor de b como segundo parametro.
    Resultado esperado:
        result=0
     */
    @Test
    public void sumarCeros(){
        a=0;
        b=0;
        result=calculadora.sumar(a,b);

        assertEquals(0,result);
    }
    // 3. Suma de números negativos (ej. a=-2, b=-3 -> -5)
    /*
    ID: CP_CALCULADORA_003
    Titulo: Suma de negativos
    Prioridad: Alta
    Precondiciones:
        -Instancia de calculadora iniciada.
        -Variabes a,b y result estan inicializadas en 0
    Datos de prueba:
        -a=-2
        -b=-3
    Pasos a ejecutar:
        1° Asignar los valores a las variables a y b
        2° Asignar a reslut lo que retorna calulcadora.suma
            2.1 Colocar el valor de a como primer parametro.
            2.2 Colocar el valor de b como segundo parametro.
    Resultado esperado:
        result=-5
     */
    @Test
    public void sumarNegativos(){
        a=-2;
        b=-3;
        result=calculadora.sumar(a,b);

        assertEquals(-5,result);
    }
    // 4. Suma de un positivo y un negativo (ej. a=5, b=-2 -> 3)
/*
    ID: CP_CALCULADORA_004
    Titulo: Suma de positivos y negativos
    Prioridad: Alta
    Precondiciones:
        -Instancia de calculadora iniciada.
        -Variabes a,b y result estan inicializadas en 0
    Datos de prueba:
        -a=5
        -b=-2
    Pasos a ejecutar:
        1° Asignar los valores a las variables a y b
        2° Asignar a reslut lo que retorna calulcadora.suma
            2.1 Colocar el valor de a como primer parametro.
            2.2 Colocar el valor de b como segundo parametro.
    Resultado esperado:
        result=3
     */
    @Test
    public void sumarPositivosNegativos(){
        a=5;
        b=-2;
        result=calculadora.sumar(a,b);

        assertEquals(3,result);
    }





    // Ejercicio 2: División segura
    public static Calculadora calculadoraDivision;
    double numerador=0;
    double   denominador=0;
    double resultado=0;
    @BeforeAll
    public static void iniciarCalculadoraDivision(){
        calculadoraDivision = new Calculadora();
    }
    @BeforeEach
    public void resetVariablesDivision(){
        numerador=0;
        denominador=0;
        resultado=0;
    }

    // Casos de prueba a realizar:
    // 1. División exacta (ej. numerador=10, denominador=2 -> 5.0)
    /*
    ID: CP_CALCULADORA_005
    Titulo: Divicion Exacta
    Prioridad: Alta
    Precondiciones:
        -Instancia de calculadora iniciada.
        -Variabes a,b y result estan inicializadas en 0
    Datos de prueba:
        -numerador=10
        -denominador=2
    Pasos a ejecutar:
        1° Asignar los valores a las variables a y b
        2° Asignar a reslut lo que retorna calulcadora.suma
            2.1 Colocar el valor de a como primer parametro.
            2.2 Colocar el valor de b como segundo parametro.
    Resultado esperado:
        result=5.0
     */
    @Test
    public void divicionExacta(){
        numerador= 10;
        denominador=2;
        resultado=calculadoraDivision.dividir(numerador,denominador);

        assertEquals(5.0,resultado);
    }
    // 2. División con decimales (ej. numerador=5, denominador=2 -> 2.5)
     /*
    ID: CP_CALCULADORA_006
    Titulo: Divicion con decimales
    Prioridad: Alta
    Precondiciones:
        -Instancia de calculadora iniciada.
        -Variabes a,b y result estan inicializadas en 0
    Datos de prueba:
        -numerador=5
        -denominador=2
    Pasos a ejecutar:
        1° Asignar los valores a las variables numerador y denominador
        2° Asignar a reslut lo que retorna calulcadora.division
            2.1 Colocar el valor de numerador como primer parametro.
            2.2 Colocar el valor de b denominador segundo parametro.
    Resultado esperado:
        result=2.5
     */
    @Test
    public void divicionDecimales(){
        numerador= 5;
        denominador=2;
        resultado=calculadoraDivision.dividir(numerador,denominador);

        assertEquals(2.5,resultado);
    }



    // 3. División por cero (ej. numerador=10, denominador=0 -> debe lanzar IllegalArgumentException)
     /*
    ID: CP_CALCULADORA_007
    Titulo: Divicion con cero
    Prioridad: Alta
    Precondiciones:
        -Instancia de calculadora iniciada.
        -Variabes a,b y result estan inicializadas en 0
    Datos de prueba:
        -numerador=10
        -denominador=0
    Pasos a ejecutar:
        1° Asignar los valores a las variables numerador y denominador
        2° Asignar a reslut lo que retorna calulcadora.division
            2.1 Colocar el valor de numerador como primer parametro.
            2.2 Colocar el valor de b denominador segundo parametro.
    Resultado esperado:
        result=IllegalArgumentException("El denominador no puede ser cero");
     */
    @Test
    public void divicionCero(){

            numerador = 10;
            denominador = 0;
        try {
            calculadoraDivision.dividir(numerador, denominador);
            fail("Debería haber lanzado IllegalArgumentException y no lo hizo");
        } catch (IllegalArgumentException e) {
            assertEquals("El denominador no puede ser cero", e.getMessage());
        }
    }


    // 4. Numerador cero (ej. numerador=0, denominador=5 -> 0.0)
     /*
    ID: CP_CALCULADORA_008
    Titulo: Divicion con numerador en 0
    Prioridad: Alta
    Precondiciones:
        -Instancia de calculadora iniciada.
        -Variabes a,b y result estan inicializadas en 0
    Datos de prueba:
        -numerador=0
        -denominador=5
    Pasos a ejecutar:
        1° Asignar los valores a las variables numerador y denominador
        2° Asignar a reslut lo que retorna calulcadora.division
            2.1 Colocar el valor de numerador como primer parametro.
            2.2 Colocar el valor de b denominador segundo parametro.
    Resultado esperado:
        result=0.0
     */
    @Test
    public void divicionNumeradorCero(){
        numerador= 0;
        denominador=5;
        resultado=calculadoraDivision.dividir(numerador,denominador);

        assertEquals(0.0,resultado);
    }

}