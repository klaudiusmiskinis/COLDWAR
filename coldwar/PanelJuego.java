package coldwar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class PanelJuego extends JPanel implements ActionListener{
	//ATRIBUTOS
	int num = 1;
	int contador = 50;
	JTextPane equipos;
	JButton atras, jugar, anadir;
	JComboBox<String> desplegable;
	ArrayList<Paises> paisesCreados = new ArrayList<Paises>();

	//CONSTRUCTOR
	public PanelJuego() {
		//METODOS DE LA VENTANA
		setBounds(0,0,1080,768);
		setLayout(null);

		//BOTON JUGAR
		jugar = new JButton();
		jugar.setBounds(1013, 626, 57, 48);
		jugar.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/iconos/ADELANTE_boton.png")));
		jugar.setOpaque(false);
		jugar.setContentAreaFilled(false);
		jugar.setBorderPainted(false);
		jugar.setFocusable(false);
		jugar.addActionListener(this);

		//BOTON ATRAS
		atras = new JButton();
		atras.setForeground(Color.WHITE);
		atras.setBounds(10, 626, 51, 48);
		atras.addActionListener(this);
		atras.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/iconos/ATRAS_boton.png")));
		atras.setOpaque(false);
		atras.setContentAreaFilled(false);
		atras.setBorderPainted(false);
		atras.setFocusable(false);

		//COMBOBOX DESPLEGABLE
		desplegable = new JComboBox<String>();
		desplegable.setMaximumRowCount(10);
		desplegable.setBounds(51, 92, 172, 34);
		desplegable.addItem("UK");
		desplegable.addItem("Lituania");
		desplegable.addItem("Rusia");
		desplegable.addItem("USA");
		desplegable.addItem("Espa�a");
		desplegable.addItem("Vietnam");
		desplegable.addItem("Alemania");
		desplegable.addItem("Francia");
		desplegable.addItem("Suiza");
		desplegable.addItem("Kazajistan");

		//BOTON AÑADIR
		anadir = new JButton();
		anadir.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/textos/MAS_boton.png")));
		anadir.setBounds(233, 76, 50, 50);
		anadir.setContentAreaFilled(false);
		anadir.setBorderPainted(false);
		anadir.addActionListener(this);

		//FONDO JLABEL
		JLabel fondo = new JLabel();
		fondo.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/textos/FondoNegro_Menu.png")));
		fondo.setBounds(0,0,1080,768);

		//SE AÑADEN LOS ELEMENTOS A LA VENTANA
		add(anadir);
		add(desplegable);
		add(atras);
		add(jugar);
		add(fondo);

	}

	//EVENTOS DE LOS BOTONES
	public void actionPerformed(ActionEvent e) {
		//VARIABLES
		String name = "";

		//ACCION BOTON ATRAS
		if (e.getSource() == atras) {
			JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			try {
				marco.getContentPane().add(new MenuPrincipal());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			marco.setVisible(true);
		}

		//ACCION BOTON JUGAR
		if (e.getSource() == jugar) {
			JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.getContentPane().add(new PanelPartida(paisesCreados));
			marco.setVisible(true);
		}

		//ACCION BOTON AÑADIR
		if (e.getSource() == anadir) {

			if(num < 11) {
				Paises pais = new Paises(); //SE CREA EL OBJETO PAIS
				JTextPane equipos= new JTextPane();
				equipos.setBounds(800,contador, 200, 50);
				equipos.setVisible(false);

				//CONTROL DE ENTRADA DE DATOS
				do {
					Object[] options = {"Nombre del jugador"};
					JFrame parent = new JFrame();
					name = JOptionPane.showInputDialog(parent, options,"Jugador", 1);
				} while(name.equals(""));

				pais.setNombre(name); //DAMOS NOMBRE AL OBJETO
				pais.setTipo(desplegable.getSelectedItem().toString()); //DAMOS TIPO AL OBJETO
				paisesCreados.add(pais); //AÑADIMOS EL OBJETO AL ARRAYLIST
				pais.asignacionRecursos(pais.getNombre(),pais.getTipo()); //INICIALIZAMOS SU VIDA Y MISILES

				//PRINT EN CONSOLA DEL OBJETO
				System.out.println(pais.getVida() + " " + pais.getMisiles());
				for(Paises pais1 : paisesCreados) {
					Paises p = (Paises)pais1;
					System.out.println(p.getNombre());
				}

				//CUADRO DE EQUIPO AÑADIDO
				equipos.setText("Jugador " + num + " " + pais.getNombre() + " " + pais.getTipo()+ "\n" );
				equipos.setVisible(true);
				add(equipos);

				//CONTROL DE CANTIDAD DE EQUIPOS
				num ++;
				contador = contador + 60;
			}
		}
	}
}
