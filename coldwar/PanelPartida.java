package coldwar;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPartida extends JPanel {

	//ATRIBUTOS
	ArrayList<Paises> paisesJugar;

	//CONSTRUCTOR QUE RECIBE ARRAYLIST
	public PanelPartida(ArrayList<Paises> paisesCreados) {
		this.paisesJugar = paisesCreados; //SE GUARDA EL ARRAYLIST DE LA VENTANA DE CREACION DE EQUIPOS
		//METODOS DE LA VENTANA
		setBounds(0,0,1080,768);
		System.out.println("\r \n \r");
		
		//PRINT DEL ARRAYLIST
		for(Paises pais1 : paisesJugar) {
			Paises p = (Paises)pais1;
			System.out.println(p.getNombre() + " " + p.getTipo() + " " + p.getVida() + " " + p.getMisiles());
		}

		//FONDO JLABEL
		JLabel fondo = new JLabel();
		fondo.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/textos/FondoNegro_Menu.png")));
		fondo.setBounds(0,0,1080,768);
		add(fondo);
	}

}
