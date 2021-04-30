package coldwar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class PanelJuego extends JPanel implements ActionListener{

	int num = 1;
	int contador = 50;
	JButton botonAtras;
	JButton btnanadir;
	JTextPane equipos;
	JComboBox<String> desplegable;
	ArrayList<Paises> paisesCreados = new ArrayList<Paises>();
	public PanelJuego() {
		setBounds(0,0,1080,768);
		setLayout(null);

		botonAtras = new JButton ("");
		botonAtras.setForeground(Color.WHITE);
		botonAtras.setBounds(514, 669, 51, 59);
		botonAtras.addActionListener(this);
		botonAtras.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/iconos/ATRAS_boton.png")));
		botonAtras.setOpaque(false);
		botonAtras.setContentAreaFilled(false);
		botonAtras.setBorderPainted(false);
		botonAtras.setFocusable(false);
		add(botonAtras);

		desplegable = new JComboBox<String>();
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
		desplegable.addItem("Kazajistan");
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
		String name = "";
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
			if(num < 11){
				Paises pais = new Paises();

				JTextPane equipos= new JTextPane();
				equipos.setBounds(800,contador, 200, 50);
				equipos.setVisible(false);

				// crear el pop up

				do {

					Object[] options = {"Nombre del jugador"};
					JFrame parent = new JFrame();
					name = JOptionPane.showInputDialog(parent, options,"Jugador", 1);
					
				}while(name.equals(""));
				// poner el nombre del equipo 
				pais.setNombre(name);
				// poner el tipo de pais
				pais.setTipo(desplegable.getSelectedItem().toString());
				paisesCreados.add(pais);
				pais.asignacionRecursos(pais.getNombre(),pais.getTipo());
				System.out.println(pais.getVida() + " " + pais.getMisiles());
				for(Paises pais1 : paisesCreados) {

					Paises p = (Paises)pais1;
					System.out.println(p.getNombre());
				}
				// Mostrarlo
				equipos.setText("Jugador " + num + " " + pais.getNombre() + " " + pais.getTipo()+ "\n" );
				equipos.setVisible(true);
				add(equipos);
				// añadir numero de equipo
				num ++;
				contador = contador + 60;
			}
		}
	}
}
