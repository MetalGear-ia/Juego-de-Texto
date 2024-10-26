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
    //*Constructor */
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
        System.out.println(nombre + " se defiende de ataque del " + enemigo.nombre + ", ataque reducido a la mitad.");
        int dañoReducido = enemigo.fuerza / 2;
        this.vida_hp -= dañoReducido;
    }

    public boolean escapar() {
        Random aleatorio = new Random();
        boolean escape = (aleatorio.nextInt(100)+this.velocidad) < 50;
        if (escape) {
            System.out.println("Has logrado escapar");
        } else {
            System.out.println("no has logrado escapar");
        }
        return escape;
    }
}

// Todo: Subclase "Enemigo" con los atributos de "Personaje"//
class Enemigo extends Personaje{
        //*Constructor */
    public Enemigo (String nombre, int vida_hp,int fuerza, int velocidad){
        super(nombre, vida_hp, fuerza, velocidad);
    }
    public void atacar(Personaje enemigo){
        System.out.println(nombre + " ataca causando  " + fuerza+" de daño.");
        enemigo.vida_hp -= this.fuerza;
    }
}

public class Juego {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        //*Crear Jugador y Enemigo */
        Jugador caballero = new Jugador("Dante", 50, 10,7);
        Enemigo esqueleto = new Enemigo("Vergil", 40, 80, 5);
    }
}
