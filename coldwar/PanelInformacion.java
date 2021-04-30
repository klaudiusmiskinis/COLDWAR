package coldwar;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSlider;

public class PanelInformacion extends JPanel implements ActionListener{
	JButton caraKlaus;
	JButton caraMarc;
	JButton caraMiquel;
	JLabel lblNewLabel_1; 
	JLabel lblNewLabel_2; 
	JLabel lblNewLabel_3; 
	public PanelInformacion() {
		setBounds(0,0,1080,768);
		setLayout(null);


		caraKlaus = new JButton("New button");
		caraKlaus.setIcon(new ImageIcon(PanelInformacion.class.getResource("/coldwar/assets/iconos/caraKlaus.jpg")));
		caraKlaus.setBounds(449, 181, 226, 234);
		caraKlaus.setBorderPainted(false);
		caraKlaus.setFocusable(false);
		caraKlaus.addActionListener(this);
		add(caraKlaus);


		caraMiquel = new JButton("New button");
		caraMiquel.setIcon(new ImageIcon(PanelInformacion.class.getResource("/coldwar/assets/iconos/caraMiquel.jpg")));
		caraMiquel.setBounds(743, 181, 217, 234);
		caraMiquel.setBorderPainted(false);
		caraMiquel.setFocusable(false);
		caraMiquel.addActionListener(this);
		add(caraMiquel);

		caraMarc = new JButton("New button");
		caraMarc.setIcon(new ImageIcon(PanelInformacion.class.getResource("/coldwar/assets/iconos/caraMarc.jpg")));
		caraMarc.setBounds(154, 181, 217, 234);
		caraMarc.setBorderPainted(false);
		caraMarc.setFocusable(false);
		caraMarc.addActionListener(this);
		add(caraMarc);

		lblNewLabel_1 = new JLabel("Hola soy Marc, co-creador de este juego. Disfrutadlo en compañia, para cualquier consulta marcgavingrau@gmail.com");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(154, 448, 706, 92);
		lblNewLabel_1.setVisible(false);
		add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Hola soy Miquel, encargado del diseño del videojuego.Espero que os guste. Para cualquier comentario miquelgatiusfarras@gmail.com");
		
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(165, 448, 905, 92);
		lblNewLabel_2.setVisible(false);
		add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Buenas, soy Klaus. Me he encargado de la creacion de este juego. Puedes contactar conmigo en klaudiusmiskinis@gmail.com");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setBounds(154, 448, 750, 92);
		lblNewLabel_3.setVisible(false);
		add(lblNewLabel_3);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/textos/FondoNegro_Menu.png")));
		lblNewLabel.setBounds(0,-11,1080,768);
		add(lblNewLabel);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == caraMarc) {
			System.out.println("A");
			lblNewLabel_2.setVisible(false);
			lblNewLabel_3.setVisible(false);
			lblNewLabel_1.setVisible(true);
		}

		if (e.getSource() == caraMiquel) {
			System.out.println("B");
			lblNewLabel_2.setVisible(true);
			lblNewLabel_3.setVisible(false);
			lblNewLabel_1.setVisible(false);
		}
		if (e.getSource() == caraKlaus) {
			System.out.println("C");
			lblNewLabel_3.setVisible(true);
			lblNewLabel_1.setVisible(false);
			lblNewLabel_2.setVisible(false);
		}
	}
}