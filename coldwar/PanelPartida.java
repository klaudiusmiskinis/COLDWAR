package coldwar;

import java.util.ArrayList;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.Button;
import javax.swing.JToggleButton;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.JButton;

public class PanelPartida extends JPanel implements ActionListener {

	//ATRIBUTOS
	ArrayList<Paises> paisesJugar;
	JComboBox desplegable;
	JButton bAtacar, bDefender;
	JFormattedTextField misilesCantidad;


	//CONSTRUCTOR QUE RECIBE ARRAYLIST
	public PanelPartida(ArrayList<Paises> paisesCreados) {

		// Variebles
		int ronda = 0;
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
		JFormattedTextField misilesCantidad = new JFormattedTextField();
		misilesCantidad.setText("0");
		misilesCantidad.setBounds(256, 229, 133, 38);
		misilesCantidad.addActionListener(this);
		add(misilesCantidad);

		//BOTON ATACAR
		JButton bAtacar = new JButton("Atacar");
		bAtacar.setBounds(220, 273, 100, 38);
		bAtacar.addActionListener(this);
		add(bAtacar);

		//TEXTFIELD CANTIDAD MISILES
		JFormattedTextField tCantidad = new JFormattedTextField();
		tCantidad.setEditable(false);
		tCantidad.setText("Cantidad de misiles: " + paisesCreados.get(ronda).getMisiles());
		tCantidad.setBounds(65, 102, 429, 23);
		add(tCantidad);

		//BOTON DEFENDER
		JButton bDefender = new JButton("Defender");
		bDefender.setBounds(326, 273, 100, 38);
		bDefender.addActionListener(this);
		add(bDefender);	

		//TEXTFIELD TURNO
		JFormattedTextField tTurno = new JFormattedTextField();
		tTurno.setEditable(false);
		tTurno.setText("Turno de : " + (jugActual = paisesCreados.get(ronda).getNombre()));
		tTurno.setBounds(65, 53, 429, 38);
		add(tTurno);

		//COMBOBOX DESPLEGABLE
		JComboBox<String> desplegable= new JComboBox<String>();
		desplegable.setMaximumRowCount(10);
		desplegable.setBounds(51, 273, 159, 38);
		add(desplegable);

		//BOTON TURNO
		JButton bTurno = new JButton("Siguiente turno");
		bTurno.setBounds(872, 582, 133, 23);
		add(bTurno);

		//PROGRAMA
		for(int i = 0; i < paisesCreados.size(); i++) {
			if (!paisesCreados.get(i).getNombre().equals(jugActual)) {
				desplegable.addItem(paisesCreados.get(i).getNombre());
			}
		}
		/*
		do {

		} while(paisesCreados.get(ronda).getMisiles() > 0); 

		 */
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bAtacar) {
			System.out.println("Atacando con" + misilesCantidad.getText());
		}

		if (e.getSource() == bAtacar) {
			System.out.println("Defendiendo con" + misilesCantidad.getText());
		}
	}
}
