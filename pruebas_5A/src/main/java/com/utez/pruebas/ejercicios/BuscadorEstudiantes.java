package com.utez.pruebas.ejercicios;

import java.util.List;

public class BuscadorEstudiantes {

    // Nivel 3: Código con bugs intencionales (Not well made).
    // Los alumnos deben descubrir los bugs a través de los tests unitarios
    // y luego corregir el código.

    // Ejercicio 1: Buscar en una lista
    // Bug 1: Falla si la lista es nula (Lanza NullPointerException).
    // Bug 2: IndexOutOfBoundsException porque usa i <= estudiantes.size() en el bucle for.
    // Bug 3: Es sensible a mayúsculas/minúsculas ("juan" fallará si en la lista está "Juan").
    // Bug 4: Espacios en blanco (" Juan " fallará si en la lista está "Juan").
    //
    // Casos de prueba a realizar:
    // 1. Nombre presente en la lista exactamente igual (ej. lista=["Ana", "Juan"], nombre="Ana" -> true)
    // 2. Nombre no presente en la lista (ej. lista=["Ana", "Juan"], nombre="Pedro" -> false)
    // 3. (Caso que revelará bug) Nombre presente pero con diferencias de mayúsculas/minúsculas 
    //    (ej. lista=["Ana", "Juan"], nombre="juan" -> debería ser true, el test fallará inicialmente)
    // 4. (Caso que revelará bug) Lista nula (ej. lista=null, nombre="Juan" -> debería retornar false, pero lanza excepción)
    // 5. (Caso que revelará bug) Elemento buscado no está, recorre toda la lista -> lanzará IndexOutOfBoundsException al final.
    public boolean existeEstudiante(List<String> estudiantes, String nombreBuscado) {
        for (int i = 0; i <= estudiantes.size(); i++) { 
            if (estudiantes.get(i).equals(nombreBuscado)) {
                return true;
            }
        }
        return false;
    }
    
    // Ejercicio 2: Calcular el promedio
    // Bug 1: Si el array está vacío, ocurre una división por cero en enteros (retorna error en vez de 0.0 o lanzar objeción limpia).
    // Bug 2: Si hay notas negativas que no sean lógicas, igual las suma sin validar.
    //
    // Casos de prueba a realizar:
    // 1. Array con calificaciones normales (ej. notas=[100, 90, 80] -> 90.0)
    // 2. (Caso que revelará bug) Array vacío (ej. notas=[] -> debería ser 0.0 o excepción clara, pero falla por división por 0)
    // 3. Array nulo (ej. notas=null -> NullPointerException)
    // 4. Array con una sola nota (ej. notas=[85] -> 85.0)
    public double calcularPromedio(int[] notas) {
        int suma = 0;
        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }
        return (double) (suma / notas.length); 
    }
}
