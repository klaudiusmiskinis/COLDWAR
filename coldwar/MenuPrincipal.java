package coldwar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.*;

@SuppressWarnings("serial")
public class MenuPrincipal extends JPanel implements ActionListener{

	//ATRIBUTOS
	JButton jugar, reglas, informacion, cargar, salir;
	JLabel titulo;

	//CONSTRUCTOR
	public MenuPrincipal() throws IOException {
		//METODOS DE LA VENTANA
		setBounds(0,0,1080,768);
		setLayout(null);
		setBorder(null);

		//BOTON JUGAR
		jugar= new JButton();
		jugar.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/coldwar/assets/iconos/JUGAR_boton.png")));
		jugar.setOpaque(false);
		jugar.setContentAreaFilled(false);
		jugar.setBounds(334, 182, 412, 50);
		jugar.setFocusable(false);
		jugar.setBorderPainted(false);

		//BOTON REGLAS
		reglas= new JButton();
		reglas.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/coldwar/assets/iconos/REGLAS_boton.png")));
		reglas.setOpaque(false);
		reglas.setContentAreaFilled(false);
		reglas.setBounds(334, 252, 412, 50);
		reglas.setFocusable(false);
		reglas.setBorderPainted(false);

		//BOTON INFORMACION
		informacion = new JButton();
		informacion.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/coldwar/assets/iconos/INFO_boton.png")));
		informacion.setOpaque(false);
		informacion.setContentAreaFilled(false);
		informacion.setBounds(334, 392, 412, 50);
		informacion.setFocusable(false);
		informacion.setBorderPainted(false);

		//BOTON CARGAR PARTIDA
		cargar= new JButton();
		cargar.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/coldwar/assets/iconos/CARGAR_boton.png")));
		cargar.setForeground(Color.WHITE);
		cargar.setContentAreaFilled(false);
		cargar.setBounds(334, 322, 414, 50);
		cargar.setFocusable(false);
		cargar.setBorderPainted(false);

		//BOTON SALIR
		salir= new JButton();
		salir.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/coldwar/assets/iconos/SALIR_boton.png")));
		salir.setOpaque(false);
		salir.setContentAreaFilled(false);
		salir.setBounds(334, 462, 412, 50);
		salir.setFocusable(false);
		salir.setBorderPainted(false);

		//SE AÑADEN LOS LISTENERS DE EVENTOS
		jugar.addActionListener(this);
		reglas.addActionListener(this);
		informacion.addActionListener(this);
		cargar.addActionListener(this);
		salir.addActionListener(this);
		
		//FONDO JLABEL
		JLabel fondo = new JLabel();
		fondo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/coldwar/assets/fondos/Fondo_Menu.png")));
		fondo.setBackground(Color.WHITE);
		fondo.setBounds(0,-5,1080,768);

		//SE AÑADEN LOS ELEMENTOS A LA VENTANA
		add(jugar);
		add(reglas);
		add(informacion);
		add(cargar);
		add(salir);

		//TEXTO COLDWAR
		titulo = new JLabel();
		titulo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/coldwar/assets/textos/Coldwar_texto.png")));
		titulo.setBounds(342, 24, 395, 117);
		add(titulo);
		add(fondo);
	}
	
	
	
	@Override
	//EVENTOS DE LOS BOTONES
	public void actionPerformed(ActionEvent e) {
		
		//EVENTO BOTON JUGAR
		if (e.getSource() == jugar) {
			JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.getContentPane().add(new PanelJuego());
			marco.setVisible(true);
		}

		//EVENTO BOTON REGLAS
		if (e.getSource() == reglas) {
			JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.getContentPane().add(new PanelReglas());
			marco.setVisible(true);
		}

		//EVENTO BOTON INFORMACION
		if (e.getSource() == informacion) {
			JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.getContentPane().add(new PanelInformacion());
			marco.setVisible(true);
		}

		//EVENTO BOTON CARGAR
				if (e.getSource() == cargar) {
					JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
					marco.remove(this);
					try {
						marco.getContentPane().add(new CargaPartida());
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						(e1).printStackTrace();
					}
					marco.setVisible(true);
				}

		//EVENTO BOTON SALIR
		if (e.getSource() == salir) {

			//OBJETO ENCARGADO DE DAR NOMBRE A LOS BOTONES
			Object[] options = {"Si","No"};

			//INICIALIZANDO EL PANEL POPUP
			JOptionPane popUp = new JOptionPane();

			//RECOGIDA DE LA ELECCION POR USUARIO
			int a = JOptionPane.showOptionDialog(null, "               " + "¿Seguro que quieres salir?", "COLDWAR",            
					JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

			//CONTROL DE ELECCION DE USUARIO
			if (a == JOptionPane.YES_OPTION) {
				System.exit(0); 
			} else {
				remove(popUp);
			}
		}
	}
}
