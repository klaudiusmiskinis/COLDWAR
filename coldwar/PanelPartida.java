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
	JButton bAtacar, bDefender,sTurno;
	JFormattedTextField misilesCantidad, tTurno, tCantidad;
	int turno = 0;
	//CONSTRUCTOR QUE RECIBE ARRAYLIST
	public PanelPartida(ArrayList<Paises> paisesCreados,int a) {

		// Variebles
		this.paisesJugar = paisesCreados;
		this.turno = a;
		String jugActual = "";
		//METODOS DE LA VENTANA
		setBounds(0,0,1080,768);
		setLayout(null);
		setBackground(Color.BLACK);

		//PRINT DEL ARRAYLIST
		/*for (Paises pais1 : paisesJugar) {
			Paises p = (Paises)pais1;
			System.out.println(p.getNombre() + " " + p.getTipo() + " " + p.getVida() + " " + p.getMisiles());
		}*/


		//TEXTFIELD ATACAR
		misilesCantidad = new JFormattedTextField();
		misilesCantidad.setText("0");
		misilesCantidad.setBounds(256, 229, 133, 38);
		misilesCantidad.addActionListener(this);
		add(misilesCantidad);

		//BOTON ATACAR
		bAtacar = new JButton("Atacar");
		bAtacar.setBounds(220, 273, 100, 38);
		bAtacar.addActionListener(this);
		add(bAtacar);

		//TEXTFIELD CANTIDAD MISILES
		tCantidad = new JFormattedTextField();
		tCantidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		tCantidad.setEditable(false);
		tCantidad.setText("Cantidad de misiles: " + paisesCreados.get(turno).getMisiles());
		tCantidad.setBounds(263, 52, 206, 56);
		add(tCantidad);

		//BOTON DEFENDER
		bDefender = new JButton("Defender");
		bDefender.setBounds(326, 273, 100, 38);
		bDefender.addActionListener(this);
		add(bDefender);	

		//TEXTFIELD TURNO
		tTurno = new JFormattedTextField();
		tTurno.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		tTurno.setEditable(false);
		tTurno.setText("Turno de : " + (jugActual = paisesCreados.get(turno).getNombre()));
		tTurno.setBounds(29, 53, 198, 56);
		tTurno.addActionListener(this);
		add(tTurno);

		//COMBOBOX DESPLEGABLE
		desplegable= new JComboBox<String>();
		desplegable.setMaximumRowCount(10);
		desplegable.setBounds(51, 273, 159, 38);
		add(desplegable);

		sTurno = new JButton("Pasar turno");
		sTurno.setBounds(981, 682, 89, 23);
		sTurno.addActionListener(this);
		add(sTurno);

		//PROGRAMA
		for(int i = 0; i < paisesCreados.size(); i++) {
			if (!paisesCreados.get(i).getNombre().equals(jugActual)) {
				desplegable.addItem(paisesCreados.get(i).getNombre());
			}
		}
		/*
		do {
		} while(paisesCreados.get(turno).getMisiles() > 0); 
		 */
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
		Matcher matcher = pattern.matcher(misilesCantidad.getText());
		int misiles = 0;
		try {
			misiles = Integer.parseInt(misilesCantidad.getText());
		}catch(Exception a) {
			misiles = 0;
			misilesCantidad.setText("0");
			JOptionPane.showMessageDialog(new JFrame(), "Has introducido letras", "ERROR",JOptionPane.ERROR_MESSAGE);
		}
		if (e.getSource() == bAtacar) {
			System.out.println("Atacando con " + misilesCantidad.getText());
			// CONTIENE CANTIDAD DE MISILES NO VALIDA
			if (misiles > paisesJugar.get(turno).getMisiles() || misiles < 0) {
				JOptionPane.showMessageDialog(new JFrame(), "Numero de misiles no valido", "ERROR",JOptionPane.ERROR_MESSAGE);
			} 
			// CONTIENE LETRAS
			else if (misilesCantidad.getText().contains("[a-zA-Z]+")) {
				JOptionPane.showMessageDialog(new JFrame(), "Has introducido letras", "ERROR",JOptionPane.ERROR_MESSAGE);
			}
			//CONTIENE SIMBOLOS
			else if(matcher.find() == true) {
				JOptionPane.showMessageDialog(new JFrame(), "El nombre no puede contener simbolos y espacios", "ERROR",JOptionPane.ERROR_MESSAGE);
				System.out.println("Contiene simbolos");
			}
			String ab = desplegable.getSelectedItem().toString();
			Paises paisAtacado = new Paises();
			for(int i = 0; i < paisesJugar.size();i++) {
				if (ab == paisesJugar.get(i).getNombre()) {
				paisAtacado = paisesJugar.get(i);
				System.out.println(paisAtacado.getNombre());
				}
			}
			paisesJugar.get(turno).variables(paisAtacado,misiles,0);
			System.out.println(paisAtacado.getSumaAtaque());
			paisesJugar.get(turno).actualizarDatos(paisAtacado);
		}

		if (e.getSource() == bDefender) {
			System.out.println("Defendiendo con " + misilesCantidad.getText());
			// CONTIENE CANTIDAD DE MISILES NO VALIDA
			if (misiles > paisesJugar.get(turno).getMisiles() || misiles < 0) {
				JOptionPane.showMessageDialog(new JFrame(), "Numero de misiles no valido", "ERROR",JOptionPane.ERROR_MESSAGE);
			} 
			// CONTIENE LETRAS
			else if (misilesCantidad.getText().contains("[a-zA-Z]+")) {
				JOptionPane.showMessageDialog(new JFrame(), "Has introducido letras", "ERROR",JOptionPane.ERROR_MESSAGE);
			}
			//CONTIENE SIMBOLOS
			else if(matcher.find() == true) {
				JOptionPane.showMessageDialog(new JFrame(), "El nombre no puede contener simbolos y espacios", "ERROR",JOptionPane.ERROR_MESSAGE);
				System.out.println("Contiene simbolos");
			}
		}

		if (e.getSource() == sTurno) {
			if (turno == paisesJugar.size()-1) {
				ronda++;
				JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
				marco.remove(this);
				marco.getContentPane().add(new PanelResumen(paisesJugar));
				marco.setVisible(true);
			} else {
				turno++;
				JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
				marco.remove(this);
				marco.getContentPane().add(new PanelPartida(paisesJugar,turno));
				marco.setVisible(true);
				System.out.println("Defendiendo con " + misilesCantidad.getText());
			}
		}
	}
}
