package coldwar;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.io.IOException;
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
	JButton botonAtras;
	JTextPane txtpaises; 
	public PanelInformacion() {
		setBounds(0,0,1080,768);
		setLayout(null);

		botonAtras = new JButton ("");
		botonAtras.setForeground(Color.WHITE);
		botonAtras.setBounds(539, 656, 51, 59);
		botonAtras.addActionListener(this);
		botonAtras.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/iconos/ATRAS_boton.png")));
		botonAtras.setOpaque(false);
		botonAtras.setContentAreaFilled(false);
		botonAtras.setBorderPainted(false);
		botonAtras.setFocusable(false);
		add(botonAtras);
		
		caraKlaus = new JButton("New button");
		caraKlaus.setIcon(new ImageIcon(PanelInformacion.class.getResource("/coldwar/assets/iconos/caraKlaus.jpg")));
		caraKlaus.setBounds(459, 96, 226, 234);
		caraKlaus.setBorderPainted(false);
		caraKlaus.setFocusable(false);
		caraKlaus.addActionListener(this);
		add(caraKlaus);


		caraMiquel = new JButton("New button");
		caraMiquel.setIcon(new ImageIcon(PanelInformacion.class.getResource("/coldwar/assets/iconos/caraMiquel.jpg")));
		caraMiquel.setBounds(753, 96, 217, 234);
		caraMiquel.setBorderPainted(false);
		caraMiquel.setFocusable(false);
		caraMiquel.addActionListener(this);
		add(caraMiquel);

		caraMarc = new JButton("New button");
		caraMarc.setIcon(new ImageIcon(PanelInformacion.class.getResource("/coldwar/assets/iconos/caraMarc.jpg")));
		caraMarc.setBounds(164, 96, 217, 234);
		caraMarc.setBorderPainted(false);
		caraMarc.setFocusable(false);
		caraMarc.addActionListener(this);
		add(caraMarc);

		//Texto
		txtpaises = new JTextPane();
		txtpaises.setBounds(232, 425, 674, 92);
		txtpaises.setForeground(Color.BLACK);
		txtpaises.setOpaque(false);
		txtpaises.setText("");
		add(txtpaises);

		//Fondo texto
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PanelReglas.class.getResource("/coldwar/assets/fondos/PanelCuadro.png")));
		lblNewLabel_1.setBounds(219, 370, 700, 242);
		add(lblNewLabel_1);
		
		// Fondo
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/textos/FondoNegro_Menu.png")));
		lblNewLabel.setBounds(0,0,1080,768);
		add(lblNewLabel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonAtras) {
			JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			try {
				marco.getContentPane().add(new MenuPrincipal());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			marco.setVisible(true);
		}
		if (e.getSource() == caraMarc) {
			txtpaises.setText("Hola soy Marc, co-creador de este juego. Disfrutadlo en compañia.\nPara cualquier consulta marcgavingrau@gmail.com");
		}
		if (e.getSource() == caraMiquel) {
			txtpaises.setText("Hola soy Miquel, Me he encargado de la creacion de este juego. Espero que os guste.\nPara cualquier comentario miquelgatiusfarras@gmail.com");
		}
		if (e.getSource() == caraKlaus) {
			txtpaises.setText("Buenas, soy Klaus. encargado del diseno del videojuego. Pasaoslo bien.\nPuedes contactar conmigo en klaudiusmiskinis@gmail.com");
		}
	}
}