<h4>UTN Mar del Plata > Tecnicatura Superior en Sistemas Informáticos > Laboratorio V > TP Nº1 </h4>
<h1>Threads en Java</h1>

<h3>Diferencia entre Runnable y Thread</h3>
La diferencia principal entre Runnable y Thread esta en la Herencia Multiple.
Runnable es una interfaz y Thread es una clase, por lo tanto, si creamos una clase que extiende Thread bloqueamos la posibilidad de extender de alguna otra clase.
Además si extendemos Thread heredaremos metodos que tal vez no necesitemos utilizar. Extender una clase significa modificar o mejorar dicha clase, si vamos a hacer ninguna de estas dos cosas entonces no es una buena practica. Si el objetivo de la implementacion de hilos es simplemente reescribir el metodo run(), entonces la mejor opcion siempre será extender Runnable.

<h3>Ciclo de vida de un Thread</h3>

1. Nuevo (New): El thread ha sido creado pero no inicializado, es decir, no se ha ejecutado todavía el método start(). Se producirá un mensaje de error (IllegalThreadStateException) si se intenta ejecutar cualquier método de la clase Thread distinto de start().

2. Ejecutable (Runnable): El thread puede estar ejecutándose, siempre y cuando se le haya asignado un determinado tiempo de CPU. En la práctica puede no estar siendo ejecutado en un instante determinado en beneficio de otro thread.

3. Bloqueado (Blocked o Not Runnable): El thread podría estar ejecutándose, pero hay alguna actividad interna suya que lo impide, como por ejemplo una espera producida por una operación de escritura o lectura de datos por teclado (E/S). Si un thread está en este estado, no se le asigna tiempo de CPU.

4. Esperando (Waiting): Esperando que otro thread ejecute una acction en particular sin tiempo limite.

5. Espera con tiempo (Timed Waiting): Esperando que otro thread ejecute una acction en particular con un periodo de tiempo indicado. 

4. Muerto (Dead): La forma habitual de que un thread muera es finalizando el método run(). También puede llamarse al método stop() de la clase Thread, aunque dicho método es considerado “peligroso” y no se debe utilizar.

<img src="https://www.baeldung.com/wp-content/uploads/2018/02/Life_cycle_of_a_Thread_in_Java.jpg" />


<h3>Descripción de Metodos</h3>

<h5>Thread.Start()</h5>
El metodo Start incicia le ejecucion del hilo. Internamente llama el metodo run() de la interfaz Runnable. Arroja IllegalThreadStateException si el metodo Start() es llamado mas de una vez.

<h5>Thread.Sleep()</h5>
Pausa la ejecucion del Hilo actual por un tiempo determinado entre 999999 milisegundos. El tiempo no puede ser negativo, caso contrario arroja IllegalArgumentException.

<h5>Thread.Yield()</h5>
El metodo yield() basicamente significa que el hilo no esta haciendo nada particularmente importante y esta "dispuesto" a ceder su tiempo en cpu si algun otro hilo o proceso lo solicita, caso contrario continuara su ejecucion.

<h5>Thread.Join()</h5>
Este metodo pone el hilo actual en espera hasta que el hilo en donde es llamado muere. Si el hilo es interrumpido arroja InterruptedException.
