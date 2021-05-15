package coldwar;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;



public class Menu extends JFrame {

	MenuPrincipal menuprin;

	public Menu() throws IOException {
		setBounds(0,0,1080,768);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuprin = new MenuPrincipal();
		add(menuprin);
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
