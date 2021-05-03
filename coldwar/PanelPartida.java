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

		// Variebles
		int ronda = 0;
		String jugactual = "";
		//METODOS DE LA VENTANA
		setBounds(0,0,1080,768);
		setLayout(null);
		setBackground(Color.BLACK);
		this.paisesJugar = paisesCreados; //SE GUARDA EL ARRAYLIST DE LA VENTANA DE CREACION DE EQUIPOS

		//PRINT DEL ARRAYLIST
		/*for (Paises pais1 : paisesJugar) {
			Paises p = (Paises)pais1;
			System.out.println(p.getNombre() + " " + p.getTipo() + " " + p.getVida() + " " + p.getMisiles());
		}*/

		// Botones y GUI

		JFormattedTextField tAtacar = new JFormattedTextField();
		tAtacar.setText("0");
		tAtacar.setBounds(401, 366, 123, 38);
		tAtacar.setFont(new Font("Arial", Font.PLAIN, 18));
		add(tAtacar);

		JButton bAtacar = new JButton("Atacar");
		bAtacar.setBounds(607, 306, 100, 38);
		add(bAtacar);

		JFormattedTextField tDefender = new JFormattedTextField();
		tDefender.setText("Cantidad de misiles\r\n");
		tDefender.setBounds(179, 306, 123, 118);
		add(tDefender);

		JButton bDefender = new JButton("Defender");
		bDefender.setBounds(607, 419, 100, 38);
		bDefender.addActionListener(this);
		add(bDefender);	

		JFormattedTextField turno = new JFormattedTextField();
		turno.setText("Turno de : " + (jugactual = paisesCreados.get(ronda).getNombre()));
		turno.setBounds(65, 53, 429, 126);
		add(turno);

		JComboBox<String> desplegable= new JComboBox<String>();
		desplegable.setMaximumRowCount(10);
		desplegable.setBounds(759, 306, 159, 38);
		add(desplegable);
		
		JButton bturno = new JButton("Siguiente turno");
		bturno.setBounds(872, 582, 133, 23);
		add(bturno);

		// Programa
		for(int i = 0; i < paisesCreados.size(); i++) {
			if (!paisesCreados.get(i).getNombre().equals(jugactual)) {
				desplegable.addItem(paisesCreados.get(i).getNombre());
			}
		}
		do {
			
		}while(paisesCreados.get(ronda).getMisiles() > 0);
	}


	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
