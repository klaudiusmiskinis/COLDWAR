package coldwar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class PanelJuego extends JPanel implements ActionListener{
	//ATRIBUTOS
	int num = 1;
	int contador = 50;
	int turno = 0;
	JTextPane equipos;
	JButton atras, jugar, anadir;
	JComboBox<String> desplegable;
	ArrayList<Paises> paisesCreados = new ArrayList<Paises>();
	ArrayList<String> nombres = new ArrayList<String>();
	Font fuente;

	//CONSTRUCTOR
	public PanelJuego() {
		//METODOS DE LA VENTANA
		setBounds(0,0,1080,768);
		setLayout(null);

		//BOTON JUGAR
		jugar = new JButton();
		jugar.setBounds(911, 626, 57, 48);
		jugar.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/iconos/ADELANTE_boton.png")));
		jugar.setOpaque(false);
		jugar.setContentAreaFilled(false);
		jugar.setBorderPainted(false);
		jugar.setFocusable(false);
		jugar.addActionListener(this);

		//BOTON ATRAS
		atras = new JButton();
		atras.setForeground(Color.WHITE);
		atras.setBounds(114, 626, 51, 48);
		atras.addActionListener(this);
		atras.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/iconos/ATRAS_boton.png")));
		atras.setOpaque(false);
		atras.setContentAreaFilled(false);
		atras.setBorderPainted(false);
		atras.setFocusable(false);

		//COMBOBOX DESPLEGABLE
		desplegable = new JComboBox<String>();
		desplegable.setForeground(Color.WHITE);
		desplegable.setBackground(Color.BLACK);
		desplegable.setBorder(new LineBorder(Color.BLACK));
		desplegable.setFocusable(false);
		desplegable.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
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
		boolean pasar = false;

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
			if (paisesCreados.size() >= 2) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
				marco.remove(this);
				marco.getContentPane().add(new PanelPartida(paisesCreados, turno));
				marco.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "No hay equipos suficientes para empezar", "ERROR",JOptionPane.ERROR_MESSAGE);
			}
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

				pasar = validarNombres(name, nombres);

				if (pasar == true) {
					nombres.add(name); //AÑADIMOS EL NOMBRE AL ARRAYLIST
					pais.setNombre(name); //DAMOS NOMBRE AL OBJETO
					pais.setTipo(desplegable.getSelectedItem().toString()); //DAMOS TIPO AL OBJETO
					paisesCreados.add(pais); //AÑADIMOS EL OBJETO AL ARRAYLIST
					pais.asignacionRecursos(pais.getNombre(),pais.getTipo()); //INICIALIZAMOS SU VIDA Y MISILES

					//CUADRO DE EQUIPO AÑADIDO
					equipos.setText("Jugador " + num + " " + pais.getNombre() + " " + pais.getTipo()+ "\n" );
					equipos.setVisible(true);
					equipos.setEditable(false);
					add(equipos);

					//CONTROL DE CANTIDAD DE EQUIPOS
					num ++;
					contador = contador + 60;
				}
			}
		}
	}

	//METODO PARA VALIDAR NOMBRES
	public boolean validarNombres(String name, ArrayList<String> nombresArray) {
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
		Matcher matcher = pattern.matcher(name);

		//CONTIENE SIMBOLOS
		if(matcher.find() == true) {
			JOptionPane.showMessageDialog(new JFrame(), "El nombre no puede contener símbolos y espacios", "ERROR",JOptionPane.ERROR_MESSAGE);
			System.out.println("Contiene simbolos");
			return false;
		}
		
		//CONTIENE NUMEROS
		if (name.matches(".*\\d.*")) {
			JOptionPane.showMessageDialog(new JFrame(), "El nombre no puede contener números", "ERROR",JOptionPane.ERROR_MESSAGE);
			System.out.println("Contiene numeros");
			return false;
		}
		
		//EL NOMBRE ES DEMASIADO LARGO
		if (name.length() > 18) {
			JOptionPane.showMessageDialog(new JFrame(), "El nombre es demasiado largo", "ERROR",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		//EL NOMBRE ESTA REPETIDO
		for(int i = 0; i < nombresArray.size(); i++) {
			if (name.toLowerCase().equals(nombresArray.get(i).toLowerCase())) {
				JOptionPane.showMessageDialog(new JFrame(), "El nombre ya existe", "ERROR",JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}
}
