## Clase "padre"
<Es la clase "Personaje" indica los atributos de los personajes, y se crea el constructor. Con los atributos para el método "estaViVo" que hace una comparación de la vida para saber si es menor a 0 o no.>

## SubClase "Jugador"
<Aquí se usa el super para poder usar los métodos y variables.>
<En los parámetros del método son por valor, ya que usamos como referencia la clase Personaje y la referencia enemigo donde cuando lo usemos serán una copia.>
<Métodos>
<En el metodo "atacar" se usa como parámetros los de la clase super, lo que hace que el metodo solo funcione con un objeto de clase padre "Personaje" y la palabra "enemigo" es el objeto al que se aplica el metodo.>
<En el método "defenderse" se usa a la inversa el metodo atacar pero se divide entre 2 el daño enemigo, para eso creo una variable que sea el daño recudido del enemigo.>
<En el metodo "escapar" se crea un objeto random para que el escape sea aleatorio, luego creo un booleano que define un 50% de probabilidades para que el booleano sea true. Luego uso un if para retornar el valor del boolean escape>

## Nota        
<La clase "Personaje" no es el objeto que se vera afectado por el metodo sino la clase "Personaje", es de la clase "Personaje" para indicar que solo un objeto de clase "Personaje" se aplicara el metodo y enemigo es el objeto al que se le aplicara.

<Métodos de "Jugador", no se podrán usar en la clase padre ya que estos son sus subclases, pero los métodos de la clase padre se podrán usar en esta subclase.>



