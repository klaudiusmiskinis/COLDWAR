package coldwar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class PanelReglas extends JPanel implements ActionListener{
	
	JButton botonAtras;
	JButton botonAdelante;
	public PanelReglas() {
		setToolTipText("");
		setBorder(null);
		
		botonAtras = new JButton ("Atras");
		botonAtras.setBounds(250, 705, 89, 23);
		botonAtras.addActionListener(this);
		botonAdelante = new JButton ("Adelante");
		botonAdelante.setBounds(450, 705, 89, 23);
		botonAdelante.addActionListener(this);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PanelReglas.class.getResource("/coldwar/assets/textos/REGLAS_texto.png")));
		lblNewLabel.setBounds(250, 72, 334, 111);
		add(lblNewLabel);
		
		JTextPane txtpnReglas = new JTextPane();
		txtpnReglas.setForeground(Color.WHITE);
		txtpnReglas.setOpaque(false);
		txtpnReglas.setBounds(38, 266, 665, 212);
		txtpnReglas.setText("El juego consiste en, elegir un pais, y por turnos, enfrentarte a otros jugadores hasta que solo quede 1.\r\n\r\nCada jugador tiene una cantidad especifica de vida y un numero especifico de misiles por turno, los misiles se usan para atacar ( que gastan 1 misil por uso) y para defender ( que gastan 2 misiles por uso)\r\n\r\nCada ronda cada jugador seleccionara a quien quiere atacar y con cuantos misiles, y cuantos misiles los dedicara a la defensa.\r\n\r\nAl final de cada ronda se hace un recuento de la vida de cada jugador, los ataques realizados en ese turno y los jugadores aun vivos.\r\n\r\nEn las siguientes paginas se va a mostrar las diferencias entre los distintos paises y sus habilidades particulares\r\n");
		add(txtpnReglas);
		add(botonAtras);
		add(botonAdelante);
		
		JLabel LabelReglas = new JLabel();
		LabelReglas.setIcon(new ImageIcon("C:\\Users\\Miquel\\eclipse-workspace\\Coldwar\\src\\coldwar\\assets\\textos\\Reglas.png"));
		LabelReglas.setBounds(106, 107, 532, 101);
		add(LabelReglas);
		JLabel LabelFondo = new JLabel();
		LabelFondo.setIcon(new ImageIcon(PanelReglas.class.getResource("/coldwar/assets/textos/FondoNegro_Menu.png")));
		LabelFondo.setBounds(0,0,800,800);
		add(LabelFondo);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonAtras) {
			JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.getContentPane().add(new MenuPrincipal());
			marco.setVisible(true);
		}
		if (e.getSource() == botonAdelante) {
			JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.getContentPane().add(new PanelReglas1());
			marco.setVisible(true);
		}
	}
}
