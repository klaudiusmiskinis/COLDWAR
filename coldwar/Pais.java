package coldwar;

public class Pais {

	// Atributos

	private String nombre;
	private int vida;
	private int misiles;
	private String tipo;


	// Constructor vacio
	public Pais() {
	}

	// Constructor con parametros
	public Pais(String nombre, int vida, int misiles, String tipo) {
		this.nombre = nombre;
		this.vida = vida;
		this.misiles = misiles;
		this.tipo = tipo;
	}
	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getMisiles() {
		return misiles;
	}

	public void setMisiles(int misiles) {
		this.misiles = misiles;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
