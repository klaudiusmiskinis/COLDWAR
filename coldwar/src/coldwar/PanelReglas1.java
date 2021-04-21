package coldwar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.Font;

public class PanelReglas1 extends JPanel implements ActionListener{
	
	JButton botonAtras;
	JButton btnRusia;
	JButton btnlituania;
	JButton btnUsa;
	JButton btnEspanya;
	JButton btnVietnam;
	JButton btnAlemania;
	JButton btnFrancia;
	JButton btnSuiza;
	JButton btnKazajistan;
	JButton btnUK;
		
	public PanelReglas1() {
		setToolTipText("");
		setBorder(null);
		setBounds(0,0,1080,768);
		
		botonAtras = new JButton ("Atras");
		botonAtras.setBounds(250, 705, 89, 23);
		botonAtras.addActionListener(this);
		setLayout(null);
		add(botonAtras);
		
		// Titulo
		JLabel LabelTipos = new JLabel("");
		LabelTipos.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/textos/Paises_text.png")));
		LabelTipos.setFont(new Font("Tahoma", Font.PLAIN, 30));
		LabelTipos.setBounds(160, 23, 420, 71);
		add(LabelTipos);
		
		// Primera linia
		btnlituania = new JButton("");
		btnlituania.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/banderas/Lituania140x85.png")));
		btnlituania.setBounds(20, 100, 140, 85);
		btnlituania.setContentAreaFilled(false);
		btnlituania.setBorderPainted(false);
		btnlituania.addActionListener(this);
		add(btnlituania);
		
		btnRusia = new JButton("");
		btnRusia.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/banderas/Rusia140x85.png")));
		btnRusia.setBounds(170, 100, 140, 85);
		btnRusia.setContentAreaFilled(false);
		btnRusia.setBorderPainted(false);
		btnRusia.addActionListener(this);
		add(btnRusia);
		
		btnUsa = new JButton("");
		btnUsa.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/banderas/Usa140x8.png")));
		btnUsa.setBounds(320, 100, 140, 85);
		btnUsa.setContentAreaFilled(false);
		btnUsa.setBorderPainted(false);
		btnUsa.addActionListener(this);
		add(btnUsa);
		
		btnEspanya = new JButton("");
		btnEspanya.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/banderas/Espanya140x85.png")));
		btnEspanya.setBounds(470, 100, 140, 85);
		btnEspanya.setContentAreaFilled(false);
		btnEspanya.setBorderPainted(false);
		btnEspanya.addActionListener(this);
		add(btnEspanya);
		
		btnVietnam = new JButton("");
		btnVietnam.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/banderas/Vietnam140x85.png")));
		btnVietnam.setBounds(620, 100, 140, 85);
		btnVietnam.setContentAreaFilled(false);
		btnVietnam.setBorderPainted(false);
		btnVietnam.addActionListener(this);
		add(btnVietnam);
		// segunda linia
		btnAlemania = new JButton("");
		btnAlemania.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/banderas/Alemania140x85.png")));
		btnAlemania.setBounds(20, 200, 140, 85);
		btnAlemania.setContentAreaFilled(false);
		btnAlemania.setBorderPainted(false);
		btnAlemania.addActionListener(this);
		add(btnAlemania);
		
		btnFrancia = new JButton("");
		btnFrancia.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/banderas/Francia140x85.png")));
		btnFrancia.setBounds(170, 200, 140, 85);
		btnFrancia.setContentAreaFilled(false);
		btnFrancia.setBorderPainted(false);
		btnFrancia.addActionListener(this);
		add(btnFrancia);
		
		btnSuiza = new JButton("");
		btnSuiza.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/banderas/Suiza140x85.png")));
		btnSuiza.setBounds(320, 200, 140, 85);
		btnSuiza.setContentAreaFilled(false);
		btnSuiza.setBorderPainted(false);
		btnSuiza.addActionListener(this);
		add(btnSuiza);
		
		btnKazajistan = new JButton("");
		btnKazajistan.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/banderas/Kazajistan140x85.png")));
		btnKazajistan.setBounds(470, 200, 140, 85);
		btnKazajistan.setContentAreaFilled(false);
		btnKazajistan.setBorderPainted(false);
		btnKazajistan.addActionListener(this);
		add(btnKazajistan);
		
		btnUK = new JButton("");
		btnUK.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/banderas/UK140x85.png")));
		btnUK.setBounds(620, 200, 140, 85);
		btnUK.setContentAreaFilled(false);
		btnUK.setBorderPainted(false);
		btnUK.addActionListener(this);
		add(btnUK);
		// Fondo
		JLabel LabelFondo = new JLabel();
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

		if (e.getSource() == btnlituania) {
			JTextPane txtpnLituania = new JTextPane();
			txtpnLituania.setBounds(20, 410, 740, 200);
			txtpnLituania.setText("Lituania:\r\n240 puntos de vida\r\n50 misiles por ronda\r\nLos ataques que pare con los misiles de defensa, hay un 30% de probabilidad que devuelvas los misiles a tus atacantes. ( a cada uno de los misiles de forma independiente)");
			add(txtpnLituania);
		}
		if (e.getSource() == btnRusia) {
			JTextPane txtRusia = new JTextPane();
			txtRusia.setText("Rusia : \r\n240 puntos de vida\r\n45 misiles por ronda\r\nAtaca el dobla a USA\r\nAtaca la mitad a Lituania");
			txtRusia.setBounds(20, 410, 740, 200);
			add(txtRusia);
		}
		if (e.getSource() == btnUsa) {
			JTextPane txtpnUsa = new JTextPane();
			txtpnUsa.setText("USA :\r\n180 puntos de vida\r\n70 misiles por ronda\r\nAtaca el dobla a Rusia\r\nAtaca la mitad a Vietnam");
			txtpnUsa.setBounds(20, 410, 740, 200);
			add(txtpnUsa);
		}
		if (e.getSource() == btnEspanya) {
			JTextPane txtpnEspanya = new JTextPane();
			txtpnEspanya.setText("Espa\u00F1a :\r\n180 puntos de vida\r\n50 misiles por ronda\r\nCada ronda tiene un 10% de probabilidad de a\u00F1adir conseguir 40 puntos de vida extra");
			txtpnEspanya.setBounds(20,410,740,200);
			add(txtpnEspanya);
		}
		if (e.getSource() == btnVietnam) {
			JTextPane txtpnVietnam = new JTextPane();
			txtpnVietnam.setText("Vietnam :\r\n130 puntos de vida\r\n60 misiles por ronda\r\nProbabilidad de esquivar del 50% (se esquiva cada uno de los misiles de forma independiente, por ejemplo, si le atacan con 50 misiles, puede ser que le impacten 37).");
			txtpnVietnam.setBounds(20, 410,740, 200);
			add(txtpnVietnam);
		}
		if (e.getSource() == btnAlemania) {
			JTextPane txtpnAlemania = new JTextPane();
			txtpnAlemania.setBounds(20, 410,740, 200);
			txtpnAlemania.setText("Alemania:\r\n400 puntos de vida\r\nEmpieza solo con 10 misiles, va aumentando 2 m\u00E1s cada ronda que pasa");
			add(txtpnAlemania);
		}
		if (e.getSource() == btnFrancia) {
			JTextPane txtpnFrancia = new JTextPane();
			txtpnFrancia.setText("Francia:\r\n250 puntos de vida\r\n60 misiles por ronda\r\nSi sus puntos de vida son reducidos a 50 tiene un 50% de probabilidad de rendirse y quedarse fuera de combate.");
			txtpnFrancia.setBounds(20, 410,740, 200);
			add(txtpnFrancia);
		}
		if (e.getSource() == btnSuiza) {
			JTextPane txtpnSuiza = new JTextPane();
			txtpnSuiza.setText("Suiza:\r\n300 puntos de vida\r\n35 misiles por ronda\r\nlos misiles dedicados a defensa tienen el mismo precio que los de ataque : 1");
			txtpnSuiza.setBounds(20, 410,740, 200);
			add(txtpnSuiza);
		}
		if (e.getSource() == btnKazajistan) {
			JTextPane txtpnKazajistan = new JTextPane();
			txtpnKazajistan.setText("Kazajistan:\r\n200 puntos de vida\r\n40 misiles por ronda\r\nAtaca el doble a Lituania\r\nAtaca la mitad a Rusia");
			txtpnKazajistan.setBounds(20, 410,740, 200);
			add(txtpnKazajistan);
		}
		if (e.getSource() == btnUK) {
			JTextPane txtpnUK = new JTextPane();
			txtpnUK.setText("UK:\r\n200 puntos de vida\r\n50 misiles por ronda");
			txtpnUK.setBounds(20,410,740, 200);
			add(txtpnUK);
		}
		
		
	}
}
