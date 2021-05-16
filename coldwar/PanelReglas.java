package coldwar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import java.awt.Font;
import java.awt.Color;

public class PanelReglas extends JPanel implements ActionListener{

	JButton botonAtras;
	JButton botonAdelante;
	JLabel recuadro;

	public PanelReglas() {
		setBorder(null);
		setBounds(0,0,1080,768);
		setBackground(Color.BLACK);
		setLayout(null);
		
		botonAtras = new JButton ();
		botonAtras.setIcon(new ImageIcon(PanelReglas.class.getResource("/coldwar/assets/iconos/ATRAs.png")));
		botonAtras.setOpaque(false);
		botonAtras.setContentAreaFilled(false);
		botonAtras.setBounds(461, 669, 98, 59);
		botonAtras.addActionListener(this);
		botonAtras.setFocusable(false);
		botonAtras.setBorderPainted(false);
		add(botonAtras);

		botonAdelante = new JButton ();
		botonAdelante.setIcon(new ImageIcon(PanelReglas.class.getResource("/coldwar/assets/iconos/ADELANTE.png")));
		botonAdelante.setOpaque(false);
		botonAdelante.setContentAreaFilled(false);
		botonAdelante.setBounds(558, 669, 89, 59);
		botonAdelante.setFocusable(false);
		botonAdelante.setBorderPainted(false);
		botonAdelante.addActionListener(this);
		add(botonAdelante);
		

		JLabel titulo = new JLabel();
		titulo.setIcon(new ImageIcon(PanelReglas.class.getResource("/coldwar/assets/textos/REGLAS.png")));
		titulo.setBounds(342, 72, 395, 111);
		add(titulo);

		JTextPane tReglas = new JTextPane();
		tReglas.setFont(new Font("Calibri", Font.BOLD, 13));
		tReglas.setForeground(Color.BLACK);
		tReglas.setOpaque(false);
		tReglas.setBounds(206, 250, 665, 228);
		tReglas.setText("El juego consiste en, elegir un pais, y por turnos, enfrentarte a otros jugadores hasta que solo quede 1.\r\n\r\nCada jugador tiene una cantidad especifica de vida y un numero especifico de misiles por turno, los misiles se usan para atacar ( que gastan 1 misil por uso) y para defender ( que gastan 2 misiles por uso)\r\n\r\nCada ronda cada jugador seleccionara a quien quiere atacar y con cuantos misiles, y cuantos misiles los dedicara a la defensa.\r\n\r\nAl final de cada ronda se hace un recuento de la vida de cada jugador, los ataques realizados en ese turno y los jugadores aun vivos.\r\n\r\nEn las siguientes paginas se va a mostrar las diferencias entre los distintos paises y sus habilidades particulares\r\n");
		add(tReglas);

		recuadro = new JLabel();
		recuadro.setIcon(new ImageIcon(PanelReglas.class.getResource("/coldwar/assets/fondos/PanelCuadro.png")));
		recuadro.setBounds(189, 236, 701, 242);
		add(recuadro);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonAtras) {
			JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			try {
				marco.getContentPane().add(new MenuPrincipal());
			} catch (IOException er) {
				// TODO Auto-generated catch block
				System.out.print(er);
			}
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

