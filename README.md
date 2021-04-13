# COLDWAR 

Bienvenido al repositorio de Marc Gavin, Miquel Gatius y Klaudijus Miskinis

En este proyecto se desarrolla el juego *COLDWAR*.

## REQUISITOS DEL JUEGO

Este proyecto tiene su parte libre y su parte con requerimientos.
La parte libre referencia a la personalización, temática, maneras de trabajar, etc.
La parte con requerimientos son las bases que pide el objetivo del proyecto.

Los requerimientos son:

En **PANTALLA INICIO** tendremos las siguientes opciones:
   - JUGAR
   - REGLAS 
   - INFORMACIÓN
   - RANKING (opcional)
   - CARGAR PARTIDA
   - SALIR
   
 En **JUGAR** tendremos los siguientes requerimientos:
  - Nombre del equipo.
  - Inicializar las vidas (automático).
  - Inicializar el número de misiles por ronda (automático).
  - Tipo del planeta.
  
 En **INFORMACIÓN** tendremos los siguientes requerimientos:
   - Versión
   - Contacto (Email, redes sociales)
   - Autor/es
 
 En **REGLAS** no hay ninguna especificación por lo que tenemos vía libre para diferentes ideas y retoques.
 
 En **RANKING** tendremos los siguientes requerimientos:
 - Nombre de jugador.
 - Puntuación de dicho jugador.
 - Partidas jugadas.
 - Partidas perdidas.
 - Porcentaje de victorias sobre las partidas totales.
 - Misiles para defensa.
 - Misiles para ataque.
 - Enemigos eliminados.

En **CARGAR PARTIDA** tendremos los siguientes requerimientos:
- Opción para elegir la partida.
- Cargar partida seleccionada.

En **SALIR** tendremos la simple opción de cerrar el juego.
  
  ## REQUERIMIENTOS DEL CÓDIGO
  
  Como bien se ha dicho antes, este proyecto debe tener unas bases comunes para poder ser calificado de manera correcta.
  Se nos piden los siguientes requerimientos relacionados con el codigo y la manera de tomar este proyecto. 
  Estos requerimientos son:
  
   **Class Planeta**
   
   *Atributos:*
   - vidas
   - nombre
   - misiles_ronda 
   - tipo
 
*Métodos:* 
   - Constructor que inicialice los atributos.
   - Métodos getter y setter correspondientes a cada uno de los atributos declarados como privados.
   - Combate: Se puede realizar de diferentes formas, una de las opciones es recoger como parámetros el número de misiles con los que el planeta es atacado y el objeto del planeta atacante.

**¡IMPORTANTE!**
El enunciado nos avisa de que estos métodos que se nos piden son los *básicos*.
Se debe implementar como mínimo 10 tipos diferentes de planetas (tenemos 6 ya predefinidos):

## PLANETAS

Explicación de los planetas:

Los planetas serán de distintos tipos.
Cada equipo seleccionará al principio (después de introducir su nombre) un tipo de planeta. 
En función del tipo de planeta seleccionado tendrá una serie de vulnerabilidades y puntos fuertes.

Planeta normal
- 200 puntos de vida
- 50 misiles por ronda

Planeta rojo:
- 200 puntos de vida
- 50 misiles por ronda
- Ataca el doble al verde (x2)
- Ataca la mitad al azul (/2)

Planeta azul:
- 200 puntos de vida
- 50 misiles por ronda
- Ataca el doble al rojo (x2)
- Ataca la mitad al verde (/2)

Planeta verde:
- 200 puntos de vida
- 50 misiles por ronda
- Ataca el doble al azul (x2)
- Ataca la mitad al rojo (/2)


Gigante gaseoso:
- 400 puntos de vida
- Empieza solo con 10 misiles, va aumentando 2 más cada ronda que pasa
- Planeta enano:
- 100 puntos de vida
- Probabilidad de esquivar del 50% (se esquiva cada uno de los misiles de forma
independiente, por ejemplo, si le atacan con 50 misiles, puede ser que le impacten
37).
