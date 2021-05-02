package coldwar;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.DocumentListener;

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
	JFormattedTextField tAtacar, tDefender;


	//CONSTRUCTOR QUE RECIBE ARRAYLIST
	public PanelPartida(ArrayList<Paises> paisesCreados) {

		//METODOS DE LA VENTANA
		setBounds(0,0,1080,768);
		setLayout(null);
		setBackground(Color.BLACK);
		this.paisesJugar = paisesCreados; //SE GUARDA EL ARRAYLIST DE LA VENTANA DE CREACION DE EQUIPOS

		//PRINT DEL ARRAYLIST
		for (Paises pais1 : paisesJugar) {
			Paises p = (Paises)pais1;
			System.out.println(p.getNombre() + " " + p.getTipo() + " " + p.getVida() + " " + p.getMisiles());
		}

		JComboBox desplegable= new JComboBox();
		desplegable.setMaximumRowCount(10);
		desplegable.setBounds(10, 257, 159, 38);
		add(desplegable);

		for(int i = 0; i < paisesCreados.size(); i++) {
			desplegable.addItem(paisesCreados.get(i).getNombre());
		}

		JFormattedTextField tAtacar = new JFormattedTextField();
		tAtacar.setBounds(179, 257, 123, 38);
		tAtacar.setFont(new Font("Arial", Font.PLAIN, 18));
		add(tAtacar);

		JButton bAtacar = new JButton("Atacar");
		bAtacar.setBounds(312, 257, 100, 38);
		add(bAtacar);

		JFormattedTextField tDefender = new JFormattedTextField();
		tDefender.setBounds(179, 306, 123, 38);
		add(tDefender);

		JButton bDefender = new JButton("Defender");
		bDefender.setBounds(312, 306, 100, 38);
		bDefender.addActionListener(this);
		add(bDefender);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
