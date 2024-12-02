package Game;
import Game.Personajes.Jugador;
import Game.Personajes.Enemigo;
import java.util.Scanner;

public class Pelear {
          // !Metodo de batalla del juego//
      public static void pelear(Jugador jugador, Enemigo enemigo, Scanner scannerPelea) {
            boolean escapar = false;
        //*Bucle para que acabe al cualquiera de los 2 morir o el jugador escape escapar= verdadero*/
            while (jugador.estaVivo() && enemigo.estaVivo() && !escapar ) {
               //*Estado en cada turno */
            System.out.println("=======================================");
            System.out.println("Vida:");
            System.out.println(jugador.nombre + ": "+jugador.vida_hp+" HP");
            System.out.println("\nVida del " + enemigo.nombre);
            System.out.println(enemigo.nombre + ": "+enemigo.vida_hp+" HP");
            System.out.println("=======================================");
            System.out.println("\n¿Qué quieres hacer?");
            System.out.println("1. Atacar");
            System.out.println("2. Ataque cargado");
            System.out.println("3. Defenderse");
            System.out.println("4. Escapar");
            System.out.print("Elige una opción: ");
            int opcion = scannerPelea.nextInt();
            //*Comandos de acción */
            switch (opcion) {
                //*Atacar */
                  case 1:
                  System.out.println("=======================================");
                  jugador.atacar(enemigo);
                  if (enemigo.estaVivo()) {
                        enemigo.atacar(jugador);
                        }
                  break;

                  //*Ataque cargado */
                  case 2:
                  System.out.println("=======================================");
                  jugador.superAtaque(jugador, enemigo);
                  if (enemigo.estaVivo()) {
                        enemigo.atacar(jugador);
                        }
                  break;
            
                    //*Defenderse */
                  case 3:
                  System.out.println("=======================================");
                  jugador.defenderse(enemigo);
                  break;
                  
                    //*Escapar */
                  case 4:
                  escapar = jugador.escapar();
                  System.out.println("=======================================");
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
                  System.out.println("=======================================");
                  break;
            }
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
}