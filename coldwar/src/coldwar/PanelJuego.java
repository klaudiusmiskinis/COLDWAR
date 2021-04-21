package coldwar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class PanelJuego extends JPanel implements ActionListener{
	
	JButton botonAtras;
	JButton btnanadir;
	public PanelJuego() {
		setBounds(0,0,1080,768);
		setLayout(null);
		
		botonAtras = new JButton ("Atras");
		botonAtras.setBounds(10, 11, 89, 23);
		botonAtras.addActionListener(this);
		add(botonAtras);
		
		btnanadir = new JButton("");
		btnanadir.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/textos/MAS_boton.png")));
		btnanadir.setBounds(182, 308, 50, 50);
		btnanadir.setContentAreaFilled(false);
		btnanadir.setBorderPainted(false);
		botonAtras.addActionListener(this);
		add(btnanadir);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/textos/FondoNegro_Menu.png")));
		lblNewLabel.setBounds(0,0,1080,768);
		add(lblNewLabel);
	}

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
		if (e.getSource() == btnanadir) {
			Pais pais1 = new Pais();
		}
	}
}
