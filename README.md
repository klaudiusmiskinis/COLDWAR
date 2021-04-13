# COLDWAR 

Bienvenido al repositorio de Marc Gavin, Miquel Gatius y Klaudijus Miskinis

En este proyecto se desarrolla el juego conocido como COLDWAR.

### REQUISITOS DEL JUEGO

Este proyecto tiene su parte libre y su parte con requerimientos.
La parte libre referencia a la personalización, temática, maneras de trabajar, etc.
La parte con requerimientos son las bases que pide el objetivo del proyecto

Los requerimientos son:

**PANTALLA INICIO**
   - JUGAR
   - REGLAS 
   - INFORMACIÓN
   - ANKING (opcional)
   - CARGAR PARTIDA
   - SALIR
   
 En la pantalla de **JUGAR** tendremos los siguientes requerimientos:
  - Nombre del equipo.
  - Inicializar las vidas (automático).
  - Inicializar el número de misiles por ronda (automático).
  - Tipo del planeta.
  
  
  En la pantalla de **INFORMACIÓN** tendremos los siguientes requerimientos:
   - Versión
   - Contacto (Email, redes sociales)
   - Autor/es
  
  ### REQUISITOS DEL CÓDIGO
  
Class Planeta
Atributos:  
- vidas
- nombre
-	misiles_ronda 
-	tipo

Métodos: 
-	Constructor que inicialice los atributos.
-	Métodos getter y setter correspondientes a cada uno de los atributos declarados como privados.
-	Combate: Se puede realizar de diferentes formas, una de las opciones es recoger como parámetros el número de misiles con los que el planeta es atacado y el objeto del planeta atacante.
