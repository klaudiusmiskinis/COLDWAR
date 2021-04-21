package coldwar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelReglas2 extends JPanel implements ActionListener{
	
	JButton botonAtras;
	public PanelReglas2() {
		setToolTipText("");
		setBorder(null);
		setBounds(0,0,1080, 768);
		
		botonAtras = new JButton ("");
		botonAtras.setBounds(21, 22, 57, 59);
		botonAtras.addActionListener(this);
		setLayout(null);
		botonAtras.setIcon(new ImageIcon(PanelReglas2.class.getResource("/coldwar/assets/iconos/ATRAS_boton.png")));
		botonAtras.setContentAreaFilled(false);
		botonAtras.setBorderPainted(false);
		add(botonAtras);
		
		JTextPane txtpnAlemania = new JTextPane();
		txtpnAlemania.setBounds(21, 105, 665, 83);
		txtpnAlemania.setText("Alemania:\r\n400 puntos de vida\r\nEmpieza solo con 10 misiles, va aumentando 2 m\u00E1s cada ronda que pasa");
		add(txtpnAlemania);
		
		JTextPane txtpnFrancia = new JTextPane();
		txtpnFrancia.setBounds(21, 215, 665, 83);
		txtpnFrancia.setText("Francia:\r\n250 puntos de vida\r\n60 misiles por ronda\r\nSi sus puntos de vida son reducidos a 50 tiene un 50% de probabilidad de rendirse y quedarse fuera de combate.");
		add(txtpnFrancia);
		
		JTextPane txtpnSuecia = new JTextPane();
		txtpnSuecia.setBounds(21, 325, 665, 83);
		txtpnSuecia.setText("Suecia:\r\n300 puntos de vida\r\n35 misiles por ronda\r\nlos misiles dedicados a defensa tienen el mismo precio que los de ataque : 1");
		add(txtpnSuecia);
		
		JTextPane txtpnKazajistan = new JTextPane();
		txtpnKazajistan.setBounds(21, 435, 665, 83);
		txtpnKazajistan.setText("Kazajistan:\r\n200 puntos de vida\r\n40 misiles por ronda\r\nAtaca el doble a Lituania\r\nAtaca la mitad a Rusia");
		add(txtpnKazajistan);
		
		JTextPane txtpnUK = new JTextPane();
		txtpnUK.setBounds(21, 545, 665, 83);
		txtpnUK.setText("UK:\r\n200 puntos de vida\r\n50 misiles por ronda");
		add(txtpnUK);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 11, 1080, 768);
		lblNewLabel.setIcon(new ImageIcon(PanelReglas2.class.getResource("/coldwar/assets/fondos/FondoNegro_Menu.png")));
		add(lblNewLabel);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonAtras) {
			JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.getContentPane().add(new PanelReglas1());
			marco.setVisible(true);

		}
	}
}
