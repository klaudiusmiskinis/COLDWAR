package coldwar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class PanelJuego extends JPanel implements ActionListener{

	JButton botonAtras;
	JButton btnanadir;
	JTextPane equipos;
	JComboBox<String> desplegable;
	public PanelJuego() {
		setBounds(0,0,1080,768);
		setLayout(null);

		botonAtras = new JButton ("Atras");
		botonAtras.setBounds(10, 11, 89, 23);
		botonAtras.addActionListener(this);
		add(botonAtras);
		
		
		desplegable = new JComboBox();
		desplegable.setMaximumRowCount(10);
		desplegable.setBounds(339, 323, 172, 34);
		desplegable.addItem("UK");
		desplegable.addItem("Lituania");
		desplegable.addItem("Rusia");
		desplegable.addItem("USA");
		desplegable.addItem("España");
		desplegable.addItem("Vietnam");
		desplegable.addItem("Alemania");
		desplegable.addItem("Francia");
		desplegable.addItem("Suiza");
		desplegable.addItem("Kazagistan");
		add(desplegable);


		btnanadir = new JButton("");
		btnanadir.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/textos/MAS_boton.png")));
		btnanadir.setBounds(182, 308, 50, 50);
		btnanadir.setContentAreaFilled(false);
		btnanadir.setBorderPainted(false);
		btnanadir.addActionListener(this);
		add(btnanadir);
		
		// Fondo
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/textos/FondoNegro_Menu.png")));
		lblNewLabel.setBounds(0,0,1080,768);
		add(lblNewLabel);

	}

	public void actionPerformed(ActionEvent e) {
		int num = 1;
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
		} // Preguntar a gavin lo de los objetos sin nombre
		if (e.getSource() == btnanadir) {
			Pais pais1 = new Pais();
			
			
			JTextPane equipos= new JTextPane();
			equipos.setBounds(20, 410, 200, 200);
			equipos.setVisible(false);

			
			// crear el pop up
			JFrame parent = new JFrame();
			String name = JOptionPane.showInputDialog(parent,
					"Introduce nombre del equipo");
			// poner el nombre del equipo 
			pais1.setNombre(name);
			pais1.setTipo(desplegable.getSelectedItem().toString());
			// Mostrarlo
			equipos.setText("Equipo " + num + " " + pais1.getNombre() + " " + pais1.getTipo()+ "\n" );
			// Añadir get text para pooner el tipo de pais en el objeto
			equipos.setVisible(true);
			add(equipos);

			// añadir numero de equipo
			num ++;

		}
	}
}
