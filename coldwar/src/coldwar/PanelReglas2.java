package coldwar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelReglas2 extends JPanel implements ActionListener{
	
	JButton botonAtras;
	public PanelReglas2() {
		setToolTipText("");
		setBorder(null);
		
		botonAtras = new JButton ("Atras");
		botonAtras.setBounds(250, 705, 89, 23);
		botonAtras.addActionListener(this);
		setLayout(null);
		add(botonAtras);
		
		JTextPane txtpnAlemania = new JTextPane();
		txtpnAlemania.setBounds(21, 105, 665, 83);
		txtpnAlemania.setText("Alemania:\r\n400 puntos de vida\r\nEmpieza solo con 10 misiles, va aumentando 2 m\u00E1s cada ronda que pasa");
		add(txtpnAlemania);
		
		JTextPane txtpnFrancia = new JTextPane();
		txtpnFrancia.setText("Francia:\r\n250 puntos de vida\r\n60 misiles por ronda\r\nSi sus puntos de vida son reducidos a 50 tiene un 50% de probabilidad de rendirse y quedarse fuera de combate.");
		txtpnFrancia.setBounds(21, 215, 665, 83);
		add(txtpnFrancia);
		
		JTextPane txtpnSuecia = new JTextPane();
		txtpnSuecia.setText("Suecia:\r\n300 puntos de vida\r\n35 misiles por ronda\r\nlos misiles dedicados a defensa tienen el mismo precio que los de ataque : 1");
		txtpnSuecia.setBounds(21, 325, 665, 83);
		add(txtpnSuecia);
		
		JTextPane txtpnKazajistan = new JTextPane();
		txtpnKazajistan.setText("Kazajistan:\r\n200 puntos de vida\r\n40 misiles por ronda\r\nAtaca el doble a Lituania\r\nAtaca la mitad a Rusia");
		txtpnKazajistan.setBounds(21, 435, 665, 83);
		add(txtpnKazajistan);
		
		JTextPane txtpnUK = new JTextPane();
		txtpnUK.setText("UK:\r\n200 puntos de vida\r\n50 misiles por ronda");
		txtpnUK.setBounds(21, 545, 665, 83);
		add(txtpnUK);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DAW1\\eclipse-workspace\\coldwar\\src\\coldwar\\assets\\degradado.png"));
		lblNewLabel.setBounds(0,0,800,800);
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
