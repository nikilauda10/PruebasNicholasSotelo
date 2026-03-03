package com.utez.pruebas.ejercicios;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BuscadorEstudiantesTest {
    public static BuscadorEstudiantes buscadorEstudiantes;
    List<String> lista;
    String nombreBuscado;
    boolean resultado;
    int[] notas;
    double suma;

    @BeforeAll //iniciar metodos variables instancias para todas las pruebas
    public static void iniciarBuscadorEstudiantes(){
        buscadorEstudiantes = new BuscadorEstudiantes();
    }
    @BeforeEach // Esto funciona antes de cada prueba
    public void resetVariable(){
        lista= new ArrayList<>();;
        nombreBuscado="";
        resultado=false;
        notas=new int[0];
        suma=0;
    }


    // Ejercicio 1: Buscar en una lista

    // 1. Nombre presente en la lista exactamente igual (ej. lista=["Ana", "Juan"], nombre="Ana" -> true)
    /*
    ID: PC_BuscadorEstudiantes_001
    Titulo: Verificar nombre presente en la lista exactamente igual.
    Prioridad: Alta
    Precondiciones:
        -Instancia de BuscadorEstudiante iniciada.
        -Variabes lista, nombreBuscado y resultado estan inicializadas en una lista vacia, un String vacio y false.
    Datos de prueba:
        -lista= [Ana,Juan];
        -nombreBuscado="Ana"
    Pasos a ejecutar:
        1° Asignar los valores a las variable nombreBuscado
        2° Asignar a reslutado lo que retorna BuscarEstudiante.existeEstudiante
            2.1 Colocar el valor de lista como primer parametro.
            2.2 Colocar el valor de nombrBuscado como segundo parametro.
    Resultado esperado:
        resultado=True
     */
    @Test
    public void buscarEstudiantesExacamenteIgual(){
        lista.add("Ana");
        lista.add("Juan");
        nombreBuscado = "Ana";

        resultado = buscadorEstudiantes.existeEstudiante(lista, nombreBuscado);

        assertEquals(true, resultado);
    }


    // 2. Nombre no presente en la lista (ej. lista=["Ana", "Juan"], nombre="Pedro" -> false)
    /*
    ID: PC_BuscadorEstudiantes_002
    Titulo: Verificar nombre no presente en la lista
    Prioridad: Alta
    Precondiciones:
        -Instancia de BuscadorEstudiante iniciada.
        -Variabes lista, nombreBuscado y resultado estan inicializadas en una lista vacia, un String vacio y false.
    Datos de prueba:
        -lista= [Ana,Juan];
        -nombreBuscado="Pedro"
    Pasos a ejecutar:
        1° Asignar los valores a las variables lista y nombreBuscado
        2° Asignar a reslutado lo que retorna BuscarEstudiante.existeEstudiante
            2.1 Colocar el valor de lista como primer parametro.
            2.2 Colocar el valor de nombrBuscado como segundo parametro.
    Resultado esperado:
        resultado=false
     */
    @Test
    public void buscarEstudiantesNoLista(){
        lista.add("Ana");
        lista.add("Juan");
        nombreBuscado="Pedro";

        resultado = buscadorEstudiantes.existeEstudiante(lista, nombreBuscado);
        assertEquals(false,resultado);
    }


    // 3. (Caso que revelará bug) Nombre presente pero con diferencias de mayúsculas/minúsculas
    //    (ej. lista=["Ana", "Juan"], nombre="juan" -> debería ser true, el test fallará inicialmente)
    /*
    ID: PC_BuscadorEstudiantes_003
    Titulo: Verificar si es sensible a minusculas
    Prioridad: Alta
    Precondiciones:
        -Instancia de BuscadorEstudiante iniciada.
        -Variabes lista, nombreBuscado y resultado estan inicializadas en una lista vacia, un String vacio y false.
    Datos de prueba:
        -lista= [Ana,Juan];
        -nombreBuscado="juan"
    Pasos a ejecutar:
        1° Asignar los valores a las variables lista y nombreBuscado
        2° Asignar a reslutado lo que retorna BuscarEstudiante.existeEstudiante
            2.1 Colocar el valor de lista como primer parametro.
            2.2 Colocar el valor de nombrBuscado como segundo parametro.
    Resultado esperado:
        resultado= true.
     */
    @Test
    public void buscarEstudiantesMinusculas(){
        lista.add("Ana");
        lista.add("Juan");
        nombreBuscado="juan";

        resultado = buscadorEstudiantes.existeEstudiante(lista, nombreBuscado);
        assertEquals(true,resultado);
    }

    // 4. (Caso que revelará bug) Lista nula (ej. lista=null, nombre="Juan" -> debería retornar false, pero lanza excepción)
    /*
    ID: PC_BuscadorEstudiantes_004
    Titulo: Verificar con lista nula
    Prioridad: Alta
    Precondiciones:
        -Instancia de BuscadorEstudiante iniciada.
        -Variabes lista, nombreBuscado y resultado estan inicializadas en una lista vacia, un String vacio y false.
    Datos de prueba:
        -lista= null;
        -nombreBuscado="Juan "
    Pasos a ejecutar:
        1° Asignar los valores a las variables lista y nombreBuscado
        2° Asignar a reslutado lo que retorna BuscarEstudiante.existeEstudiante
            2.1 Colocar el valor de lista como primer parametro.
            2.2 Colocar el valor de nombrBuscado como segundo parametro.
    Resultado esperado:
        resultado= false.
     */

    @Test
    public void buscarEstudiantesConListaNula(){
        lista=null;
        nombreBuscado="Juan ";

        resultado = buscadorEstudiantes.existeEstudiante(lista, nombreBuscado);
        assertEquals(false,resultado);
    }



    // 5. (Caso que revelará bug) Elemento buscado no está, recorre toda la lista -> lanzará IndexOutOfBoundsException al final.
    /*
    ID: PC_BuscadorEstudiantes_005
    Titulo: Verificar Elemento que no esta en la lista.
    Prioridad: Alta
    Precondiciones:
        -Instancia de BuscadorEstudiante iniciada.
        -Variabes lista, nombreBuscado y resultado estan inicializadas en una lista vacia, un String vacio y false.
    Datos de prueba:
        -lista= [Ana,Juan];
        -nombreBuscado="Nicho"
    Pasos a ejecutar:
        1° Asignar los valores a las variables lista y nombreBuscado
        2° Asignar a reslutado lo que retorna BuscarEstudiante.existeEstudiante
            2.1 Colocar el valor de lista como primer parametro.
            2.2 Colocar el valor de nombrBuscado como segundo parametro.
    Resultado esperado:
        resultado= false.
     */

    @Test
    public void buscarEstudiantesConListaVacia(){
        lista.add("Ana");
        lista.add("Juan");
        nombreBuscado="Nicho";

        resultado=buscadorEstudiantes.existeEstudiante(lista, nombreBuscado);
        assertEquals(false,resultado);
    }


    // Ejercicio 2: Calcular el promedio
    // Bug 1: Si el array está vacío, ocurre una división por cero en enteros (retorna error en vez de 0.0 o lanzar objeción limpia).
    // Bug 2: Si hay notas negativas que no sean lógicas, igual las suma sin validar.
    //
    // Casos de prueba a realizar:
    // 1. Array con calificaciones normales (ej. notas=[100, 90, 80] -> 90.0)

    /*
    ID: PC_BuscadorEstudiantes_006
    Titulo: Verificar arreglo con calificaciones normales
    Prioridad: Alta
    Precondiciones:
        -Instancia de BuscadorEstudiante iniciada.
        -Variable notas inicializada como arreglo de enteros y variable para el resultado como double
    Datos de prueba:
        -notas= [100, 90, 80];
    Pasos a ejecutar:
        1° Asignar los valores a la variable notas
        2° Asignar a reslutado lo que retorna BuscarEstudiante.calcularPromedio
            2.1 Colocar el valor de notas como primer parametro.
    Resultado esperado:
        resultado=90
     */
    @Test
    public void buscarPromedioNormal(){
       int [] notas={100,90,80};

        suma=buscadorEstudiantes.calcularPromedio(notas);
        assertEquals(90,suma);
    }

    // 2. (Caso que revelará bug) Array vacío (ej. notas=[] -> debería ser 0.0 o excepción clara, pero falla por división por 0)
    /*
    ID: PC_BuscadorEstudiantes_007
    Titulo: Verificar arreglo vacio
    Prioridad: Alta
    Precondiciones:
        -Instancia de BuscadorEstudiante iniciada.
        -Variable notas inicializada como arreglo de enteros y variable para el resultado como double.
    Datos de prueba:
        -notas= [];
    Pasos a ejecutar:
        1° Asignar los valores a la variable notas
        2° Asignar a reslutado lo que retorna BuscarEstudiante.calcularPromedio
            2.1 Colocar el valor de notas como primer parametro.
    Resultado esperado:
        resultado=0.0
     */
    @Test
    public void buscarPromedioArregloVacio(){
        int [] notas={};

        suma=buscadorEstudiantes.calcularPromedio(notas);
        assertEquals(0.0,suma);
    }
    // 3. Array nulo (ej. notas=null -> NullPointerException)
    /*
    ID: PC_BuscadorEstudiantes_008
    Titulo: Verificar arreglo nulo
    Prioridad: Alta
    Precondiciones:
        -Instancia de BuscadorEstudiante iniciada.
        -Variable notas inicializada como arreglo de enteros y variable para el resultado como double
    Datos de prueba:
        -notas= null;
    Pasos a ejecutar:
        1° Asignar los valores a la variable notas
        2° Asignar a reslutado lo que retorna BuscarEstudiante.calcularPromedio
            2.1 Colocar el valor de notas como primer parametro.
    Resultado esperado:
        resultado=0.0
     */
    @Test
    public void buscarPromedioArregloNulo(){
        int [] notas=null;

        suma=buscadorEstudiantes.calcularPromedio(notas);
        assertEquals(0.0,suma);
    }
    // 4. Array con una sola nota (ej. notas=[85] -> 85.0)
/*
    ID: PC_BuscadorEstudiantes_009
    Titulo: Verificar arreglo con una sola nota
    Prioridad: Alta
    Precondiciones:
        -Instancia de BuscadorEstudiante iniciada.
        -Variable notas inicializada como arreglo de enteros y variable para el resultado como double
    Datos de prueba:
        -notas={85};
    Pasos a ejecutar:
        1° Asignar los valores a la variable notas
        2° Asignar a reslutado lo que retorna BuscarEstudiante.calcularPromedio
            2.1 Colocar el valor de notas como primer parametro.
    Resultado esperado:
        resultado=85.0
     */
    @Test
    public void buscarPromedioConUnaNota(){
        int [] notas={85};

        suma=buscadorEstudiantes.calcularPromedio(notas);
        assertEquals(85.0,suma);
    }
}