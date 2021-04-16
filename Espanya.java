
public class Espanya extends Paises {
	//ATRIBUTOS
	private int probabilidad;
	
	//CONSTRUCTOR VACÍO
	public Espanya () {
		super();
		this.probabilidad = 10;
	}
	
	//CONSTRUCTOR CON PARAMETROS
	public Espanya(String nombre, int vidas, int misiles, String tipo, int probabilidad) {
		super(nombre, vidas, misiles, tipo);
		this.setProbabilidad(10);
	}
	
	//MÉTODOS
	
	//GETTERs
	public int getProbabildiad() {
		return this.getPorbabildiad(),
	}
	
	//SETTERs
	public void setProbabilidad(int probabilidad) {
		this.probabilidad = probabilidad;
	}

}
