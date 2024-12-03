# Clase Padre

<Es la clase "Personaje" indica los atributos de los personajes, y se crea el constructor. Con los atributos para el método "estaViVo" que hace una comparación de la vida para saber si es menor a 0 o no.>

## SubClase "Jugador"

<Aquí se usa el super para poder usar los métodos y variables.>

<Para lo magos se hará el doble de daños a fantasmas y no muertos>

<Para lo guerreros se hará el doble de daños a quimeras Y animales>

<En los parámetros del método son por valor, ya que usamos como referencia la clase Personaje y la referencia enemigo donde cuando lo usemos serán una copia.>

<Las clases serán "Guerrero" y "Mago">

<El guerrero le hará daño a los "Animales" salvajes y a las "Quimeras">

<El mago le hará daño a los "Esqueletos" y al "Fantasma">

<Métodos>

<En el metodo "atacar" se usa como parámetros los de la clase super, lo que hace que el metodo solo funcione con un objeto de clase padre "Personaje" y la palabra "enemigo" es el objeto al que se aplica el metodo.>

<En el método "defenderse" se usa a la inversa el método atacar pero se divide entre 2 el daño enemigo, para eso creo una variable que sea el daño recudido del enemigo.>

<En el método "escapar" se crea un objeto random para que el escape sea aleatorio, luego creo un booleano que define un 50% de probabilidades para que el booleano sea true. Luego uso un if para retornar el valor del boolean escape>

## SubClase Enemigo

<Hereda los atributos de la clase padre y solo usa el método atacar.

## Clase Juego

<Creo un método para cada pelea, esto ayuda a reutilizarlo en batallas futuras.

<Metodo Pelear
<En este método primero creo el boolean escapar que sera "false" esto para que el método escapar este definido. luego al usar el método escapar sera necesario llamar esta variable.

<Creo un "switch" para que se cree el sistema de pelea atacar, tendrá las opciones: "atacar,defenderse,escapar".

<Dentro del bucle while hace que solo funcione si no hay ningún personaje muerto y si nadie ha escapado.

<Dentro del while está el switch y fuera del switch  se muestra el estado de los 2, esto para cada turno.

<Si el while no se cumple significa que alguno de los2 personajes murió o escapo el jugador.

<Al final si el personaje esta vivo el juego seguirá sino sale del programa con "System.exit"

## Nota

<La clase "Personaje" no es el objeto que se vera afectado por el método sino la clase "Personaje", es de la clase "Personaje" para indicar que solo un objeto de clase "Personaje" se aplicara el método y enemigo es el objeto al que se le aplicara.

<Métodos de "Jugador", no se podrán usar en la clase padre ya que estos son sus subclases, pero los métodos de la clase padre se podrán usar en esta subclase.>

<Creo los objetos como "Scanner" o "Random" dentro de las clases para que se usen en los métodos y no se generen cada vez que se llame al método.
