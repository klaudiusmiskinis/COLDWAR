package coldwar;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.*;

import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.Button;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

import java.awt.Font;
import javax.swing.JButton;

public class PanelPartida extends JPanel implements ActionListener {

	//ATRIBUTOS
	static int ronda = 0;
	ArrayList<Paises> paisesJugar;
	JComboBox<String> desplegable;
	JButton bAtacar, bDefender;
	JLabel banderaImagen, fondo, infoBandera;
	JFormattedTextField insertMisiles, infoTurno, infoMisiles, infoVida;
	JTextPane infoAtacado;
	int turno = 0;
	int contador = 0;
	Paises paisAtacado;
	String history = "";

	//CONSTRUCTOR QUE RECIBE ARRAYLIST
	public PanelPartida(ArrayList<Paises> paisesCreados,int a,String b) {

		//VARIABLES
		this.paisesJugar = paisesCreados;
		this.history = b;
		this.turno = a;
		String jugActual = paisesJugar.get(turno).getNombre();

		//PARA EVITAR QUE SALGA UN PAIS MUERTO
		do {
			if(paisesCreados.get(turno).getVida()==0) {
				turno++;
			}
		} while(paisesCreados.get(turno).getVida()==0);

		//ELEMENTOS DE LA VENTANA
		setBounds(0,-5,1080,768);
		setBackground(Color.BLACK);
		setLayout(null);

		//TEXTFIELD ATACAR
		insertMisiles = new JFormattedTextField();
		insertMisiles.setForeground(Color.WHITE);
		insertMisiles.setBackground(Color.BLACK);
		insertMisiles.setBounds(24, 477, 157, 38);
		insertMisiles.setText("0");
		insertMisiles.addActionListener(this);
		add(insertMisiles);

		//TEXTFIELD CANTIDAD DE VIDA
		infoVida = new JFormattedTextField();
		infoVida.setText("VIDA: " + paisesJugar.get(turno).getVida());
		infoVida.setForeground(Color.WHITE);
		infoVida.setFont(new Font("Calibri", Font.BOLD, 14));
		infoVida.setEditable(false);
		infoVida.setBackground(Color.BLACK);
		infoVida.setBounds(24, 131, 275, 45);
		add(infoVida);

		//TEXTFIELD CANTIDAD MISILES
		infoMisiles = new JFormattedTextField();
		infoMisiles.setForeground(Color.WHITE);
		infoMisiles.setBackground(Color.BLACK);
		infoMisiles.setBounds(24, 187, 275, 45);
		infoMisiles.setFont(new Font("Calibri", Font.BOLD, 14));
		infoMisiles.setEditable(false);
		infoMisiles.setText("MISILES: " + paisesJugar.get(turno).getMisiles());
		add(infoMisiles);

		//JLABEL BANDERAPAISATACADO
		banderaImagen = new JLabel("");
		banderaImagen.setBackground(Color.WHITE);
		banderaImagen.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Espanya140x85.png")));
		banderaImagen.setBounds(606, 421, 140, 85);
		banderaImagen.setVisible(false);
		add(banderaImagen);

		//TEXTFIELD TURNO
		infoTurno = new JFormattedTextField();
		infoTurno.setForeground(Color.WHITE);
		infoTurno.setBackground(Color.BLACK);
		infoTurno.setBounds(24, 75, 275, 45);
		infoTurno.setFont(new Font("Calibri", Font.BOLD, 14));
		infoTurno.setEditable(false);
		infoTurno.setText("TURNO DE: " + paisesJugar.get(turno).getNombre());
		infoTurno.addActionListener(this);
		add(infoTurno);

		//JTEXTPANE INFO DEL ATACADO
		infoAtacado = new JTextPane();
		infoAtacado.setForeground(Color.WHITE);
		infoAtacado.setFont(new Font("Calibri", Font.BOLD, 19));
		StyledDocument doc = infoAtacado.getStyledDocument();
		SimpleAttributeSet centrar = new SimpleAttributeSet();
		StyleConstants.setAlignment(centrar, StyleConstants.ALIGN_LEFT);
		doc.setParagraphAttributes(0, doc.getLength(), centrar, false);
		infoAtacado.setEditable(false);
		infoAtacado.setBounds(349, 417, 176, 108);
		infoAtacado.setBorder(null);
		infoAtacado.setOpaque(false);
		infoAtacado.setBackground(null);
		add(infoAtacado);

		//BOTON DEFENDER
		bDefender = new JButton("");
		bDefender.setIcon(new ImageIcon(PanelPartida.class.getResource("/coldwar/assets/iconos/BOTON_DEFENDER.png")));
		bDefender.setBounds(245, 477, 54, 38);
		bDefender.setOpaque(false);
		bDefender.setContentAreaFilled(false);
		bDefender.setFocusable(false);
		bDefender.setBorderPainted(false);
		bDefender.addActionListener(this);
		add(bDefender);

		//BOTON ATACAR
		bAtacar = new JButton("");
		bAtacar.setIcon(new ImageIcon(PanelPartida.class.getResource("/coldwar/assets/iconos/BOTON_ATACAR.png")));
		bAtacar.setBounds(186, 477, 54, 38);
		bAtacar.setOpaque(false);
		bAtacar.setContentAreaFilled(false);
		bAtacar.setFocusable(false);
		bAtacar.setBorderPainted(false);
		bAtacar.addActionListener(this);
		add(bAtacar);

		//JLABEL BANDERADELJUGADORTURNO
		infoBandera = new JLabel();
		infoBandera.setBounds(24, 243, 275, 85);
		switch (paisesJugar.get(turno).getTipo().toString()) {
		case "USA": 
			infoBandera.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Usa140x8.png")));
			infoBandera.setVisible(true);
			break;
		case "UK":
			infoBandera.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/UK140x85.png")));
			infoBandera.setVisible(true);
			break;
		case "Lituania":
			infoBandera.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Lituania140x85.png")));
			infoBandera.setVisible(true);
			break;
		case "Rusia":
			infoBandera.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Rusia140x85.png")));
			infoBandera.setVisible(true);
			break;
		case "Espanya":
			infoBandera.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Espanya140x85.png")));
			infoBandera.setVisible(true);
			break;
		case "Vietnam":
			infoBandera.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Vietnam140x85.png")));
			infoBandera.setVisible(true);
			break;
		case "Alemania":
			infoBandera.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Alemania140x85.png")));
			infoBandera.setVisible(true);
			break;
		case "Francia" : 
			infoBandera.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Francia140x85.png")));
			infoBandera.setVisible(true);
			break;
		case "Suiza" : 
			infoBandera.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Suiza140x85.png")));
			infoBandera.setVisible(true);
			break;
		case "Kazajistan":
			infoBandera.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Kazajistan140x85.png")));
			infoBandera.setVisible(true);
			break;
		}
		add(infoBandera);

		//COMBOBOX DESPLEGABLE
		desplegable= new JComboBox<String>();
		desplegable.setBounds(24, 428, 275, 38);
		desplegable.setMaximumRowCount(10);
		desplegable.setForeground(Color.WHITE);
		desplegable.setBackground(Color.BLACK);
		desplegable.setBorder(new LineBorder(Color.BLACK));
		desplegable.setFocusable(false);
		desplegable.addActionListener(this);
		add(desplegable);

		//JLABEL FONDO
		fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(PanelPartida.class.getResource("/coldwar/assets/fondos/PanelPartida.png")));
		fondo.setBounds(0, 0, 1080, 768);
		add(fondo);

		//PROGRAMA
		for(int i = 0; i < paisesCreados.size(); i++) {
			if (!paisesCreados.get(i).getNombre().equals(jugActual)) {
				if(paisesCreados.get(i).getVida()>0) {
					desplegable.addItem(paisesCreados.get(i).getNombre());
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean misilesCorrectos=false;
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
		Matcher matcher = pattern.matcher(insertMisiles.getText());
		int misiles = 0;

		try {
			misiles = Integer.parseInt(insertMisiles.getText());
			if(Integer.parseInt(insertMisiles.getText())<0 ) {
				misiles=0;
			}
		} catch(Exception a) {
			misiles = 0;
			insertMisiles.setText("0");
			JOptionPane.showMessageDialog(new JFrame(), "Has introducido letras", "ERROR",JOptionPane.ERROR_MESSAGE);
		}

		if(e.getSource() == desplegable) {
			for(int i = 0;i<paisesJugar.size();i++) {
				if(desplegable.getSelectedItem().equals(paisesJugar.get(i).getNombre().toString())) {
					infoAtacado.setText("NOMBRE: " + paisesJugar.get(i).getNombre() + "\nPAIS: "+paisesJugar.get(i).getTipo() + "\nVIDA: "+paisesJugar.get(i).getVida()+"\nMISILES: " + paisesJugar.get(i).getMisiles());
					switch (paisesJugar.get(i).getTipo().toString()) {
					case "USA": 
						banderaImagen.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Usa140x8.png")));
						banderaImagen.setVisible(true);
						break;
					case "UK":
						banderaImagen.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/UK140x85.png")));
						banderaImagen.setVisible(true);
						break;
					case "Lituania":
						banderaImagen.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Lituania140x85.png")));
						banderaImagen.setVisible(true);
						break;
					case "Rusia":
						banderaImagen.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Rusia140x85.png")));
						banderaImagen.setVisible(true);
						break;
					case "Espanya":
						banderaImagen.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Espanya140x85.png")));
						banderaImagen.setVisible(true);
						break;
					case "Vietnam":
						banderaImagen.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Vietnam140x85.png")));
						banderaImagen.setVisible(true);
						break;
					case "Alemania":
						banderaImagen.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Alemania140x85.png")));
						banderaImagen.setVisible(true);
						break;
					case "Francia" : 
						banderaImagen.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Francia140x85.png")));
						banderaImagen.setVisible(true);
						break;
					case "Suiza" : 
						banderaImagen.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Suiza140x85.png")));
						banderaImagen.setVisible(true);
						break;
					case "Kazajistan":
						banderaImagen.setIcon(new ImageIcon(PanelJuego.class.getResource("/coldwar/assets/banderas/Kazajistan140x85.png")));
						banderaImagen.setVisible(true);
						break;
					}
				}
			}
		}

		if (e.getSource() == bAtacar) {
			//VALIDACION DE TEXTFIELD
			//CONTIENE CANTIDAD DE MISILES NO VALIDA
			if (misiles > paisesJugar.get(turno).getMisiles() || misiles < 0) {
				JOptionPane.showMessageDialog(new JFrame(), "Numero de misiles no valido", "ERROR",JOptionPane.ERROR_MESSAGE);
				misilesCorrectos=true;
			} 

			//CONTIENE LETRAS
			else if (insertMisiles.getText().contains("[a-zA-Z]+")) {
				JOptionPane.showMessageDialog(new JFrame(), "Has introducido letras", "ERROR",JOptionPane.ERROR_MESSAGE);
			}

			//CONTIENE SIMBOLOS
			else if(matcher.find() == true) {
				JOptionPane.showMessageDialog(new JFrame(), "El nombre no puede contener simbolos y espacios", "ERROR",JOptionPane.ERROR_MESSAGE);
			}

			//FUNCIONALIDAD ATACAR
			String elementoDesplegable = desplegable.getSelectedItem().toString();
			paisAtacado = new Paises();
			for(int i = 0; i < paisesJugar.size();i++) {
				if (elementoDesplegable == paisesJugar.get(i).getNombre()) {
					paisAtacado = paisesJugar.get(i);
				}
			}

			if(misiles<0) {
				misiles=0;
			}

			if ( paisesJugar.get(turno).getMisiles() > 0 && (paisesJugar.get(turno).getMisiles()-misiles)>=0) {
				paisesJugar.get(turno).variables(paisAtacado,misiles);
				paisesJugar.get(turno).setMisiles((paisesJugar.get(turno).getMisiles() - misiles));
				infoMisiles.setText("Cantidad de misiles: " + paisesJugar.get(turno).getMisiles());
			}

			if(Integer.parseInt(insertMisiles.getText())>0 && misilesCorrectos==false) {
				history = history + "\nEl jugador "+paisesJugar.get(turno).getNombre()+" ataca a " + desplegable.getSelectedItem().toString()+" con " + insertMisiles.getText()+" misiles\n";
			}
		}

		if (e.getSource() == bDefender) {
			// CONTIENE CANTIDAD DE MISILES NO VALIDA
			if (misiles > paisesJugar.get(turno).getMisiles() || misiles%2 != 0) {
				JOptionPane.showMessageDialog(new JFrame(), "Numero de misiles no valido", "ERROR",JOptionPane.ERROR_MESSAGE);
			}
			// CONTIENE LETRAS
			else if (insertMisiles.getText().contains("[a-zA-Z]+")) {
				JOptionPane.showMessageDialog(new JFrame(), "Has introducido letras", "ERROR",JOptionPane.ERROR_MESSAGE);
			}
			//CONTIENE SIMBOLOS
			else if(matcher.find() == true) {
				JOptionPane.showMessageDialog(new JFrame(), "El nombre no puede contener simbolos y espacios", "ERROR",JOptionPane.ERROR_MESSAGE);
			}

			//FUNCIONALIDAD DEFENDER
			String elementoDesplegable = desplegable.getSelectedItem().toString();
			for(int i = 0; i < paisesJugar.size();i++) {

				if (elementoDesplegable == paisesJugar.get(i).getNombre()) {
					paisAtacado = paisesJugar.get(i);
				}
			}

			if ( paisesJugar.get(turno).getMisiles() > 0 && (paisesJugar.get(turno).getMisiles()-misiles)>=0){
				misiles = Integer.parseInt(insertMisiles.getText());
				if(misiles<0) {
					misiles=0;
				}
				if(misiles%2 == 0) {
					if(misiles/2 == 0) {
						paisesJugar.get(turno).setSumaDefensa(1);
					} else {
						paisesJugar.get(turno).setSumaDefensa(paisesJugar.get(turno).getSumaDefensa() + (misiles/2));
					}
					if(paisesJugar.get(turno).getSumaDefensa() < 0) {
						paisesJugar.get(turno).setSumaDefensa(0);
					}

					paisesJugar.get(turno).setMisiles((paisesJugar.get(turno).getMisiles() - misiles));
					infoMisiles.setText("Cantidad de misiles: " + paisesJugar.get(turno).getMisiles());
				}

				if(Integer.parseInt(insertMisiles.getText()) > 0 ) {
					history = history + "\nEl jugador "+paisesJugar.get(turno).getNombre()+" se defiende con " + insertMisiles.getText()+" misiles\n";
				}
			}
		}

		if (paisesJugar.get(turno).getMisiles() == 0) {
			if (turno == paisesJugar.size()-1) {
				ronda++;

				for(int i = 0; i < paisesJugar.size();i++) {
					if(paisesJugar.get(i).getTipo().equals("Francia")) {
					}
				}

				for (int i = 0; i < paisesJugar.size(); i++) {
					paisesJugar.get(i).actualizarDatos();
					paisesJugar.get(i).recargar();
					paisesJugar.get(i).setSumaAtaque(0);
					paisesJugar.get(i).setSumaDefensa(0);
				}
				JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
				marco.remove(this);
				marco.getContentPane().add(new PanelResumen(paisesJugar,history));
				marco.setVisible(true);
			} else {
				turno++;
				JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
				marco.remove(this);
				marco.getContentPane().add(new PanelPartida(paisesJugar,turno,history));
				marco.setVisible(true);
			}
		}
	}
}