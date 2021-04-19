package coldwar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.Font;

public class PanelReglas1 extends JPanel implements ActionListener{
	
	JButton botonAtras;
	JButton botonAdelante;
	JButton btnRusia;
	JButton btnlituania;
	JButton btnUsa;
	JButton btnEspanya;
	JButton btnVietnam;
	public PanelReglas1() {
		setToolTipText("");
		setBorder(null);
		
		botonAtras = new JButton ("Atras");
		botonAtras.setBounds(250, 705, 89, 23);
		botonAtras.addActionListener(this);
		botonAdelante = new JButton ("Adelante");
		botonAdelante.setBounds(450, 705, 89, 23);
		botonAdelante.addActionListener(this);
		setLayout(null);
		add(botonAtras);
		add(botonAdelante);
		
		JTextPane txtpnLituania = new JTextPane();
		txtpnLituania.setBounds(21, 412, 140, 85);
		txtpnLituania.setText("Lituania:\r\n240 puntos de vida\r\n50 misiles por ronda\r\nLos ataques que pare con los misiles de defensa, hay un 30% de probabilidad que devuelvas los misiles a tus atacantes. ( a cada uno de los misiles de forma independiente)");
		add(txtpnLituania);
		
		JTextPane txtpnRusia = new JTextPane();
		txtpnRusia.setText("Rusia : \r\n240 puntos de vida\r\n45 misiles por ronda\r\nAtaca el dobla a USA\r\nAtaca la mitad a Lituania");
		txtpnRusia.setBounds(171, 414, 138, 83);
		add(txtpnRusia);
		
		JTextPane txtpnUsa = new JTextPane();
		txtpnUsa.setText("USA :\r\n180 puntos de vida\r\n70 misiles por ronda\r\nAtaca el dobla a Rusia\r\nAtaca la mitad a Vietnam");
		txtpnUsa.setBounds(317, 414, 138, 83);
		add(txtpnUsa);
		
		JTextPane txtpnEspanya = new JTextPane();
		txtpnEspanya.setText("Espa\u00F1a :\r\n180 puntos de vida\r\n50 misiles por ronda\r\nCada ronda tiene un 10% de probabilidad de a\u00F1adir conseguir 40 puntos de vida extra");
		txtpnEspanya.setBounds(465, 412, 138, 83);
		add(txtpnEspanya);
		
		JTextPane txtpnVietnam = new JTextPane();
		txtpnVietnam.setText("Vietnam :\r\n130 puntos de vida\r\n60 misiles por ronda\r\nProbabilidad de esquivar del 50% (se esquiva cada uno de los misiles de forma independiente, por ejemplo, si le atacan con 50 misiles, puede ser que le impacten 37).");
		txtpnVietnam.setBounds(613, 412, 138, 83);
		add(txtpnVietnam);
		
		JTextPane txtpnAlemania = new JTextPane();
		txtpnAlemania.setBounds(21, 200, 138, 83);
		txtpnAlemania.setText("Alemania:\r\n400 puntos de vida\r\nEmpieza solo con 10 misiles, va aumentando 2 m\u00E1s cada ronda que pasa");
		add(txtpnAlemania);
		
		JTextPane txtpnFrancia = new JTextPane();
		txtpnFrancia.setText("Francia:\r\n250 puntos de vida\r\n60 misiles por ronda\r\nSi sus puntos de vida son reducidos a 50 tiene un 50% de probabilidad de rendirse y quedarse fuera de combate.");
		txtpnFrancia.setBounds(169, 200, 138, 83);
		add(txtpnFrancia);
		
		JTextPane txtpnSuecia = new JTextPane();
		txtpnSuecia.setText("Suecia:\r\n300 puntos de vida\r\n35 misiles por ronda\r\nlos misiles dedicados a defensa tienen el mismo precio que los de ataque : 1");
		txtpnSuecia.setBounds(317, 200, 138, 83);
		add(txtpnSuecia);
		
		JTextPane txtpnKazajistan = new JTextPane();
		txtpnKazajistan.setText("Kazajistan:\r\n200 puntos de vida\r\n40 misiles por ronda\r\nAtaca el doble a Lituania\r\nAtaca la mitad a Rusia");
		txtpnKazajistan.setBounds(465, 200, 138, 83);
		add(txtpnKazajistan);
		
		JTextPane txtpnUK = new JTextPane();
		txtpnUK.setText("UK:\r\n200 puntos de vida\r\n50 misiles por ronda");
		txtpnUK.setBounds(613, 200, 138, 83);
		add(txtpnUK);
		
		JLabel LabelTipos = new JLabel("- Tipos de paises -");
		LabelTipos.setFont(new Font("Tahoma", Font.PLAIN, 30));
		LabelTipos.setBounds(233, 23, 250, 71);
		add(LabelTipos);
		
		btnlituania = new JButton("");
		btnlituania.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/banderas/Lituania140x85.png")));
		btnlituania.setBounds(21, 100, 140, 85);
		btnlituania.setContentAreaFilled(false);
		btnlituania.setBorderPainted(false);
		btnlituania.addActionListener(this);
		add(btnlituania);
		
		btnRusia = new JButton("");
		btnRusia.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/banderas/Rusia140x85.png")));
		btnRusia.setBounds(171, 100, 140, 85);
		btnRusia.setContentAreaFilled(false);
		btnRusia.setBorderPainted(false);
		btnRusia.addActionListener(this);
		add(btnRusia);
		
		btnUsa = new JButton("");
		btnUsa.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/banderas/Usa140x8.png")));
		btnUsa.setBounds(317, 100, 140, 85);
		btnUsa.setContentAreaFilled(false);
		btnUsa.setBorderPainted(false);
		btnUsa.addActionListener(this);
		add(btnUsa);
		
		btnEspanya = new JButton("");
		btnEspanya.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/banderas/Espanya140x85.png")));
		btnEspanya.setBounds(465, 100, 140, 85);
		btnEspanya.setContentAreaFilled(false);
		btnEspanya.setBorderPainted(false);
		btnEspanya.addActionListener(this);
		add(btnEspanya);
		
		btnVietnam = new JButton("");
		btnVietnam.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/banderas/Vietnam140x85.png")));
		btnVietnam.setBounds(613, 100, 140, 85);
		btnVietnam.setContentAreaFilled(false);
		btnVietnam.setBorderPainted(false);
		btnVietnam.addActionListener(this);
		add(btnVietnam);

		
		JLabel LabelFondo = new JLabel("- Tipos de paises -");
		LabelFondo.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/degradado.png")));
		LabelFondo.setBounds(0,0,800,800);
		add(LabelFondo);
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonAtras) {
			JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.getContentPane().add(new PanelReglas());
			marco.setVisible(true);

		}
		if (e.getSource() == botonAdelante) {
			JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.getContentPane().add(new PanelReglas2());
			marco.setVisible(true);
		}
		if (e.getSource() == btnRusia) {
			System.out.println("Patata");
		}
		if (e.getSource() == btnlituania) {
			System.out.println("Patata2");
		}
	}
}
