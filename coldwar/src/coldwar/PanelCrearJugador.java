package coldwar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class PanelCrearJugador extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton botonAtras;
	JButton botonAdelante;
	JButton btnRusia;
	JButton btnlituania;
	JButton btnUsa;
	JButton btnEspanya;
	JButton btnVietnam;
	public PanelCrearJugador() {
		setToolTipText("");
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		botonAtras = new JButton ("Atras");
		botonAtras.setBounds(41, 214, 89, 23);
		botonAtras.addActionListener(this);
		botonAdelante = new JButton ("CREAR JUGADOR");
		botonAdelante.setBounds(299, 66, 214, 42);
		botonAdelante.addActionListener(this);
		setLayout(null);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.addActionListener(new ActionListener()
		
		{
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(PanelCrearJugador.class.getResource("/assets/MAS_boton.png")));
		btnNewButton_1.setBounds(521, 196, 63, 59);
		add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setIcon(new ImageIcon(PanelCrearJugador.class.getResource("/assets/JUGADOR_boton.png")));
		btnNewButton.setBounds(185, 196, 291, 59);
		add(btnNewButton);
		add(botonAtras);
		add(botonAdelante);
		
		botonAdelante.setIcon(new ImageIcon(PanelCrearJugador.class.getResource("/assets/textos/JUGAR_boton.png")));
		

		
		JLabel LabelFondo = new JLabel("- Tipos de paises -");
		LabelFondo.setBackground(Color.BLACK);
		LabelFondo.setIcon(new ImageIcon(PanelCrearJugador.class.getResource("/assets/Fondo_Menu.png")));
		LabelFondo.setBounds(-162,0,965,811);
		add(LabelFondo);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		if (e.getSource() == botonAtras) {
			JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.getContentPane().add(new MenuPrincipal());
			marco.setVisible(true);

		}
	}
}