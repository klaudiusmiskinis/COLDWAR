package coldwar;
import java.util.Random;


public class Paises {
	//ATRIBUTOS

	static Random ran=new Random();
	private String nombre;
	private int vida;
	private int misiles;
	private String tipo;
	private int sumaAtaque;
	private int sumaDefensa;
	int contadorJugador=0;
	//CONSTRUCTOR VACIO
	public Paises(){
		this.setVida(0);
		this.setNombre(" ");
		this.setTipo(" ");
		this.setMisiles(0);
		this.setSumaDefensa(0);


	}

	//CONSTRUCTOR CON PARAMETROS
	public Paises(String nombre,int vida,int misiles,String tipo,int sumaAtaque,int sumaDefensa) {

		this.setMisiles(misiles);
		this.setNombre(nombre);
		this.setTipo(tipo);
		this.setVida(vida);
		this.setSumaAtaque(sumaAtaque);
		this.setSumaDefensa(sumaDefensa);



	}
	//	METODOS







	//ASIGNAMOS LA VIDA I LOS MISILES SEGUN EL TIPO DE PAIS


	public void asignacionRecursos(String nombre,String tipo){
		if(tipo.equals("UK")) {
			this.setMisiles(50);
			this.setVida(200);
		}
		if (tipo.equals("Kazajistan")) {
			this.setVida(200);
			this.setMisiles(40);
		}
		if(tipo.equals("Suecia")) {
			this.setVida(300);
			this.setMisiles(35);
		}
		if(tipo.equals("Francia")) {
			this.setVida(250);
			this.setMisiles(60);
		}
		if(tipo.equals("Alemania")){
			this.setVida(400);
			this.setMisiles(10);
		}
		if(tipo.equals("Vietnam")) {
			this.setVida(130);
			this.setMisiles(60);
		}
		if(tipo.equals("Espa�a")) {
			this.setVida(180);
			this.setMisiles(50);
		}
		if(tipo.equals("USA")) {
			this.setVida(180);
			this.setMisiles(70);
		}
		if(tipo.equals("Rusia")) {
			this.setVida(240);
			this.setMisiles(45);
		}
		if(tipo.equals("Lituania")) {
			this.setVida(240);
			this.setMisiles(50);
		}
	}




	public static void variablesDefensa(Paises paisQueAtaca,Paises paisAtacado,int misilesAtaque,int misilesDefensa) {
		int cuentaMisiles=0;
		if(paisAtacado.getTipo().equals("Vietnam")) {
			for(int i =0;i<misilesAtaque;i++){
				int retorna=ran.nextInt(2);
				if(retorna==1) {
					cuentaMisiles++;
				}
			}

			paisAtacado.setSumaAtaque(cuentaMisiles);
		}

		if(paisAtacado.getTipo().equals("Lituania")) {
			for(int i =0;i<misilesAtaque;i++){
				int retorna=ran.nextInt(3);
				if(retorna==1) {
					cuentaMisiles++;
				}
			}
			paisAtacado.setSumaAtaque(misilesAtaque-cuentaMisiles);
			paisQueAtaca.setSumaAtaque(cuentaMisiles);
		}
	}

	//					OBTENEMOS LA SUMA DEL ATAQUE SEGUN LAS VARIABLES DE CADA TIPO DE JUGADOR

	public void variables(Paises paisQueAtaca, Paises paisAtacado,int misilesAtaque,int misilesDefensa) {

		if(paisAtacado.getTipo().equals("Vietnam")||paisAtacado.getTipo().equals("Lituania")) {
			variablesDefensa(paisQueAtaca,paisAtacado,misilesAtaque,misilesDefensa);

		}

		else if(paisQueAtaca.getTipo().equals("UK")) {
			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());



		}

		else if(paisQueAtaca.getTipo().equals("Kazajistan")) {
			if(paisAtacado.getTipo().equals("Lituania")) {
				misilesAtaque=misilesAtaque*2;


			}
			else if(paisAtacado.getTipo().equals("Rusia")) {
				misilesAtaque=misilesAtaque/2;
			}
			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}

		else if(paisQueAtaca.getTipo().equals("Suecia")) {
			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}

		else if(paisQueAtaca.getTipo().equals("Francia")) {
			if(paisQueAtaca.vida<=50) {
				int franciaCaca=ran.nextInt(2);
				if(franciaCaca==1) {
					paisQueAtaca.vida=0;
				}
			}
			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}

		else if(paisQueAtaca.getTipo().equals("Alemania")) {
			paisQueAtaca.misiles=paisQueAtaca.misiles+2;
			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}

		else if(paisQueAtaca.getTipo().equals("Vietnam")) {

			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}

		else if(paisQueAtaca.getTipo().equals("Espa�a")) {
			boolean alertaEsp=false;
			int suerte=ran.nextInt(10);
			if(suerte==1) {
				paisQueAtaca.vida=paisQueAtaca.vida+40;
				alertaEsp=true;
			}
			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}

		else if(paisQueAtaca.getTipo().equals("USA")) {
			if(paisAtacado.getTipo().equals("Rusia")) {
				misilesAtaque=misilesAtaque*2;
			}
			if(paisAtacado.getTipo().equals("Vietnam")) {
				misilesAtaque=misilesAtaque/2;
			}
			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}

		else if(paisQueAtaca.getTipo().equals("Rusia")) {
			if(paisAtacado.getTipo().equals("USA")) {
				misilesAtaque=misilesAtaque*2;
			}
			if(paisAtacado.getTipo().equals("Lituania")) {
				misilesAtaque=misilesAtaque/2;
			}
			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}

		else if(paisQueAtaca.getTipo().equals("Lituania")) {

			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}


	}



	//PRUBA NO VALIDA
	public void rondaPelea(Paises paisOfensiva,Paises paisAtacado,int misilesAtaque) {

		if(paisOfensiva.getTipo().equals("UK")) {
			;
		}
	}

	//REALIZAMOS LA RESTA DE LA VIDA DEL JUGADOR SEGUN EL ATAQUE RECIBIDO I LA DEFENSA APLICADA
	public void actualizarDatos(Paises pais) {

		if((pais.getSumaAtaque()-pais.getSumaDefensa())<=0) {
			System.out.println();
		}


		if((pais.getSumaAtaque()-pais.getSumaDefensa())>0) {
			pais.setVida(pais.getVida()-(pais.getSumaAtaque()-pais.getSumaDefensa()));
		}


		//		pais.setVida((pais.getVida()-sumaAtaque));
	}


	//GETERS Y SETERS
	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public int getMisiles() {
		return misiles;
	}


	public void setMisiles(int misiles) {
		this.misiles = misiles;
	}


	public int getVida() {
		return vida;
	}


	public void setVida(int vida) {
		this.vida = vida;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSumaAtaque() {
		return sumaAtaque;
	}

	public void setSumaAtaque(int sumaAtaque) {
		this.sumaAtaque = sumaAtaque;
	}

	public int getSumaDefensa() {
		return sumaDefensa;
	}

	public void setSumaDefensa(int sumaDefensa) {
		this.sumaAtaque = sumaDefensa;
	}






}