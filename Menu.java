package coldwar;

import javax.swing.JFrame;



public class Menu extends JFrame {


	MenuPrincipal menuprin;

	public Menu() {
		setBounds(0,0,800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuprin = new MenuPrincipal();
		add(menuprin);
		setVisible(true);
	}


}
