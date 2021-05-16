package coldwar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.Font;
import java.awt.Color;

public class PanelReglas1 extends JPanel implements ActionListener{
	
	JButton botonAtras;
	JButton btnRusia;
	JButton btnLituania;
	JButton btnUsa;
	JButton btnEspanya;
	JButton btnVietnam;
	JButton btnAlemania;
	JButton btnFrancia;
	JButton btnSuiza;
	JButton btnKazajistan;
	JButton btnUK;
	JTextPane txtpaises;
	JLabel fondoBandera, recuadroInfo;
		
	public PanelReglas1() {
		setToolTipText("");
		setBorder(null);
		setBackground(Color.BLACK);
		setBounds(0,0,1080,768);
		setLayout(null);
		
		// Texto
		txtpaises = new JTextPane();
		txtpaises.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		txtpaises.setBounds(206, 429, 668, 200);
		txtpaises.setForeground(Color.BLACK);
		txtpaises.setOpaque(false);
		txtpaises.setText("");
		add(txtpaises);

		botonAtras = new JButton ("");
		botonAtras.setForeground(Color.WHITE);
		botonAtras.setBounds(480, 669, 85, 59);
		botonAtras.addActionListener(this);
		botonAtras.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/iconos/ATRAS_boton.png")));
		botonAtras.setOpaque(false);
		botonAtras.setContentAreaFilled(false);
		botonAtras.setBorderPainted(false);
		botonAtras.setFocusable(false);
		add(botonAtras);
	

		// Titulo
		JLabel titulo = new JLabel("");
		titulo.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/textos/TIPOS_PAISES_texto.png")));
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		titulo.setBounds(217, 23, 646, 85);
		add(titulo);

		
		// Primera linia
		btnLituania = new JButton("");
		btnLituania.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/banderas/Lituania140x85.png")));
		btnLituania.setBounds(30, 215, 140, 85);
		btnLituania.setContentAreaFilled(false);
		btnLituania.setBorderPainted(false);
		btnLituania.setFocusable(false);
		btnLituania.addActionListener(this);
		add(btnLituania);
		
		btnRusia = new JButton("");
		btnRusia.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/banderas/Rusia140x85.png")));
		btnRusia.setBounds(250, 215, 140, 85);
		btnRusia.setContentAreaFilled(false);
		btnRusia.setBorderPainted(false);
		btnRusia.setFocusable(false);
		btnRusia.addActionListener(this);
		add(btnRusia);
		
		btnUsa = new JButton("");
		btnUsa.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/banderas/Usa140x8.png")));
		btnUsa.setBounds(470, 215, 140, 85);
		btnUsa.setContentAreaFilled(false);
		btnUsa.setBorderPainted(false);
		btnUsa.setFocusable(false);
		btnUsa.addActionListener(this);
		add(btnUsa);
		
		btnEspanya = new JButton("");
		btnEspanya.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/banderas/Espanya140x85.png")));
		btnEspanya.setBounds(680, 215, 140, 85);
		btnEspanya.setContentAreaFilled(false);
		btnEspanya.setBorderPainted(false);
		btnEspanya.addActionListener(this);
		btnEspanya.setFocusable(false);
		add(btnEspanya);
		
		btnVietnam = new JButton("");
		btnVietnam.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/banderas/Vietnam140x85.png")));
		btnVietnam.setBounds(890, 215, 140, 85);
		btnVietnam.setContentAreaFilled(false);
		btnVietnam.setBorderPainted(false);
		btnVietnam.addActionListener(this);
		btnVietnam.setFocusable(false);
		add(btnVietnam);
		
		// segunda linia
		btnAlemania = new JButton("");
		btnAlemania.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/banderas/Alemania140x85.png")));
		btnAlemania.setBounds(30, 311, 140, 85);
		btnAlemania.setContentAreaFilled(false);
		btnAlemania.setBorderPainted(false);
		btnAlemania.setFocusable(false);
		btnAlemania.addActionListener(this);
		add(btnAlemania);
		
		btnFrancia = new JButton("");
		btnFrancia.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/banderas/Francia140x85.png")));
		btnFrancia.setBounds(250, 311, 140, 85);
		btnFrancia.setContentAreaFilled(false);
		btnFrancia.setBorderPainted(false);
		btnFrancia.setFocusable(false);
		btnFrancia.addActionListener(this);
		add(btnFrancia);
		
		btnUK = new JButton("");
		btnUK.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/banderas/UK140x85.png")));
		btnUK.setBounds(470, 310, 140, 85);
		btnUK.setContentAreaFilled(false);
		btnUK.setBorderPainted(false);
		btnUK.setFocusable(false);
		btnUK.addActionListener(this);
		add(btnUK);
		
		btnSuiza = new JButton("");
		btnSuiza.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/banderas/Suiza140x85.png")));
		btnSuiza.setBounds(680, 311, 140, 85);
		btnSuiza.setContentAreaFilled(false);
		btnSuiza.setBorderPainted(false);
		btnSuiza.setFocusable(false);
		btnSuiza.addActionListener(this);
		add(btnSuiza);
		
		btnKazajistan = new JButton("");
		btnKazajistan.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/banderas/Kazajistan140x85.png")));
		btnKazajistan.setBounds(890, 311, 140, 85);
		btnKazajistan.setContentAreaFilled(false);
		btnKazajistan.setBorderPainted(false);
		btnKazajistan.setFocusable(false);
		btnKazajistan.addActionListener(this);
		add(btnKazajistan);
		
		// Fondo banderas
		fondoBandera = new JLabel("");
		fondoBandera.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/fondos/FondoBanderas1040.png")));
		fondoBandera.setBounds(15, 195, 1040, 221);
		add(fondoBandera);
		
		//Fondo texto
		recuadroInfo = new JLabel("");
		recuadroInfo.setIcon(new ImageIcon(PanelReglas.class.getResource("/coldwar/assets/fondos/PanelCuadro.png")));
		recuadroInfo.setBounds(189, 407, 701, 242);
		recuadroInfo.setVisible(false);
		add(recuadroInfo);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonAtras) {
			JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.getContentPane().add(new PanelReglas());
			marco.setVisible(true);
		}
		if (e.getSource() == btnLituania) {
			recuadroInfo.setVisible(true);
			txtpaises.setText("Lituania:\r\n240 puntos de vida\r\n50 misiles por ronda\r\nLos ataques que pare con los misiles de defensa, hay un 30% de probabilidad que devuelvas los misiles a tus atacantes. ( a cada uno de los misiles de forma independiente)");
		}
		if (e.getSource() == btnRusia) {
			recuadroInfo.setVisible(true);
			txtpaises.setText("Rusia : \r\n240 puntos de vida\r\n45 misiles por ronda\r\nAtaca el dobla a USA\r\nAtaca la mitad a Lituania");
		}
		if (e.getSource() == btnUsa) {
			recuadroInfo.setVisible(true);
			txtpaises.setText("USA :\r\n180 puntos de vida\r\n70 misiles por ronda\r\nAtaca el dobla a Rusia\r\nAtaca la mitad a Vietnam");
		}
		if (e.getSource() == btnEspanya) {
			recuadroInfo.setVisible(true);
			txtpaises.setText("Espa\u00F1a :\r\n180 puntos de vida\r\n50 misiles por ronda\r\nCada ronda tiene un 10% de probabilidad de a\u00F1adir conseguir 40 puntos de vida extra");
		}
		if (e.getSource() == btnVietnam) {
			recuadroInfo.setVisible(true);
			txtpaises.setText("Vietnam :\r\n130 puntos de vida\r\n60 misiles por ronda\r\nProbabilidad de esquivar del 50% (se esquiva cada uno de los misiles de forma independiente, por ejemplo, si le atacan con 50 misiles, puede ser que le impacten 37).");
		}
		if (e.getSource() == btnAlemania) {
			recuadroInfo.setVisible(true);
			txtpaises.setText("Alemania:\r\n400 puntos de vida\r\nEmpieza solo con 10 misiles, va aumentando 2 mas cada ronda que pasa");
		}
		if (e.getSource() == btnFrancia) {
			recuadroInfo.setVisible(true);
			txtpaises.setText("Francia:\r\n250 puntos de vida\r\n60 misiles por ronda\r\nSi sus puntos de vida son reducidos a 50 tiene un 50% de probabilidad de rendirse y quedarse fuera de combate.");
		}
		if (e.getSource() == btnSuiza) {
			recuadroInfo.setVisible(true);
			txtpaises.setText("Suiza:\r\n300 puntos de vida\r\n35 misiles por ronda\r\nlos misiles dedicados a defensa tienen el mismo precio que los de ataque : 1");
		}
		if (e.getSource() == btnKazajistan) {
			recuadroInfo.setVisible(true);
			txtpaises.setText("Kazajistan:\r\n200 puntos de vida\r\n40 misiles por ronda\r\nAtaca el doble a Lituania\r\nAtaca la mitad a Rusia");
		}
		if (e.getSource() == btnUK) {
			recuadroInfo.setVisible(true);
			txtpaises.setText("UK:\r\n200 puntos de vida\r\n50 misiles por ronda");
		}
	}
}
