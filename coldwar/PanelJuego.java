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
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class PanelJuego extends JPanel implements ActionListener{

	//ATRIBUTOS
	int num = 1;
	int turno = 0;
	int contador = 178;
	JTextPane infoBanderas;
	JButton atras, jugar, anadir;
	JLabel fondo, banderaImagen;
	JComboBox<String> desplegable;
	ArrayList<Paises> paisesCreados = new ArrayList<Paises>();
	ArrayList<String> nombres = new ArrayList<String>();
	ArrayList <String> historial = new ArrayList <String>();
	String story = "";

	//CONSTRUCTOR
	public PanelJuego() {
		//METODOS DE LA VENTANA
		setBounds(0,0,1080,768);
		setLayout(null);

		//BOTON JUGAR
		jugar = new JButton();
		jugar.setBounds(986, 672, 58, 45);
		jugar.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/iconos/ADELANTE.png")));
		jugar.setOpaque(false);
		jugar.setContentAreaFilled(false);
		jugar.setBorderPainted(false);
		jugar.setFocusable(false);
		jugar.addActionListener(this);

		//BOTON ATRAS
		atras = new JButton();
		atras.setForeground(Color.WHITE);
		atras.setBounds(20, 672, 58, 45);
		atras.addActionListener(this);
		atras.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/iconos/ATRAs.png")));
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
		desplegable.setBounds(36, 189, 402, 34);
		desplegable.addItem(""); //SI NO SE AÑADE ESTE ELEMENTO, EL PRIMER EQUIPO NO APARECERA AL CREARSE
		desplegable.addItem("UK");
		desplegable.addItem("Lituania");
		desplegable.addItem("Rusia");
		desplegable.addItem("USA");
		desplegable.addItem("Espanya");
		desplegable.addItem("Vietnam");
		desplegable.addItem("Alemania");
		desplegable.addItem("Francia");
		desplegable.addItem("Suiza");
		desplegable.addItem("Kazajistan");
		desplegable.addActionListener(this);

		//BOTON AÑADIR
		anadir = new JButton();
		anadir.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/iconos/MAS_boton.png")));
		anadir.setBounds(448, 189, 51, 34);
		anadir.setContentAreaFilled(false);
		anadir.setBorderPainted(false);
		anadir.addActionListener(this);

		//JLABEL BANDERAS
		banderaImagen = new JLabel("");
		banderaImagen.setBackground(Color.WHITE);
		banderaImagen.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Espanya140x85.png")));
		banderaImagen.setBounds(36, 558, 140, 85);
		banderaImagen.setVisible(false);


		//TEXTFIELD INFOBANDERAS
		infoBanderas = new JTextPane();
		infoBanderas.setForeground(Color.WHITE);
		infoBanderas.setBackground(Color.BLACK);
		infoBanderas.setBounds(179, 558, 314, 85);
		infoBanderas.setVisible(false); 
		infoBanderas.setFont(new Font("Calibri", Font.PLAIN, 13));
		infoBanderas.setEditable(false);

		//JLABEL INFO
		fondo = new JLabel();
		fondo.setHorizontalAlignment(SwingConstants.CENTER);
		fondo.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/fondos/PanelJugar.png")));
		fondo.setBounds(0,0,1080,768);

		//SE AÑADEN LOS ELEMENTOS A LA VENTANA
		add(anadir);
		add(jugar);	
		add(desplegable);
		add(atras);
		add(banderaImagen);
		add(infoBanderas);
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
				marco.getContentPane().add(new PanelPartida(paisesCreados, turno,story));
				marco.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "No hay equipos suficientes para empezar", "ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}

		//ACCION BOTON AÑADIR
		if (e.getSource() == anadir && !desplegable.getSelectedItem().toString().equals("")) {

			if(num < 11) {
				Paises pais = new Paises();
				//DISPLAY DE EQUIPOS EN PANTALLA
				JTextPane equipos= new JTextPane();
				StyledDocument doc = equipos.getStyledDocument();
			    SimpleAttributeSet centrar = new SimpleAttributeSet();
			    StyleConstants.setAlignment(centrar, StyleConstants.ALIGN_CENTER);
			    doc.setParagraphAttributes(0, doc.getLength(), centrar, false);
				equipos.setBounds(600, contador, 400, 40);
				equipos.setBackground(Color.black);
				equipos.setForeground(Color.red);
				equipos.setBorder(new LineBorder(Color.red));
				equipos.setVisible(false);

				//CONTROL DE ENTRADA DE DATOS
				do {
					Object[] options = {"Nombre del jugador"};
					JFrame parent = new JFrame();
					name = JOptionPane.showInputDialog(parent, options,"Jugador", 1);

				} while(name.equals(""));

				pasar = validarNombres(name, nombres);

				if (pasar == true) {
					//AÑADIENDO NOMBRE A ARRAYLIST Y INICIALIZANDO EL EQUIPO CREADO
					nombres.add(name); 
					pais.setNombre(name); 
					pais.setTipo(desplegable.getSelectedItem().toString());
					paisesCreados.add(pais);
					pais.asignacionRecursos(pais.getTipo());

					//CUADRO DE EQUIPO AÑADIDO
					equipos.setText("Jugador " + num + " " + pais.getNombre() + " " + pais.getTipo()+ "\n" );
					equipos.setVisible(true);
					equipos.setEditable(false);
					add(equipos);

					//CONTROL DE CANTIDAD DE EQUIPOS
					num ++;
					contador = contador + 47;
				}
			}
		}

		switch (desplegable.getSelectedItem().toString()) {
		case "USA": 
			banderaImagen.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Usa140x8.png")));
			banderaImagen.setVisible(true);
			infoBanderas.setText("VIDA: 180     MISILES:70\nBONUS:\n-2X a RUSIA\n-1/2 a Vietnam");
			infoBanderas.setVisible(true);
			break;
		case "UK":
			banderaImagen.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/UK140x85.png")));
			banderaImagen.setVisible(true);
			infoBanderas.setText("VIDA: 200     MISILES:50\n\n\nSIN BONUS");
			infoBanderas.setVisible(true);
			break;
		case "Lituania":
			banderaImagen.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Lituania140x85.png")));
			banderaImagen.setVisible(true);
			infoBanderas.setText("VIDA: 240     MISILES:50\n\nBONUS:\n30% de probabilidad de devolver algunos misiles");
			infoBanderas.setVisible(true);
			break;
		case "Rusia":
			banderaImagen.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Rusia140x85.png")));
			banderaImagen.setVisible(true);
			infoBanderas.setText("VIDA: 240     MISILES:45\nBONUS:\nAtaca x2 a USA\nAtaca la mitad a Lituania");
			infoBanderas.setVisible(true);
			break;
		case "Espanya":
			banderaImagen.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Espanya140x85.png")));
			banderaImagen.setVisible(true);
			infoBanderas.setText("VIDA: 180     MISILES:50\n\nBONUS:\n10% de probabilidad de sumar 40 de vida");
			infoBanderas.setVisible(true);
			break;
		case "Vietnam":
			banderaImagen.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Vietnam140x85.png")));
			banderaImagen.setVisible(true);
			infoBanderas.setText("VIDA: 130     MISILES:60\n\nBONUS:\n50% de probabilidad de esquivar misiles independientes");
			infoBanderas.setVisible(true);
			break;
		case "Alemania":
			banderaImagen.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Alemania140x85.png")));
			banderaImagen.setVisible(true);
			infoBanderas.setText("VIDA: 400     MISILES:10\n\nBONUS:\nSuma +2 misiles cada ronda");
			infoBanderas.setVisible(true);
			break;
		case "Francia" : 
			banderaImagen.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Francia140x85.png")));
			banderaImagen.setVisible(true);
			infoBanderas.setText("VIDA: 250     MISILES:60\n\nBONUS:\n50% de probabilidad de rendirse si la vida es 50 o menor");
			infoBanderas.setVisible(true);
			break;
		case "Suiza" : 
			banderaImagen.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Suiza140x85.png")));
			banderaImagen.setVisible(true);
			infoBanderas.setText("VIDA: 300     MISILES:35\nBONUS:\nLos misiles de defensa valen la mitad\n(1 misil para defender en vez de 2)");
			infoBanderas.setVisible(true);
			break;
		case "Kazajistan":
			banderaImagen.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Kazajistan140x85.png")));
			banderaImagen.setVisible(true);
			infoBanderas.setText("VIDA: 200     MISILES:40\nBONUS:\nAtaca el x2 a Lituania\nAtaca la mitad a Rusia");
			infoBanderas.setVisible(true);
			break;
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
		if (name.length() > 10) {
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