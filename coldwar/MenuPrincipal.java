package coldwar;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.*;
import javax.swing.*;

public class MenuPrincipal extends JPanel implements ActionListener{

	JButton boton1;
	JButton boton2;
	JButton boton3;
	JButton boton4;
	JButton boton5;

	public MenuPrincipal() throws IOException {
		setBorder(null);
		setBounds(0,0,1080,768);

		boton1= new JButton("");

		boton1.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/coldwar/assets/textos/JUGAR_boton.png")));
		boton1.setOpaque(false);
		boton1.setContentAreaFilled(false);
		boton1.setBounds(334, 198, 412, 50);
		boton1.setFocusable(false);
		boton1.setBorderPainted(false);

		boton2= new JButton("");
		boton2.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/coldwar/assets/textos/REGLAS_boton.png")));
		boton2.setOpaque(false);
		boton2.setContentAreaFilled(false);
		boton2.setBounds(334, 285, 412, 50);
		boton2.setFocusable(false);
		boton2.setBorderPainted(false);

		boton3= new JButton("");
		boton3.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/coldwar/assets/textos/INFORMACI\u00D3N_boton.png")));
		boton3.setOpaque(false);
		boton3.setContentAreaFilled(false);
		boton3.setBounds(334, 369, 412, 50);
		boton3.setFocusable(false);
		boton3.setBorderPainted(false);

		boton4= new JButton("Cargar");
		boton4.setForeground(Color.WHITE);
		boton4.setContentAreaFilled(false);
		boton4.setBounds(446, 512, 214, 50);
		boton4.setFocusable(false);
		boton4.setBorderPainted(false);

		boton5= new JButton("");
		boton5.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/coldwar/assets/textos/SALIR_boton.png")));
		boton5.setOpaque(false);
		boton5.setContentAreaFilled(false);
		boton5.setBounds(334, 451, 412, 50);
		boton5.setFocusable(false);
		boton5.setBorderPainted(false);


		boton1.addActionListener(this);
		boton2.addActionListener(this);
		boton3.addActionListener(this);
		boton4.addActionListener(this);
		boton5.addActionListener(this);
		setLayout(null);
		

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/coldwar/assets/textos/Coldwar_texto.png")));
		lblNewLabel_1.setBounds(277, 24, 525, 117);
		add(lblNewLabel_1);
		
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);
		add(boton5);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/coldwar/assets/fondos/Fondo_Menu.png")));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0,0,1080,768);
		add(lblNewLabel);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boton1) {
			JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.getContentPane().add(new PanelJuego());
			marco.setVisible(true);
		}
		if (e.getSource() == boton2) {
			JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.getContentPane().add(new PanelReglas());
			marco.setVisible(true);
		}

		if (e.getSource() == boton3) {
			System.out.println("Informacion");
		}
		if (e.getSource() == boton4) {
			System.out.println("Cargarpartida");
		}

		if (e.getSource() == boton5) {
			//Se inicializan el PopUp pasandole los botones SI y NO
			Object[] options = {"Sí","No"};
			JOptionPane popUp = new JOptionPane();
			
			int a = JOptionPane.showOptionDialog(null, "               " + "¿Seguro qué quieres salir?", "COLDWAR",            
		            JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			
			if (a == JOptionPane.YES_OPTION) {
				System.out.println("Saliendo");
				System.exit(0);
			} else {
				remove(popUp);
				System.out.println("Volviendo al menú");
			}
		}
	}
}
