package coldwar;

import java.io.IOException;

import javax.swing.JFrame;



public class Menu extends JFrame {


	MenuPrincipal menuprin;

	public Menu() throws IOException {
		setBounds(0,0,1080,768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);      *Para quitar la barra superior de Minimizar, Maximizar y Cerrar*
		menuprin = new MenuPrincipal();
		add(menuprin);
		setVisible(true);
	}


}
