package coldwar;

import javax.swing.JFrame;



public class Menu extends JFrame {


	MenuPrincipal menuprin;

	public Menu() {
		setBounds(0,0,1080,768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuprin = new MenuPrincipal();
		add(menuprin);
		setVisible(true);
	}


}
