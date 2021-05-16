package coldwar;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
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
	JFormattedTextField insertMisiles, infoTurno, infoMisiles;
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
		String jugActual = "";
		//PARA EVITAR QUE SALGA UN PAIS MUERTO
		do {
			if(paisesCreados.get(turno).getVida()==0) {
				turno++;
			}
		}while(paisesCreados.get(turno).getVida()==0);

		//ELEMENTOS DE LA VENTANA
		setBounds(0,0,1080,768);
		setBackground(Color.BLACK);

		//TEXTFIELD ATACAR
		insertMisiles = new JFormattedTextField();
		insertMisiles.setForeground(Color.WHITE);
		insertMisiles.setBackground(Color.BLACK);
		insertMisiles.setBounds(24, 362, 218, 38);
		insertMisiles.setText("0");
		insertMisiles.addActionListener(this);
		setLayout(null);
		add(insertMisiles);

		//BOTON ATACAR
		bAtacar = new JButton("");
		bAtacar.setIcon(new ImageIcon(PanelPartida.class.getResource("/coldwar/assets/textos/BOTON_ATACAR.png")));
		bAtacar.setBounds(245, 362, 54, 38);
		bAtacar.setOpaque(false);
		bAtacar.setContentAreaFilled(false);
		bAtacar.setFocusable(false);
		bAtacar.setBorderPainted(false);
		bAtacar.addActionListener(this);
		add(bAtacar);

		//TEXTFIELD CANTIDAD MISILES
		infoMisiles = new JFormattedTextField();
		infoMisiles.setForeground(Color.WHITE);
		infoMisiles.setBackground(Color.BLACK);
		infoMisiles.setBounds(24, 77, 339, 45);
		infoMisiles.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		infoMisiles.setEditable(false);
		infoMisiles.setText("Cantidad de misiles: " + paisesCreados.get(turno).getMisiles());
		add(infoMisiles);

		//BOTON DEFENDER
		bDefender = new JButton("");
		bDefender.setIcon(new ImageIcon(PanelPartida.class.getResource("/coldwar/assets/textos/BOTON_DEFENDER.png")));
		bDefender.setBounds(309, 362, 54, 38);
		bDefender.setOpaque(false);
		bDefender.setContentAreaFilled(false);
		bDefender.setFocusable(false);
		bDefender.setBorderPainted(false);
		bDefender.addActionListener(this);
		add(bDefender);	

		//TEXTFIELD TURNO
		infoTurno = new JFormattedTextField();
		infoTurno.setForeground(Color.WHITE);
		infoTurno.setBackground(Color.BLACK);
		infoTurno.setBounds(24, 28, 339, 45);
		infoTurno.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		infoTurno.setEditable(false);
		infoTurno.setText("Turno de : " + (jugActual = paisesCreados.get(turno).getNombre()));
		infoTurno.addActionListener(this);
		add(infoTurno);

		//COMBOBOX DESPLEGABLE
		desplegable= new JComboBox<String>();
		desplegable.setBounds(24, 318, 218, 38);
		desplegable.setMaximumRowCount(10);
		desplegable.setForeground(Color.WHITE);
		desplegable.setBackground(Color.BLACK);
		desplegable.setBorder(new LineBorder(Color.BLACK));
		desplegable.setFocusable(false);
		add(desplegable);

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(PanelPartida.class.getResource("/coldwar/assets/fondos/FondoPartidaV3.png")));
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


		if (e.getSource() == bAtacar) {
			System.out.println("Atacando con " + insertMisiles.getText() + " a " + desplegable.getSelectedItem().toString());
			//VALIDACION DE TEXTFIELD
			//CONTIENE CANTIDAD DE MISILES NO VALIDA
			if (misiles > paisesJugar.get(turno).getMisiles() || misiles < 0) {
				JOptionPane.showMessageDialog(new JFrame(), "Numero de misiles no valido", "ERROR",JOptionPane.ERROR_MESSAGE);
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
				System.out.println(paisAtacado.getSumaAtaque());
				infoMisiles.setText("Cantidad de misiles: " + paisesJugar.get(turno).getMisiles());
			}
			if(Integer.parseInt(insertMisiles.getText())>0 ) {
				history = history + "\nEl jugador "+paisesJugar.get(turno).getNombre()+" ataca a " + desplegable.getSelectedItem().toString()+" con " + insertMisiles.getText()+" misiles\n";
			}
		}

		if (e.getSource() == bDefender) {
			System.out.println("Defendiendo con " + insertMisiles.getText());
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
				System.out.println("Contiene simbolos");
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
					if(misiles/2==0) {
						paisesJugar.get(turno).setSumaDefensa(1);
					}else{
						paisesJugar.get(turno).setSumaDefensa(paisesJugar.get(turno).getSumaDefensa() + (misiles/2));
					}
					if(paisesJugar.get(turno).getSumaDefensa()<0) {
						paisesJugar.get(turno).setSumaDefensa(0);
					}
					paisesJugar.get(turno).setMisiles((paisesJugar.get(turno).getMisiles() - misiles));
					System.out.println(paisesJugar.get(turno).getSumaDefensa());
					infoMisiles.setText("Cantidad de misiles: " + paisesJugar.get(turno).getMisiles());
				}
				if(Integer.parseInt(insertMisiles.getText())>0 ) {
					history = history + "\nEl jugador "+paisesJugar.get(turno).getNombre()+" se defiende con " + insertMisiles.getText()+" misiles\n";
					System.out.println("TU");
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
					System.out.println("TIRO EN BOCA " + paisesJugar.get(i).getSumaAtaque() + " AAAAAAAAAAAAAAAAAAAA " + paisesJugar.get(i).getNombre() + paisesJugar.get(i).getMisiles());
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