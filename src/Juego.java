import Game.Pelear;
import Game.Personajes.Enemigo;
import Game.Personajes.Jugador;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


// ! Clase principal
public class Juego {

    //temporizador (para que halla un intervalo de tiempo entre cada valor que se muestra en consola)
    public static void Temporizador(String mensaje) throws InterruptedException{
        System.out.println(mensaje);
        Thread.sleep(1500);
    }
    public static void main(String[] args) throws Exception {
        // *Crear Jugador y Enemigo */
        HashMap<String, String> clasesDisponibles = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        Random aleatorio = new Random();
        String claseJugador;
        clasesDisponibles.put("1", "Guerrero"); 
        clasesDisponibles.put("2", "Mago");

        //Todo: Enemigos/
        Enemigo esqueleto = new Enemigo("Esqueleto", "Fantasma", 40, 12, 5);

        // Todo: Jugador/
        //*Nombre y clase del jugador */
        Temporizador("¡Bienvenido, valiente aventurero!");
        Thread.sleep(1400); // Pausa para que el jugador lea el mensaje
        Temporizador("Por favor, ingresa tu nombre: ");
        String nombreJugador = scanner.nextLine();

        Temporizador("Ahora elige la clase de tu personaje, hay 2 clases: Guerrero y mago.");
        Thread.sleep(1400); // Pausa para que el jugador lea el mensaje
        Temporizador("-la clase guerrero le hará el doble de daño a los animales salvajes y a las quimeras");
        Temporizador("-la clase mago le hará el doble de daño a los Esqueletos y a los Fantasmas.");
        Thread.sleep(1400); // Pausa para que el jugador lea el mensaje
        while (true) {
        Temporizador("Elige tu clase:");
        Temporizador("1. Bárbaro");
        Temporizador("2. Mago");
        claseJugador = scanner.nextLine();
        if (claseJugador.equals("1")  || claseJugador.equals("2")){
            break;
        }else {
            Temporizador("Opción no valida. Por favor ingresa 1 o 2.");
            }
        }
        claseJugador = clasesDisponibles.get(claseJugador);

        Jugador jugador = new Jugador(nombreJugador, claseJugador , 50, 10, 7);
        // *Introducción //
        Temporizador("=======================================");
        Temporizador("\"Escucha bien, valiente viajero…");
        System.out.println();
        Thread.sleep(1400); // Pausa para que el jugador lea el mensaje
        Temporizador("\"En tiempos inmemoriales, cuando el reino aún estaba en equilibrio, un artefacto sagrado conocido como el Cristal de la Luz Eterna fue forjado por ");
        Temporizador("las manos de los antiguos sabios");
        Thread.sleep(1400); // Pausa para que el jugador lea el mensaje
        Temporizador("Su poder traía paz y prosperidad, y los días eran largos y serenos bajo su brillo inmortal.\"");
        System.out.println();
        Temporizador("\"Pero las sombras se han levantado nuevamente.");
        Temporizador("El cristal fue robado y ahora yace oculto en lo profundo de una mazmorra antigua, donde solo aquellos con verdadero coraje se atreven a adentrarse.\"");
        Thread.sleep(1400); // Pausa para que el jugador lea el mensaje
        System.out.println();
        Temporizador("\"Se dice que la mazmorra está llena de trampas y criaturas que custodian el Cristal.\"");
        System.out.println();
        Temporizador("\"Tú, portador de la Marca del Coraje, eres nuestro último rayo de esperanza.");
        Thread.sleep(1400); // Pausa para que el jugador lea el mensaje
        Temporizador("Toma tu espada y tu escudo, y adéntrate en las profundidades de la mazmorra.");
        Temporizador("Solo con el Cristal de la Luz Eterna podremos restaurar la paz y disipar las sombras de nuestro mundo.\"");
        Thread.sleep(1400); // Pausa para que el jugador lea el mensaje
        System.out.println();
        Temporizador("\"Recuerda, joven héroe: cada paso que des pondrá a prueba tu valentía.");
        Temporizador("Pero si logras reunir la fuerza y el coraje necesarios, el poder del Cristal será tuyo, y el reino se salvará.\"");
        Thread.sleep(1400); // Pausa para que el jugador lea el mensaje
        System.out.println();
        Temporizador("\"¿Estás listo para entrar en la mazmorra, enfrentarte al guardián y reclamar el Cristal de la Luz Eterna?\"");
        System.out.println();
        Thread.sleep(1400); // Pausa para que el jugador lea el mensaje

        // *Comenzar Juego//
        while (true) {
            Temporizador("=======================================");
            System.out.println();
            Temporizador("1.Comenzar la aventura.");
            Temporizador("2.Salir del juego");
            Temporizador("Elige una opción");
            int opcion = scanner.nextInt();
            if (opcion == 2) {
                System.exit(2);
            } else if (opcion == 1) {
                break;
            } else {
                Temporizador("Opción no valida. Inténtalo de nuevo ");
            }
        }
        Temporizador("=======================================");
        Temporizador("A tu alrededor, las sombras se alargan y crujen los huesos de viejas batallas.\n");
        Thread.sleep(1400); // Pausa para que el jugador lea el mensaje
        Temporizador("De repente, escuchas un ruido sordo y seco. Frente a ti, entre la penumbra, surge una figura huesuda.");
        Thread.sleep(1400); // Pausa para que el jugador lea el mensaje
        Temporizador("¡Es un " + esqueleto.getNombre() + ", un guerrero caído del pasado, que ha regresado para proteger este lugar!\n");
        Temporizador("Su calavera te observa con vacío en los ojos, pero puedes sentir la amenaza de su presencia.\n");
        Thread.sleep(1400); // Pausa para que el jugador lea el mensaje
        Temporizador("¡Prepárate para luchar por tu vida " + jugador.getNombre() + "!");
        //*Método de batalla */ 
        Pelear.pelear(jugador, esqueleto, scanner, aleatorio);
        //! Mensaje final //
        Temporizador("\n¡Has derrotado al enemigo y has recuperado el Cristal de la Luz Eterna!");
        Temporizador("Sostienes el cristal en tus manos y sientes cómo el poder de la luz regresa al reino.");
        Temporizador("¡La paz ha sido restaurada, y serás recordado como un héroe por generaciones!");
        scanner.close();
    }
}
