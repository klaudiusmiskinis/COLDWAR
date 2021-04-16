package coldwar;

public class Paises {
	
	private String nombre;
	private int vida;
	private int misiles;
	private String tipo;
	

	public Paises(){
		this.setVida(0);
		this.setNombre(" ");
		this.setTipo(" ");
		this.setMisiles(0);
		}
	
	
	public Paises(String nombre,int vida,int misiles,String tipo) {
		
		this.setMisiles(misiles);
		this.setNombre(nombre);
		this.setTipo(tipo);
		this.setVida(vida);
		
		
		
	}


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
	
	
	
	
		
}
