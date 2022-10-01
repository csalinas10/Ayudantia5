import java.util.Random;
import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {
        inicio();

    }

    public static String palabrasAdivinar() {
        String[] palabras = {"muñeca", "uva", "fundamentos", "camion", "barcelona", "acer", "pollo", "acariciar", "java", "clavicula"};
        Random rnd = new Random();
        int alea = rnd.nextInt(palabras.length);
        String aleatorio = palabras[alea];
        return palabras[alea];
    }

    public static char[] letrasPalabra(String palabra) {
        int palabraEncontrar = palabra.length();
        char[] palabraSeparada = new char[palabraEncontrar];

        for (char letras = 0; letras < palabraSeparada.length; letras++) {
            palabraSeparada[letras] = '_';
        }
        return palabraSeparada;
    }

    public static void leerLetras(char[] letrasPalabra, String palabra) {
        int vidas = intentos();
        Scanner teclado = new Scanner(System.in);
        boolean finalizar = false;
        System.out.println("--BIENVENIDO AL AHORCADO--");
        System.out.println("Este minijuego consiste en adivinar una palabra al azar, tienes 10 intentos ¡SUERTE!");

        do {
            System.out.println("¡Te quedan "+ vidas + " intentos!");
            System.out.println(letrasPalabra);
            System.out.println("ingrese una letra");
            char ingresar = teclado.next().charAt(0);
            boolean acertada = false;
            for (int letra = 0; letra < palabra.length(); letra++) {
                if (palabra.charAt(letra) == ingresar) {
                    letrasPalabra[letra] = ingresar;
                    acertada = true;
                    System.out.println("¡Correcto!");
                }
            }
            if (!acertada) {
                System.out.println("¡No has acertado! intentalo de nuevo");
                --vidas;
                if (vidas==0){
                    System.out.println("Alcanzaste el limite de intentos ¡Has perdido!");
                    finalizar = true;
                }
            }
            else {
                boolean finalizado = !siAdivina(letrasPalabra);
                if (finalizado) {
                    System.out.println("Has adivinado la palabra, ¡FELICITACIONES!");
                    finalizar = true;
                }
            }
        } while (!finalizar);
        teclado.close();
    }

    public static boolean siAdivina(char[] array) {
        for (char guiones : array) {
            if (guiones == '_')
                return true;
        }
        return false;
    }


    public static void inicio() {
        String palabras = palabrasAdivinar();
        char [] letras = letrasPalabra(palabras);
        leerLetras(letras,palabras);
    }

    public static int intentos() {
        int vidas = 10;
        int acertados = 0;
        return vidas;
    }
}
