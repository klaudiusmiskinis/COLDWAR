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
	public PanelReglas() {
		setToolTipText("");
		setBorder(null);
		setBounds(0,0,1080,768);
		
		botonAtras = new JButton ("");
		botonAtras.setIcon(new ImageIcon(PanelReglas.class.getResource("/coldwar/assets/iconos/ATRAS_boton.png")));
		botonAtras.setOpaque(false);
		botonAtras.setContentAreaFilled(false);
		botonAtras.setBounds(449, 669, 52, 59);
		botonAtras.addActionListener(this);
		
		botonAdelante = new JButton ("");
		botonAdelante.setIcon(new ImageIcon(PanelReglas.class.getResource("/coldwar/assets/iconos/ADELANTE_boton.png")));
		botonAdelante.setOpaque(false);
		botonAdelante.setContentAreaFilled(false);
		botonAdelante.setBounds(581, 669, 57, 59);
		botonAdelante.addActionListener(this);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PanelReglas.class.getResource("/coldwar/assets/textos/REGLAS_texto.png")));
		lblNewLabel.setBounds(373, 72, 334, 111);
		add(lblNewLabel);
		
		JTextPane txtpnReglas = new JTextPane();
		txtpnReglas.setForeground(Color.BLACK);
		txtpnReglas.setOpaque(false);
		txtpnReglas.setBounds(207, 266, 665, 160);
		txtpnReglas.setText("El juego consiste en, elegir un pais, y por turnos, enfrentarte a otros jugadores hasta que solo quede 1.\r\n\r\nCada jugador tiene una cantidad especifica de vida y un numero especifico de misiles por turno, los misiles se usan para atacar ( que gastan 1 misil por uso) y para defender ( que gastan 2 misiles por uso)\r\n\r\nCada ronda cada jugador seleccionara a quien quiere atacar y con cuantos misiles, y cuantos misiles los dedicara a la defensa.\r\n\r\nAl final de cada ronda se hace un recuento de la vida de cada jugador, los ataques realizados en ese turno y los jugadores aun vivos.\r\n\r\nEn las siguientes paginas se va a mostrar las diferencias entre los distintos paises y sus habilidades particulares\r\n");
		add(txtpnReglas);
		add(botonAtras);
		add(botonAdelante);
		
		JLabel LabelReglas = new JLabel();
		LabelReglas.setIcon(new ImageIcon(PanelReglas.class.getResource("/coldwar/assets/fondos/PanelCuadro.png")));
		LabelReglas.setBounds(106, 107, 532, 101);
		add(LabelReglas);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PanelReglas.class.getResource("/coldwar/assets/fondos/PanelCuadro.png")));
		lblNewLabel_1.setBounds(189, 236, 701, 242);
		add(lblNewLabel_1);
		JLabel LabelFondo = new JLabel();
		LabelFondo.setIcon(new ImageIcon(PanelReglas.class.getResource("/coldwar/assets/textos/FondoNegro_Menu.png")));
		LabelFondo.setBounds(0,0,1080,768);
		add(LabelFondo);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonAtras) {
			JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			try {
				marco.getContentPane().add(new MenuPrincipal());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.print("Error :" +e1);
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
