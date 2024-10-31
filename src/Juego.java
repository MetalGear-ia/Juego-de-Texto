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
        return vida_hp > 0;
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

    // ? Métodos de Jugador, no se podrán usar en la clase padre ya que estos son sus subclases.
    public void atacar(Personaje enemigo) {
        System.out.println(nombre + " ataca a " + enemigo.nombre + " con " + fuerza);
        enemigo.vida_hp -= this.fuerza;
    }

    public void defenderse(Personaje enemigo) {
        System.out.println(nombre + " se defiende de ataque del " + enemigo.nombre + " con su escudo, ataque reducido a la mitad.");
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

// ! Clase principal
public class Juego {
    // !Metodo de batalla del juego//
    public static void pelear(Jugador jugador, Enemigo enemigo) {
        Scanner scannerPelea = new Scanner(System.in);
        boolean escapar = false;
        //*Bucle para que acabe al cualquiera de los 2 morir o el jugador escape escapar= verdadero*/
        while (jugador.estaVivo() && enemigo.estaVivo() && !escapar ) {
            System.out.println("\n¿Qué quieres hacer?");
            System.out.println("1. Atacar");
            System.out.println("2. Defenderse");
            System.out.println("3. Escapar");
            System.out.print("Elige una opción: ");
            int opcion = scannerPelea.nextInt();
            switch (opcion) {
                //*Atacar */
                case 1:
                    jugador.atacar(enemigo);
                    if (enemigo.estaVivo()) {
                        enemigo.atacar(jugador);
                        }
                    break;
                
                    //*Defenderse */
                    case 2:
                    jugador.defenderse(enemigo);
                    break;
                    
                    //*Escapar */
                    case 3:
                    escapar = jugador.escapar();
                    if (!escapar && enemigo.estaVivo()){
                        enemigo.atacar(jugador);
                    }else if (escapar){
                        System.out.println("\nDecidiste escapar, dejando el Cristal de la Luz Eterna atrás en la mazmorra.");
                        System.out.println("El reino seguirá en la penumbra, pero al menos, vives para pelear otro día.");
                        System.exit(0);
                    }
                    break;

                default:
                System.out.println("Opcion no válida. Inténtelo de nuevo");
                    break;
            }
            //*Estado en cada turno */
            System.out.println("\n Vida restante:");
            System.out.println(jugador.nombre + ": "+jugador.vida_hp+" HP" + "\n");
            System.out.println("Vida del " + enemigo.nombre);
            System.out.println(enemigo.nombre + ": "+enemigo.vida_hp+" HP" + "\n");
        }
        //*Fuera del bucle, determinar resultado de la pelea */
        if(jugador.estaVivo()){
            System.out.println("¡Has derrotado al " + enemigo.nombre + "! ¡Felicidades!");
        }else{
            System.out.println("\nHas sido derrotado en la mazmorra...");
            System.out.println("El Cristal de la Luz Eterna permanece en las sombras, y el reino continúa sumido en la oscuridad.");
            System.out.println("Tal vez, algún día, otro héroe se atreva a intentarlo...");
            System.out.println("¡Fin del juego!");
            System.exit(0);
        }
        scannerPelea.close();
    }

    public static void main(String[] args) throws Exception {
        // *Crear Jugador y Enemigo */
        Jugador jugador = new Jugador("Link", 50, 10, 7);
        Enemigo esqueleto = new Enemigo("Esqueleto", 40, 80, 5);
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
        System.out.println("\"Tú, " + jugador.nombre + ", portador de la Marca del Coraje, eres nuestro último rayo de esperanza.");
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
        System.out.println("A tu alrededor, las sombras se alargan y crujen los huesos de viejas batallas.");
        System.out.println("De repente, escuchas un ruido sordo y seco. Frente a ti, entre la penumbra, surge una figura huesuda.");
        System.out.println("¡Es un " + esqueleto.nombre + ", un guerrero caído del pasado, que ha regresado para proteger este lugar!");
        System.out.println("Su calavera te observa con vacío en los ojos, pero puedes sentir la amenaza de su presencia.");
        System.out.println("¡Prepárate para luchar por tu vida " + jugador.nombre + "!");
        //*Método de batalla */ 
        pelear(jugador, esqueleto);
        System.out.println("\n¡Has derrotado al enemigo y has recuperado el Cristal de la Luz Eterna!");
        System.out.println("Sostienes el cristal en tus manos y sientes cómo el poder de la luz regresa al reino.");
        System.out.println("¡La paz ha sido restaurada, y serás recordado como un héroe por generaciones!");
        scanner.close();
    }
}
