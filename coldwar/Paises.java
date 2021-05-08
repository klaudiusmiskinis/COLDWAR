package coldwar;
import java.util.ArrayList;
import java.util.Random;


public class Paises {
	//ATRIBUTOS

	static Random ran = new Random();
	private String nombre;
	private int vida;
	private int misiles;
	private String tipo;
	private int sumaAtaque;
	private int sumaDefensa;
	int contadorJugador = 0;
	boolean paisMuerto = false;


	//CONSTRUCTOR VACIO
	public Paises(){
		this.setVida(0);
		this.setNombre(" ");
		this.setTipo(" ");
		this.setMisiles(0);
		this.setSumaDefensa(0);
		this.setSumaAtaque(0);
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

	//METODOS
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
		if(tipo.equals("Espanya")) {
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

	public void variablesDefensa(Paises paisAtacado, int misilesAtaque) {
		int cuentaMisiles = 0;
		if(paisAtacado.getTipo().equals("Vietnam")) {
			for(int i = 0; i < misilesAtaque; i++){
				int retorna = ran.nextInt(2);
				if(retorna == 1) {
					cuentaMisiles++;
				}
			}
			paisAtacado.setSumaAtaque(cuentaMisiles);
		}
		if(paisAtacado.getTipo().equals("Lituania")) {
			for(int i = 0; i < misilesAtaque; i++){
				int retorna = ran.nextInt(3);
				if(retorna == 1) {
					cuentaMisiles++;
				}
			}
			paisAtacado.setSumaAtaque(misilesAtaque - cuentaMisiles);
			this.setSumaAtaque(cuentaMisiles);
		}
	}

	//DEFENSA
	public void sumaDefensa(int a) {
		this.setSumaDefensa(a);
	}

	//OBTENEMOS LA SUMA DEL ATAQUE SEGUN LAS VARIABLES DE CADA TIPO DE JUGADOR
	public void variables(Paises paisAtacado,int misilesAtaque) {
		
		
		
		if(paisAtacado.getTipo().equals("Vietnam")||paisAtacado.getTipo().equals("Lituania")) {
			variablesDefensa(paisAtacado,misilesAtaque);
		}

		else if(this.getTipo().equals("UK")) {
			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}

		else if(this.getTipo().equals("Kazajistan")) {


			if(paisAtacado.getTipo().equals("Lituania")) {
				misilesAtaque=misilesAtaque*2;
			}
			else if(paisAtacado.getTipo().equals("Rusia")) {
				misilesAtaque=misilesAtaque/2;
			}
			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}

		else if(this.getTipo().equals("Suecia")) {
			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}

		else if(this.getTipo().equals("Francia")) {
			if(this.vida<=50) {
				int franciaCaca=ran.nextInt(2);
				if(franciaCaca==1) {
					this.vida=0;
				}
			}
			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}

		else if(this.getTipo().equals("Alemania")) {
			this.misiles=this.misiles+2;
			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}

		else if(this.getTipo().equals("Vietnam")) {

			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}

		else if(this.getTipo().equals("Espanya")) {
			boolean alertaEsp = false;
			int suerte=ran.nextInt(10);
			if(suerte==1) {
				this.vida=this.vida+40;
				alertaEsp=true;
			}
			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}

		else if(this.getTipo().equals("USA")) {
			if(paisAtacado.getTipo().equals("Rusia")) {
				misilesAtaque=misilesAtaque*2;
			}
			if(paisAtacado.getTipo().equals("Vietnam")) {
				misilesAtaque=misilesAtaque/2;
			}

			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}

		else if(this.getTipo().equals("Rusia")) {
			if(paisAtacado.getTipo().equals("USA")) {
				misilesAtaque=misilesAtaque*2;
			}
			if(paisAtacado.getTipo().equals("Lituania")) {
				misilesAtaque=misilesAtaque/2;
			}
			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}
		else if(this.getTipo().equals("Lituania")) {
			paisAtacado.setSumaAtaque(misilesAtaque+paisAtacado.getSumaAtaque());
		}
		if(this.getVida()<0) {
			this.setVida(0);
		}
	}


	//REALIZAMOS LA RESTA DE LA VIDA DEL JUGADOR SEGUN EL ATAQUE RECIBIDO I LA DEFENSA APLICADA
	public void actualizarDatos() {
		if(this.getVida() - (this.getSumaAtaque() + this.getSumaDefensa()) == 0) {
			System.out.println("EL PAIS " + this.getNombre() + " HA MUERTO");
			this.setVida(this.getVida() - (this.getSumaAtaque() + this.getSumaDefensa()));
		}

		else if(this.getSumaAtaque() > this.getSumaDefensa()) {
			if((this.getSumaAtaque() - this.getSumaDefensa()) > 0) {
				this.setVida(this.getVida() - (this.getSumaAtaque() + this.getSumaDefensa()));
				 
			}
		}
		else {
			System.out.println("VIDA - (ATAQUE + DEFENSA) es MAYOR a VIDA");
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
		this.sumaDefensa = sumaDefensa;
	}
}