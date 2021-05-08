package coldwar2;

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
	JButton bAtacar, bDefender,sTurno;
	JFormattedTextField insertMisiles, infoTurno, infoMisiles;
	int turno = 0;
	int contador = 0;
	Paises paisAtacado;
	//CONSTRUCTOR QUE RECIBE ARRAYLIST
	public PanelPartida(ArrayList<Paises> paisesCreados,int a) {

		//VARIABLES
		this.paisesJugar = paisesCreados;
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
		setLayout(null);
		setBackground(Color.BLACK);

		//TEXTFIELD ATACAR
		insertMisiles = new JFormattedTextField();
		insertMisiles.setText("0");
		insertMisiles.setBounds(256, 229, 133, 38);
		insertMisiles.addActionListener(this);
		add(insertMisiles);

		//BOTON ATACAR
		bAtacar = new JButton("Atacar");
		bAtacar.setBounds(220, 273, 100, 38);
		bAtacar.addActionListener(this);
		add(bAtacar);

		//TEXTFIELD CANTIDAD MISILES
		infoMisiles = new JFormattedTextField();
		infoMisiles.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		infoMisiles.setEditable(false);
		infoMisiles.setText("Cantidad de misiles: " + paisesCreados.get(turno).getMisiles());
		infoMisiles.setBounds(263, 52, 206, 56);
		add(infoMisiles);

		//BOTON DEFENDER
		bDefender = new JButton("Defender");
		bDefender.setBounds(326, 273, 100, 38);
		bDefender.addActionListener(this);
		add(bDefender);	

		//TEXTFIELD TURNO
		infoTurno = new JFormattedTextField();
		infoTurno.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		infoTurno.setEditable(false);
		infoTurno.setText("Turno de : " + (jugActual = paisesCreados.get(turno).getNombre()));
		infoTurno.setBounds(29, 53, 198, 56);
		infoTurno.addActionListener(this);
		add(infoTurno);

		//COMBOBOX DESPLEGABLE
		desplegable= new JComboBox<String>();
		desplegable.setMaximumRowCount(10);
		desplegable.setForeground(Color.WHITE);
		desplegable.setBackground(Color.BLACK);
		desplegable.setBorder(new LineBorder(Color.BLACK));
		desplegable.setFocusable(false);
		desplegable.setBounds(51, 273, 159, 38);
		add(desplegable);

		sTurno = new JButton("Pasar turno");
		sTurno.setBounds(981, 682, 89, 23);
		sTurno.addActionListener(this);
		add(sTurno);

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
			if ( paisesJugar.get(turno).getMisiles() > 0) {
				paisesJugar.get(turno).variables(paisAtacado,misiles);
			paisesJugar.get(turno).setMisiles((paisesJugar.get(turno).getMisiles() - misiles));
			System.out.println(paisAtacado.getSumaAtaque());
			infoMisiles.setText("Cantidad de misiles: " + paisesJugar.get(turno).getMisiles());
		} else {
			System.out.println("NO AMMO");
		}
	}

	if (e.getSource() == bDefender) {
		System.out.println("Defendiendo con " + insertMisiles.getText());
		// CONTIENE CANTIDAD DE MISILES NO VALIDA
		if (misiles > paisesJugar.get(turno).getMisiles() || misiles < 0) {
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
		if ( paisesJugar.get(turno).getMisiles() > 0) {
		misiles = Integer.parseInt(insertMisiles.getText());
		paisesJugar.get(turno).setSumaDefensa(misiles/2);
		paisesJugar.get(turno).setMisiles((paisesJugar.get(turno).getMisiles() - misiles));
		System.out.println(paisesJugar.get(turno).getSumaDefensa());
		infoMisiles.setText("Cantidad de misiles: " + paisesJugar.get(turno).getMisiles());
		} else {
			System.out.println("NO AMMO");
		}
	}

	if (e.getSource() == sTurno) {
		if (turno == paisesJugar.size()-1) {
			ronda++;

			for (int i = 0; i < paisesJugar.size(); i++) {
				System.out.println("TIRO EN BOCA " + paisesJugar.get(i).getSumaAtaque() + " AAAAAAAAAAAAAAAAAAAA " + paisesJugar.get(i).getNombre() + paisesJugar.get(i).getMisiles());
				paisesJugar.get(i).actualizarDatos();
				paisesJugar.get(i).recargar();
				paisesJugar.get(i).setSumaAtaque(0);
				paisesJugar.get(i).setSumaDefensa(0);
			}
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
		}
	}
}
}