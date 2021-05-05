package coldwar;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class PanelPartida extends JPanel implements ActionListener {

	//ATRIBUTOS
	static int ronda = 0;
	ArrayList<Paises> paisesJugar;
	JComboBox<String> desplegable;
	JButton bAtacar, bDefender,bTurno;
	JFormattedTextField insertMisiles, infoTurno, infoMisiles, infoRonda;
	int turno = 0;
	int contador = 0;
	//CONSTRUCTOR QUE RECIBE ARRAYLIST
	public PanelPartida(ArrayList<Paises> paisesCreados,int a) {

		//VARIABLES
		this.paisesJugar = paisesCreados;
		this.turno = a;
		String jugActual = "";

		//ELEMENTOS DE LA VENTANA
		setBounds(0,0,1080,768);
		setLayout(null);
		setBackground(Color.BLACK);

		//TEXTFIELD ATACAR
		insertMisiles = new JFormattedTextField();
		insertMisiles.setText("0");
		insertMisiles.setBounds(263, 454, 133, 38);
		insertMisiles.addActionListener(this);
		add(insertMisiles);

		//BOTON ATACAR
		bAtacar = new JButton("Atacar");
		bAtacar.setBounds(227, 498, 100, 38);
		bAtacar.addActionListener(this);
		add(bAtacar);

		//TEXTFIELD CANTIDAD MISILES
		infoMisiles = new JFormattedTextField();
		infoMisiles.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		infoMisiles.setEditable(false);
		infoMisiles.setText("Cantidad de misiles: " + paisesCreados.get(turno).getMisiles());
		infoMisiles.setBounds(29, 313, 206, 56);
		add(infoMisiles);

		//BOTON DEFENDER
		bDefender = new JButton("Defender");
		bDefender.setBounds(333, 498, 100, 38);
		bDefender.addActionListener(this);
		add(bDefender);	

		//TEXTFIELD TURNO
		infoTurno = new JFormattedTextField();
		infoTurno.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		infoTurno.setEditable(false);
		infoTurno.setText("Turno de : " + (jugActual = paisesCreados.get(turno).getNombre()));
		infoTurno.setBounds(29, 183, 206, 62);
		infoTurno.addActionListener(this);
		add(infoTurno);

		//COMBOBOX DESPLEGABLE
		desplegable= new JComboBox<String>();
		desplegable.setMaximumRowCount(10);
		desplegable.setForeground(Color.WHITE);
		desplegable.setBackground(Color.BLACK);
		desplegable.setBorder(new LineBorder(Color.BLACK));
		desplegable.setFocusable(false);
		desplegable.setBounds(58, 498, 159, 38);
		add(desplegable);

		bTurno = new JButton("Pasar turno");
		bTurno.setBounds(981, 682, 89, 23);
		bTurno.addActionListener(this);
		add(bTurno);
		
		// TEXTFIELD RONDA
		infoRonda = new JFormattedTextField();
		infoRonda.setText("Ronda " + ronda);
		infoRonda.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		infoRonda.setEditable(false);
		infoRonda.setBounds(405, 36, 206, 62);
		add(infoRonda);

		//PROGRAMA
		for(int i = 0; i < paisesCreados.size(); i++) {
			if (!paisesCreados.get(i).getNombre().equals(jugActual)) {
				desplegable.addItem(paisesCreados.get(i).getNombre());
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
		Matcher matcher = pattern.matcher(insertMisiles.getText());
		int misiles = 0;
		Paises paisAtacado = new Paises();
		try {
			misiles = Integer.parseInt(insertMisiles.getText());
		} catch(Exception a) {
			misiles = 0;
			insertMisiles.setText("0");
			JOptionPane.showMessageDialog(new JFrame(), "Has introducido letras", "ERROR",JOptionPane.ERROR_MESSAGE);
		}

		if (e.getSource() == bAtacar) {
			System.out.println("Atacando con " + insertMisiles.getText());

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

			String elementoDesplegable = desplegable.getSelectedItem().toString();

			for(int i = 0; i < paisesJugar.size();i++) {
				if (elementoDesplegable == paisesJugar.get(i).getNombre()) {
					paisAtacado = paisesJugar.get(i);
					System.out.println(paisAtacado.getNombre());
				}
			}

			paisesJugar.get(turno).variables(paisAtacado,misiles,0);

			System.out.println(paisAtacado.getSumaAtaque());
			// ACTUALIZAR VIDA
			paisesJugar.get(turno).actualizarDatos(paisAtacado);

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
		}

		if (e.getSource() == bTurno) {
			if (turno == paisesJugar.size()-1) {
				ronda++;
				JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
				marco.remove(this);
				marco.getContentPane().add(new PanelResumen(paisesJugar));
				marco.setVisible(true);

			} else {
				System.out.println("turno : " + turno);
				turno++;
				JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
				marco.remove(this);
				marco.getContentPane().add(new PanelPartida(paisesJugar,turno));
				marco.setVisible(true);
			}
		}
	}
}
