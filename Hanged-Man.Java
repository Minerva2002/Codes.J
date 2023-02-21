import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ahorcado {
    // Vector de palabras secretas disponibles para jugar
    public static final String[] vPalabrasSecretas
            = {"teclado", "mesa", "deporte", "ordenador", "pantalla", "monitor", "animales", "musica", "mochila", "libro",
                "oficina", "cafe", "estudiar", "programacion", "armario"};

    // Vector de indices de palabra con las que ya hemos jugado para evitar repeticiones
    public static boolean[] vIndices = new boolean[vPalabrasSecretas.length];

    // Maximo de intentos fallidos permitidos en cada partida
    public static final int maxIntentos = 5;

    // Contadores de partida
    public static int victorias = 0, derrotas = 0;

    // Devuelve una palabra aleatoria del vector de palabras secretas con la que aún no se haya jugado
    // Return String palabra
    public static String nuevaPalabra() {
        if ((victorias + derrotas) % vPalabrasSecretas.length == 0) {
            for (int i = 0; i < vPalabrasSecretas.length; i++) {
                vIndices[i] = false;
            }
        }
        int i = 0;
                do {
                    i = new Random().nextInt(vPalabrasSecretas.length);
                } while (vIndices[i] == true);
                vIndices[i] = true;
                return vPalabrasSecretas[i];
    }
    // Lee un caracter por teclado, comprueba que es una letra y la devuelve en minúscula
    // Return un char que contiene una letra minúscula
    // param in un objeto de la clase Scanner para leer la entrada de teclado
    public static char leerLetra(Scanner in) {
        char l = ' ';
        do {
            try {
                System.out.println("INTRODUZCA UNA LETRA: ");
                l = in.nextLine().toLowerCase().charAt(0);
            } catch (InputMismatchException ime) {
                System.out.println("OPCION NO VALIDA.\n");
            }
        } while (!Character.isLetter(l));
        System.out.println();
        return l;
    }

    // Muestra el estado actual del juego sustituyendo las letras ocultas por '_'
    // param palabra con la que estamos jugando
    // param los fallos cometidos
    public static void mostrarEstadoPartida(char[] palabra, char[] fallos) {
        System.out.println("PALABRA: \t");
        for (int i = 0; i < palabra.length; i++) {
            if ((int) palabra[i] == 0) {
                System.out.println("_");
            } else {
                System.out.println(palabra[i] + " ");
            }
        }
        System.out.println("\nFALLOS: \t");
        for (int i = 0; i < fallos.length; i++) {
            if ((int) fallos[i] == 0) {
                System.out.println(fallos[i] + " ");
            }
        }
        System.out.println();
    }
    // La partida devuelve TRUE sie l jugador ha obtenido una victoria, FALSE si ha sido derrotado
    // return TRUE en caso de victoria, FALSE en caso de derrota
    // param in un objeto de la clase Scanner para leer la entrada del teclado
    public static boolean partida(Scanner in) {
        final String palabraSecreta = nuevaPalabra();  // La palabra que hay que adivinar
        char [] vPalabra = new char[palabraSecreta.length()];   // Las palabras que se muestra al jugador
        char[] vLetras = new char[maxIntentos];  // Las letras que ya se han introducido
        int fallos = 0;
        char letra;
        boolean fin = false, letraCorrecta;
        // Bucle de jugadas
        do {
            letraCorrecta = false;
            mostrarEstadoPartida(vPalabra, vLetras);
            System.out.println("INTENTOS RESTANTES: " + (maxIntentos - fallos));
            letra = leerLetra(in);
            for (int i = 0; i < palabraSecreta.length(); i++) {
                // Si la palabra secreta contiene la letra y no ha sido revelada antes, se revela
                // Si no, se asume como un fallo
                if (palabraSecreta.charAt(i) == letra && vPalabra[i] != letra) {
                    vPalabra[i] = letra;   // La hacemos visible
                    letraCorrecta = true;   // Cuenta como acierto
                }
            }
            if (letraCorrecta) {
                // Comprobamos si hemos acabado
                fin = palabraSecreta.equals(String.copyValueOf(vPalabra));
            } else {
                vLetras[fallos] = letra;
                fallos++;
            }
        } while (!fin && fallos < maxIntentos);
        mostrarEstadoPartida(vPalabra, vLetras);
        if (fin) {
            System.out.println("VICTORIA!!");
        } else {
            System.out.println("DERROTA!!");
        }
        System.out.println("LA PALABRA SERCETA ERA: " + palabraSecreta + "\n");
        return fin;
    }

    // Punto de entrada del programa
    // param args argumentos introducidos en la consola al invocar el programa
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("MENU");
            System.out.println("1. JUGAR PARTIDA");
            System.out.println("2. VER ESTADISTICAS");
            System.out.println("0 . SALIR");
            try {
                System.out.println("SELECCIONAR UNA OPCION (1-2) o 0 PARA SALIR: ");
                opcion = input.nextInt();
            } catch (InputMismatchException ime) {
                opcion = 100;
            }
            input.nextLine();
            switch (opcion) {
                case 1:
                    if (partida(input)) {
                        victorias++;
                    } else {
                        derrotas++;
                    }
                    break;
                case 2:
                    System.out.println("VICTORIAS: " + victorias);
                    System.out.println("DERROTAS: " + derrotas + "\n");
                    break;
                case 0:
                    System.out.println("FIN DEL PROGRAMA \n");
                    break;
                default:
                    System.out.println("OPCION NO VALIDA \n");
                    break;
            }
        } while (opcion != 0);
        input.close();
    }
    
}
