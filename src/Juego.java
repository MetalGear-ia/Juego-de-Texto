import java.util.Scanner;
import java.util.Random;

//!! Clase base 
class Personaje {
    String nombre;
    int vida_hp;
    int fuerza;
    int velocidad;

    // * Constructor de el objeto personaje */
    public Personaje(String nombre, int vida_hp, int fuerza, int velocidad) {

        this.nombre = nombre;
        this.vida_hp = vida_hp;
        this.fuerza = fuerza;
        this.velocidad = velocidad;
    }

    // *Ahora estos métodos funcionaran dentro del padre y sus subclases*/
    public boolean estaVivo() {
        return vida_hp < 0;
    }
}

// Todo: Subclase "Jugador" con los atributos de "Personaje"//
class Jugador extends Personaje {
    // *Constructor */
    private Random aleatorio = new Random();

    public Jugador(String nombre, int vida_hp, int fuerza, int velocidad) {
        // *La palabra "super" hace que los atributos de la clase principal se hereden a
        // *la subclase "Jugador" */
        super(nombre, vida_hp, fuerza, velocidad);
    }

    // ? Métodos de Jugador, no se podrán usar en la clase padre ya que estos son
    // sus subclases.
    public void atacar(Personaje enemigo) {
        System.out.println(nombre + " ataca a " + enemigo.nombre + " con " + fuerza);
        enemigo.vida_hp -= this.fuerza;
    }

    public void defenderse(Personaje enemigo) {
        System.out.println(nombre + " se defiende de ataque del " + enemigo.nombre + ", ataque reducido a la mitad.");
        int dañoReducido = enemigo.fuerza / 2;
        this.vida_hp -= dañoReducido;
    }

    public boolean escapar() {
        boolean escape = (aleatorio.nextInt(100) + this.velocidad) < 50;
        if (escape) {
            System.out.println("Has logrado escapar");
        } else {
            System.out.println("no has logrado escapar");
        }
        return escape;
    }
}

// Todo: Subclase "Enemigo" con los atributos de "Personaje"//
class Enemigo extends Personaje {
    // *Constructor */
    public Enemigo(String nombre, int vida_hp, int fuerza, int velocidad) {
        super(nombre, vida_hp, fuerza, velocidad);
    }

    public void atacar(Personaje enemigo) {
        System.out.println(nombre + " ataca causando  " + fuerza + " de daño.");
        enemigo.vida_hp -= this.fuerza;
    }
}

// ! Comienzo del código
public class Juego {
    // !Metodo de batalla del juego//
    Scanner opcionPelea = new Scanner(System.in);
    public static void batalla(Personaje jugador, Personaje enemigo) {

    }

    public static void main(String[] args) throws Exception {
        // *Crear Jugador y Enemigo */
        Jugador jugador = new Jugador("Dante", 50, 10, 7);
        Enemigo esqueleto = new Enemigo("Esqueleto", 40, 80, 5);
        Scanner scanner = new Scanner(System.in);
        // *Introducción //
        System.out.println("=======================================");
        System.out.println("¡Bienvenido a La Mazmorras de Eldoria!");
        System.out.println("=======================================");
        System.out.println("En un tiempo olvidado, Eldoria era un reino próspero,");
        System.out.println("lleno de magia y maravillas. Sin embargo, una oscura");
        System.out.println("maldición cayó sobre la tierra, sumiendo todo en sombras.");
        System.out.println();
        System.out.println("Cuentan las leyendas que en el corazón de las Montañas");
        System.out.println("Susurrantes se encuentra una antigua mazmorras,");
        System.out.println("donde un artefacto de poder inimaginable reposa.");
        System.out.println("Aquellos que se atreven a entrar enfrentan peligros inimaginables,");
        System.out.println("pero también la posibilidad de redimir el reino.");
        System.out.println();
        System.out.println("Tú, un aventurero intrépido, has decidido emprender");
        System.out.println("esta peligrosa misión. Con tu espada afilada y tu");
        System.out.println("valentía, te acercas a la entrada oscura de la mazmorras.");
        System.out.println();
        System.out.println("Una brisa helada sale del interior, llevando consigo");
        System.out.println("susurros de almas perdidas. ¿Te atreverás a cruzar el umbral?");
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

        scanner.close();
    }
}
