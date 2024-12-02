package Game;
import java.util.Random;

//!! Clase base 
public class Personajes {
    String nombre;
    String clase;
    int vida_hp;
    int fuerza;
    int velocidad;

    // * Constructor de el objeto personaje */
    public Personajes(String nombre, String clase, int vida_hp, int fuerza, int velocidad) {

        this.nombre = nombre;
        this.clase = clase;
        this.vida_hp = vida_hp;
        this.fuerza = fuerza;
        this.velocidad = velocidad;
    }

    public String getNombre(){
        return nombre;
    }

    // *Ahora estos métodos funcionaran dentro del padre y sus subclases*/
    public boolean estaVivo() {
        return vida_hp > 0;
    }


// Todo: Subclase "Jugador" con los atributos de "Personaje"//
public static class Jugador extends Personajes {
    // *Constructor */
    private Random aleatorio = new Random();

    public Jugador(String nombre, String clase, int vida_hp, int fuerza, int velocidad) {
        // *La palabra "super" hace que los atributos de la clase principal se hereden a
        // *la subclase "Jugador" */
        super(nombre, clase, vida_hp, fuerza, velocidad);
    }

    // ? Métodos de Jugador, no se podrán usar en la clase padre ya que estos son sus subclases.
    public void atacar(Enemigo enemigo) {
        if (clase.equalsIgnoreCase("Guerrero")) {
            System.out.println(nombre + " realiza un golpe poderoso causando " + (fuerza) + " de daño.");
            enemigo.vida_hp -= fuerza;
        } else if (clase.equalsIgnoreCase("Mago")) {
            System.out.println(nombre + " lanza un hechizo causando " + (fuerza) + " de daño mágico.");
            enemigo.vida_hp -= fuerza;
        } else {
            System.out.println(nombre + " realiza un ataque básico causando " + fuerza + " de daño.");
            enemigo.vida_hp -= fuerza;
        }
    }

    public void superAtaque(Enemigo enemigo) {
        if (clase.equalsIgnoreCase("Guerrero")) {
            if (enemigo.clase.equalsIgnoreCase("Quimeras") || enemigo.clase.equalsIgnoreCase("Animal") ) {
                System.out.println(enemigo.nombre + " tiene poca defensa física, "+nombre + " lo golpea " + enemigo.nombre + " causando " + (fuerza * 2) + " de daño.");
            enemigo.vida_hp -= fuerza * 2;    
            } else{
            System.out.println(nombre + " golpea a " + enemigo.nombre + " con todas sus fuerzas causando " + (fuerza * 1.5) + " de daño.");
            enemigo.vida_hp -= fuerza * 1.5;}

        } else if (clase.equalsIgnoreCase("Mago")) {
            if (enemigo.clase.equalsIgnoreCase("No muerto") || enemigo.clase.equalsIgnoreCase("Fantasma") ) {
                System.out.println(enemigo.nombre + " débil a la magia, "+nombre + " lanza un hechizo a " + enemigo.nombre + " causando " + (fuerza * 2) + " de daño.");
            enemigo.vida_hp -= fuerza * 2;    
            } else{
            System.out.println(nombre + " golpea a " + enemigo.nombre + " con todas sus fuerzas causando " + (fuerza * 1.5) + " de daño.");
            enemigo.vida_hp -= fuerza * 1.5;}

        } else {
        System.out.println(nombre + " realiza un ataque cargado a " + enemigo.nombre + " causando " + fuerza + " de daño.");
        }
    }

    public void defenderse(Personajes enemigo) {
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
public static class Enemigo extends Personajes {
    // *Constructor */
    public Enemigo(String nombre, String clase, int vida_hp, int fuerza, int velocidad) {
        super(nombre, clase,  vida_hp, fuerza, velocidad);
    }

    public void atacar(Personajes enemigo) {
        System.out.println(nombre + " ataca causando  " + fuerza + " de daño.");
        enemigo.vida_hp -= this.fuerza;
    }
}
}