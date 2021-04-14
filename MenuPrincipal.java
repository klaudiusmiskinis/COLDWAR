package coldwar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuPrincipal extends JPanel implements ActionListener{

	JButton boton1;
	JButton boton2;
	JButton boton3;
	JButton boton4;
	JButton boton5;
	JButton boton6;

	public MenuPrincipal() {
		setBorder(null);
		setBounds(0,0,800,800);
		boton1= new JButton(" -Jugar-");
		boton1.setForeground(Color.BLACK);
		boton1.setBounds(320, 300, 180, 50);
		boton2= new JButton(" -Reglas-");
		boton2.setBounds(320, 360, 180, 50);
		boton3= new JButton(" -Informacion-");
		boton3.setBounds(320, 420, 180, 50);
		boton4= new JButton(" -Guardado-");
		boton4.setBounds(320, 480, 180, 50);
		boton5= new JButton(" -Salir-");
		boton5.setBounds(685, 717, 75, 30);
		boton6 = new JButton("Autores");
		boton6.setBounds(10, 11, 75, 30);
		
		boton1.addActionListener(this);
		boton2.addActionListener(this);
		boton3.addActionListener(this);
		boton4.addActionListener(this);
		boton5.addActionListener(this);
		boton6.addActionListener(this); 
		setLayout(null);
		

		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);
		add(boton5);
		add(boton6);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0,0,800,800);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DAW1\\eclipse-workspace\\coldwar\\src\\coldwar\\assets\\fondo.jfif"));
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
			System.out.println("Reglas");
		}

		if (e.getSource() == boton3) {
			System.out.println("Informacion");
		}
		if (e.getSource() == boton4) {
			System.out.println("Cargarpartida");
		}

		if (e.getSource() == boton5) {
			System.exit(0);
		}
	}
}
