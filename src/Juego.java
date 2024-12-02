import java.util.Scanner;
import Game.Personajes.Jugador;
import Game.Personajes.Enemigo;
import Game.Pelear;


// ! Clase principal
public class Juego {

    public static void main(String[] args) throws Exception {
        // *Crear Jugador y Enemigo */
        Jugador jugador = new Jugador("Link", "Mago" , 50, 10, 7);
        Enemigo esqueleto = new Enemigo("Esqueleto", "Fantasma", 40, 12, 5);
        Scanner scanner = new Scanner(System.in);
        // *Introducción //
        System.out.println("=======================================");
        System.out.println("\"Escucha bien, valiente viajero…");
        System.out.println();
        System.out.println("\"En tiempos inmemoriales, cuando el reino aún estaba en equilibrio, un artefacto sagrado conocido como el Cristal de la Luz Eterna fue forjado por ");
        System.out.println("las manos de los antiguos sabios");
        System.out.println("Su poder traía paz y prosperidad, y los días eran largos y serenos bajo su brillo inmortal.\"");
        System.out.println();
        System.out.println("\"Pero las sombras se han levantado nuevamente.");
        System.out.println("El cristal fue robado y ahora yace oculto en lo profundo de una mazmorra antigua, donde solo aquellos con verdadero coraje se atreven a adentrarse.\"");
        System.out.println();
        System.out.println("\"Se dice que la mazmorra está llena de trampas y criaturas que custodian el Cristal.\"");
        System.out.println();
        System.out.println("\"Tú, " + jugador.getNombre() + ", portador de la Marca del Coraje, eres nuestro último rayo de esperanza.");
        System.out.println("Toma tu espada y tu escudo, y adéntrate en las profundidades de la mazmorra.");
        System.out.println("Solo con el Cristal de la Luz Eterna podremos restaurar la paz y disipar las sombras de nuestro mundo.\"");
        System.out.println();
        System.out.println("\"Recuerda, joven héroe: cada paso que des pondrá a prueba tu valentía.");
        System.out.println("Pero si logras reunir la fuerza y el coraje necesarios, el poder del Cristal será tuyo, y el reino se salvará.\"");
        System.out.println();
        System.out.println("\"¿Estás listo para entrar en la mazmorra, enfrentarte al guardián y reclamar el Cristal de la Luz Eterna?\"");
        System.out.println();

        // *Comenzar Juego//
        while (true) {
            System.out.println("=======================================");
            System.out.println();
            System.out.println("1.Comenzar la aventura.");
            System.out.println("2.Salir del juego");
            System.out.println("Elige una opción");
            int opcion = scanner.nextInt();
            if (opcion == 2) {
                System.exit(2);
            } else if (opcion == 1) {
                break;
            } else {
                System.out.println("Opción no valida. Inténtalo de nuevo ");
            }
        }
        System.out.println("=======================================");
        System.out.println("A tu alrededor, las sombras se alargan y crujen los huesos de viejas batallas.\n");
        System.out.println("De repente, escuchas un ruido sordo y seco. Frente a ti, entre la penumbra, surge una figura huesuda.");
        System.out.println("¡Es un " + esqueleto.getNombre() + ", un guerrero caído del pasado, que ha regresado para proteger este lugar!\n");
        System.out.println("Su calavera te observa con vacío en los ojos, pero puedes sentir la amenaza de su presencia.\n");
        System.out.println("¡Prepárate para luchar por tu vida " + jugador.getNombre() + "!");
        //*Método de batalla */ 
        Pelear.pelear(jugador, esqueleto, scanner);
        System.out.println("\n¡Has derrotado al enemigo y has recuperado el Cristal de la Luz Eterna!");
        System.out.println("Sostienes el cristal en tus manos y sientes cómo el poder de la luz regresa al reino.");
        System.out.println("¡La paz ha sido restaurada, y serás recordado como un héroe por generaciones!");
        scanner.close();
    }
}
