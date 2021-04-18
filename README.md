# COLDWAR 

Bienvenido al repositorio de Marc Gavin, Miquel Gatius y Klaudijus Miskinis

En este proyecto se desarrolla el juego *COLDWAR*.

## HERRAMINETAS UTILIZADAS

**`Eclipse IDE for Java Developers`
`WindowBuilder 1.9.5`
`Photoshop CC 2018`**

¿Por qué utilizamos estas herramientas?

El uso de estas herramientas nos permite tener una organización de trabajo adecuada y todos los colaboradores de este proyecto conocemos Eclipse como la herramienta nativa a la hora de programar en **JAVA**. Cabe añadir que **WindowBuilder**, la herramienta para diseño de GUI, va a conjunto con **Eclipse**. 

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
  Se nos piden los siguientes requerimientos relacionados con el código y la manera de tomar este proyecto. 
  Estos requerimientos son:
  
   **Class Pais**
   
   *Atributos:*
   - vidas
   - nombre
   - misiles_ronda 
   - tipo
 
*Métodos:* 
   - Constructor que inicialice los atributos.
   - Métodos getter y setter correspondientes a cada uno de los atributos declarados como privados.
   - Combate: Se puede realizar de diferentes formas, una de las opciones es recoger como parámetros el número de misiles con los que el pais es atacado y el objeto del país atacante.

**¡IMPORTANTE!**
El enunciado nos avisa de que estos métodos que se nos piden son los *básicos*.
Se debe implementar como mínimo 10 tipos diferentes de paises (tenemos 6 ya predefinidos).

# DISEÑO Y TEMÁTICA

La idea de los diseños es buscar algo minimalista, simple pero llamativo, que se atractivo a la vista y se pueda relacionar fácil la apariencia con la idea del juego.

Los colores que se utilizan en el diseño son los siguientes:
`NARANJA HEX: #fb8200`
`NEGRO HEX: #000000`
`ROJO HEX: #ea0000`

La tipografía utilizada es: 
`LEMONMILK`
`LEMONMILK Bold`
`LEMONMILK Italic`
`LEMONMILK BoldItalic`

Descargar [aqui](https://www.dafont.com/es/lemon-milk.font?text=Coldwar)

Ejemplos de esta temática se muestran en la carpeta `coldwar/assets/background.png`.

## PAISES

1. **Lituania** 
- 240 puntos de vida
- 50 misiles por ronda
- Los ataques que pare con los misiles de defensa, hay un 30% de probabilidad que devuelvas los misiles a tus atacantes.
( a cada uno de los misiles de forma independiente)
2. **Rusia** 
- 240 puntos de vida
- 45 misiles por ronda
- Ataca el dobla a USA
- Ataca la mitad a Lituania
3. **USA**
- 180 puntos de vida
- 70 misiles por ronda
- Ataca el dobla a Rusia
- Ataca la mitad a Vietnam
4. **España**
- 180 puntos de vida
- 50 misiles por ronda
- Cada ronda tiene un 10% de probabilidad de añadir conseguir 40 puntos de vida extra
5. **Vietnam** (Planeta enano)
- 130 puntos de vida
- 60 misiles por ronda
- Probabilidad de esquivar del 50% (se esquiva cada uno de los misiles de forma
independiente, por ejemplo, si le atacan con 50 misiles, puede ser que le impacten
37).
6. **Alemania** (gigante gaseoso)
- 400 puntos de vida
- Empieza solo con 10 misiles, va aumentando 2 más cada ronda que pasa
7. **Francia** 
- 250 puntos de vida
- 60 misiles por ronda
- Si sus puntos de vida son reducidos a 50 tiene un 50% de probabilidad de rendirse y quedarse fuera de combate.
8. **Suecia**
- 300 puntos de vida
- 35 misiles por ronda
- Los misiles dedicados a defensa tienen el mismo precio que los de ataque : 1
9. **Kazajistán**
- 200 puntos de vida
- 40 misiles por ronda
- Ataca el doble a Lituania
- Ataca la mitad a Rusia
10. **UK** (planeta normal)
- 200 puntos de vida
- 50 misiles por ronda




