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
import java.awt.Font;

public class PanelInformacion extends JPanel implements ActionListener{

	JButton botonAtras;
	public PanelInformacion() {
		setBounds(0,0,1080,768);
		setLayout(null);
		setBackground(Color.BLACK);
		
		//BOTON PARA IR HACIA ATRAS
		botonAtras = new JButton ("");
		botonAtras.setForeground(Color.WHITE);
		botonAtras.setBounds(491, 646, 94, 59);
		botonAtras.addActionListener(this);
		botonAtras.setIcon(new ImageIcon(PanelInformacion.class.getResource("/coldwar/assets/iconos/ATRAs.png")));
		botonAtras.setOpaque(false);
		botonAtras.setContentAreaFilled(false);
		botonAtras.setBorderPainted(false);
		botonAtras.setFocusable(false);
		add(botonAtras);
		
		//FONDO
		JLabel recuadro = new JLabel("");
		recuadro.setIcon(new ImageIcon(PanelReglas.class.getResource("/coldwar/assets/fondos/PanelInfo.png")));
		recuadro.setBounds(0,0,1080,768);
		add(recuadro);
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
	}
}