package coldwar;
import java.util.Random;


public class Paises {
	//ATRIBUTOS

	Random ran=new Random();
	private String nombre;
	private int vida;
	private int misiles;
	private String tipo;
	private int sumaAtaque;
	private int sumaDefensa;

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
	public void asignacionRecursos(Paises pais,String nombre,String tipo){

		if(tipo.equals("UK")) {
			pais.setMisiles(50);
			pais.setVida(200);
		}

		if (tipo.equals("Kazajistan")) {
			pais.setVida(200);
			pais.setMisiles(40);

		}
		if(tipo.equals("Suecia")) {
			pais.setVida(300);
			pais.setMisiles(35);
		}
		if(tipo.equals("Francia")) {
			pais.setVida(250);
			pais.setMisiles(60);
		}
		if(tipo.equals("Alemania")){
			pais.setVida(400);
			pais.setMisiles(10);
		}
		if(tipo.equals("Vietnam")) {
			pais.setVida(130);
			pais.setMisiles(60);
		}
		if(tipo.equals("Espa�a")) {
			pais.setVida(180);
			pais.setMisiles(50);
		}
		if(tipo.equals("USA")) {
			pais.setVida(180);
			pais.setMisiles(70);
		}
		if(tipo.equals("Rusia")) {
			pais.setVida(240);
			pais.setMisiles(45);
		}
		if(tipo.equals("Lituania")) {
			pais.setVida(240);
			pais.setMisiles(50);
		}



	}

//					OBTENEMOS LA SUMA DEL ATAQUE SEGUN LAS VARIABLES DE CADA TIPO DE JUGADOR

	public void variables(Paises paisQueAtaca, Paises paisAtacado,int misilesAtaque,int misilesDefensa) {

		if(paisQueAtaca.getTipo().equals("UK")) {
			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());

		}

		if(paisQueAtaca.getTipo().equals("Kazajistan")) {
			if(paisAtacado.getTipo().equals("Lituania")) {
				misilesAtaque=misilesAtaque*2;
			}
			if(paisAtacado.getTipo().equals("Rusia")) {
				misilesAtaque=misilesAtaque/2;
			}
			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}

		if(paisQueAtaca.getTipo().equals("Suecia")) {
			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}

		if(paisQueAtaca.getTipo().equals("Francia")) {
			if(paisQueAtaca.vida<=50) {
				int franciaCaca=ran.nextInt(2);
				if(franciaCaca==1) {
					paisQueAtaca.vida=0;
				}
			}
			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}

		if(paisQueAtaca.getTipo().equals("Alemania")) {
			paisQueAtaca.misiles=paisQueAtaca.misiles+2;
			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}

		if(paisQueAtaca.getTipo().equals("Vietnam")) {

			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}

		if(paisQueAtaca.getTipo().equals("Espa�a")) {
			int suerte=ran.nextInt(10);
			if(suerte==1) {
				paisQueAtaca.vida=paisQueAtaca.vida+40;
			}
			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}

		if(paisQueAtaca.getTipo().equals("USA")) {
			if(paisAtacado.getTipo().equals("Rusia")) {
				misilesAtaque=misilesAtaque*2;
			}
			if(paisAtacado.getTipo().equals("Vietnam")) {
				misilesAtaque=misilesAtaque/2;
			}
			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}

		if(paisQueAtaca.getTipo().equals("Rusia")) {
			if(paisAtacado.getTipo().equals("USA")) {
				misilesAtaque=misilesAtaque*2;
			}
			if(paisAtacado.getTipo().equals("Lituania")) {
				misilesAtaque=misilesAtaque/2;
			}
			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}

		if(paisQueAtaca.getTipo().equals("Lituania")) {

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

		if((pais.getSumaAtaque()-pais.getSumaDefensa())<0) {

		}


		if((pais.getSumaAtaque()-pais.getSumaDefensa())>0) {
			pais.setVida(pais.getVida()-(pais.getSumaAtaque()-pais.getSumaDefensa()));
		}


		pais.setVida((pais.getVida()-sumaAtaque));
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
