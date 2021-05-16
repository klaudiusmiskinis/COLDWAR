package coldwar;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	MenuPrincipal menuprin;

	public Menu() throws IOException {
		setBounds(0,0,1080,768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/coldwar/assets/iconos/C.png"));
        setIconImage(icon);
        
		menuprin = new MenuPrincipal();
		add(menuprin);
	}
}
