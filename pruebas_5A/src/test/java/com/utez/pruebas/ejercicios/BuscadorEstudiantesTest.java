package com.utez.pruebas.ejercicios;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BuscadorEstudiantesTest {
    public static BuscadorEstudiantes buscadorEstudiantes;
    List<String> lista;
    String nombreBuscado;
    boolean resultado;

    @BeforeAll //iniciar metodos variables instancias para todas las pruebas
    public static void iniciarBuscadorEstudiantes(){
        buscadorEstudiantes = new BuscadorEstudiantes();
    }
    @BeforeEach // Esto funciona antes de cada prueba
    public void resetVariable(){
        lista= Collections.emptyList();
        nombreBuscado="";
        resultado=false;
    }


    // Ejercicio 1: Buscar en una lista
    // Bug 1: Falla si la lista es nula (Lanza NullPointerException).
    // Bug 2: IndexOutOfBoundsException porque usa i <= estudiantes.size() en el bucle for.
    // Bug 3: Es sensible a mayúsculas/minúsculas ("juan" fallará si en la lista está "Juan").
    // Bug 4: Espacios en blanco (" Juan " fallará si en la lista está "Juan").



    // Casos de prueba a realizar:
    // 1. Nombre presente en la lista exactamente igual (ej. lista=["Ana", "Juan"], nombre="Ana" -> true)
    /*
    ID: PC_Buscador_001
    Titulo: Nombre presente en la lista exactamente igual
    Prioridad: Alta
    Precondiciones:
        -Instancia de BuscadorEstudiantes iniciada.
        -Variabes lista, nombreBuscado y resultado estan inicializadas en una lista vacia ,String vacio y false.
    Datos de prueba:
        -lista = [Ana,Juan]
        - nombreBuscado= "Ana"

    Pasos a ejecutar:
        1° Asignar los valores a las variable lista y nombreBuscado
        2° Asignar a reslutado lo que retorna BuscadorEstudiantes.existeEstuidante
            2.1 Colocar el valor de lista como primer parametro.
            2.2 Colocar el valor de nombreBuscado como segundo parametro
    Resultado esperado:
        resultado=true
     */


    // 2. Nombre no presente en la lista (ej. lista=["Ana", "Juan"], nombre="Pedro" -> false)
    // 3. (Caso que revelará bug) Nombre presente pero con diferencias de mayúsculas/minúsculas
    //    (ej. lista=["Ana", "Juan"], nombre="juan" -> debería ser true, el test fallará inicialmente)
    // 4. (Caso que revelará bug) Lista nula (ej. lista=null, nombre="Juan" -> debería retornar false, pero lanza excepción)
    // 5. (Caso que revelará bug) Elemento buscado no está, recorre toda la lista -> lanzará IndexOutOfBoundsException al final.
}