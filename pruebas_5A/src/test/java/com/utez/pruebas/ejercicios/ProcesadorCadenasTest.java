package com.utez.pruebas.ejercicios;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProcesadorCadenasTest {
    // Ejercicio 1: Contar vocales (Requiere refactorizar variables y estructura)

    public static ProcesadorCadenas procesadorCadenas;
    String cad;
    int resultado;

    @BeforeAll //iniciar metodos variables instancias para todas las pruebas
    public static void iniciarProcesadorCadena(){
        procesadorCadenas = new ProcesadorCadenas();
    }
    @BeforeEach // Esto funciona antes de cada prueba
    public void resetVariable(){
       cad = "";
       resultado=0;
    }

    // Casos de prueba a realizar:

    // 1. Cadena normal con varias vocales (ej. cad="Hola Mundo" -> 4)
    /*
    ID: PC_Cadenas_001
    Titulo: Cadena Normal con varias vocales
    Prioridad: Alta
    Precondiciones:
        -Instancia de ProcesadorCadenas iniciada.
        -Variabes cad y resultado estan inicializadas en UN String vacio y 0.
    Datos de prueba:
        -cad=Hola Mundo

    Pasos a ejecutar:
        1° Asignar los valores a las variable cad
        2° Asignar a reslutado lo que retorna ProcesadorCadenas.cV
            2.1 Colocar el valor de cad como primer parametro.
    Resultado esperado:
        resultado=4
     */

    @Test
    public void cadenaNormlaVariasVocales(){
        cad="Hola Mundo";
        resultado= procesadorCadenas.cV(cad);
        //Evaluar el resultado esperado
        assertEquals(4,resultado);
    }


    // 2. Cadena sin vocales (ej. cad="xyz pt" -> 0)
    /*
    ID: PC_Cadenas_002
    Titulo: Cadenas sin vocales
    Prioridad: Alta
    Precondiciones:
        -Instancia de ProcesadorCadenas iniciada.
        -Variabes cad y resultado estan inicializadas en UN String vacio y 0.
    Datos de prueba:
        -cad=xyz pt
    Pasos a ejecutar:
        1° Asignar los valores a las variable cad
        1° Asignar a reslutado lo que retorna ProcesadorCadenas.cV
            1.1 Colocar el valor de cad como primer parametro.
    Resultado esperado:
        result=0
     */

    @Test
    public void cadenaSinVocales(){
        cad="xyz pt";
        resultado= procesadorCadenas.cV(cad);
        //Evaluar el resultado esperado
        assertEquals(0,resultado);
    }

    // 3. Cadena vacía (ej. cad="" -> 0)
     /*
    ID: PC_Cadenas_003
    Titulo: Cadena vacia
    Prioridad: Alta
    Precondiciones:
        -Instancia de ProcesadorCadenas iniciada.
        -Variabes cad y resultado estan inicializadas en UN String vacio y 0.
    Datos de prueba:
        -cad="";
    Pasos a ejecutar:
        1° Asignar los valores a las variable cad
        1° Asignar a reslutado lo que retorna ProcesadorCadenas.cV
            1.1 Colocar el valor de cad como primer parametro.
    Resultado esperado:
        result=0
     */

    @Test
    public void cadenaVacia(){
        cad="";
        resultado= procesadorCadenas.cV(cad);
        //Evaluar el resultado esperado
        assertEquals(0,resultado);
    }

    // 4. Cadena nula (ej. cad=null -> 0)
    /*
    ID: PC_Cadenas_004
    Titulo: Cadena Nula
    Prioridad: Alta
    Precondiciones:
        -Instancia de ProcesadorCadenas iniciada.
        -Variabes cad y resultado estan inicializadas en UN String vacio y 0.
    Datos de prueba:
        -cad=null;
    Pasos a ejecutar:
        1° Asignar los valores a las variable cad
        1° Asignar a reslutado lo que retorna ProcesadorCadenas.cV
            1.1 Colocar el valor de cad como primer parametro.
    Resultado esperado:
        result=0
     */

    @Test
    public void cadenaNula(){
        cad=null;
        resultado= procesadorCadenas.cV(cad);
        //Evaluar el resultado esperado
        assertEquals(0,resultado);
    }

    // 5. Cadena con vocales con acentos (OJO: el código actual falla con acentos,
    //    ej "canción" -> daría 2 en vez de 3. Validar el comportamiento actual en el test,
    //    y luego plantear cómo refactorizar para soportar acentos).
    /*
    ID: PC_Cadenas_005
    Titulo: Cadena con acentos
    Prioridad: Alta
    Precondiciones:
        -Instancia de ProcesadorCadenas iniciada.
        -Variabes cad y resultado estan inicializadas en UN String vacio y 0.
    Datos de prueba:
        -cad=canción;
    Pasos a ejecutar:
        1° Asignar los valores a las variable cad
        1° Asignar a reslutado lo que retorna ProcesadorCadenas.cV
            1.1 Colocar el valor de cad como primer parametro.
    Resultado esperado:
        resultado=3
     */

    @Test
    public void cadenaCOnAcentos(){
        cad="canción";
        resultado= procesadorCadenas.cV(cad);
        //Evaluar el resultado esperado
        assertEquals(3,resultado);
    }

}