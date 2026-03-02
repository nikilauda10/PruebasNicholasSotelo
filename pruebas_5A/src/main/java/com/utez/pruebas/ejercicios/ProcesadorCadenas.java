package com.utez.pruebas.ejercicios;

public class ProcesadorCadenas {

    // Nivel 2: Código que "funciona" pero necesita refactorización.
    // Los alumnos deben hacer las pruebas primero para asegurar que la
    // refactorización (mejores nombres de variables, simplificación de lógica)
    // no rompa la funcionalidad actual.

    // Ejercicio 1: Contar vocales (Requiere refactorizar variables y estructura)
    // Casos de prueba a realizar:
    // 1. Cadena normal con varias vocales (ej. cad="Hola Mundo" -> 4)
    // 2. Cadena sin vocales (ej. cad="xyz pt" -> 0)
    // 3. Cadena vacía (ej. cad="" -> 0)
    // 4. Cadena nula (ej. cad=null -> 0)
    // 5. Cadena con vocales con acentos (OJO: el código actual falla con acentos, 
    //    ej "canción" -> daría 2 en vez de 3. Validar el comportamiento actual en el test,
    //    y luego plantear cómo refactorizar para soportar acentos).
    public int cV(String cad) {
        int c = 0;
        if (cad != null) {
            if (cad.length() > 0) {
                for (int i = 0; i < cad.length(); i++) {
                    char l = cad.charAt(i);
                    if (l == 'a' || l == 'e' || l == 'i' || l == 'o' || l == 'u' || l == 'A' || l == 'E' || l == 'I' || l == 'O' || l == 'U' ||
                            l == 'á' || l == 'é' || l == 'í' || l == 'ó' || l == 'ú' || l == 'Á' || l == 'É' || l == 'Í' || l == 'Ó' || l == 'Ú') {
                        c++;
                    }
                }
            }
        }
        return c;
    }

    // Ejercicio 2: Verificar si es palíndromo (Demasiado complejo, se puede simplificar)
    // Casos de prueba a realizar:
    // 1. Palabra palíndroma en minúsculas (ej. texto="radar" -> true)
    // 2. Palabra no palíndroma (ej. texto="hola" -> false)
    // 3. Palabra palíndroma con espacios y diferentes casos (ej. texto="Anita lava la tina" -> true)
    // 4. Cadena vacía (ej. texto="" -> true)
    // 5. Cadena nula (ej. texto=null -> false)
    public boolean esPalindromo(String texto) {
        if(texto == null) return false;
        String t = texto.toLowerCase().replace(" ", "");
        String i = "";
        for(int x = t.length() - 1; x >= 0; x--) {
            i = i + t.charAt(x);
        }
        if(t.equals(i)) {
            return true;
        } else {
            return false;
        }
    }
}
