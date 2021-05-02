package coldwar;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Button;
import javax.swing.JToggleButton;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;
import java.awt.Font;

public class PanelPartida extends JPanel {
	JComboBox desplegable;


	//ATRIBUTOS
	ArrayList<Paises> paisesJugar;





	//CONSTRUCTOR QUE RECIBE ARRAYLIST
	public PanelPartida(ArrayList<Paises> paisesCreados) {


		setBackground(Color.BLACK);
		this.paisesJugar = paisesCreados; //SE GUARDA EL ARRAYLIST DE LA VENTANA DE CREACION DE EQUIPOS
		//METODOS DE LA VENTANA
		setBounds(0,0,1080,768);
		System.out.println("\r \n \r");

		//PRINT DEL ARRAYLIST
		for(Paises pais1 : paisesJugar) {
			Paises p = (Paises)pais1;
			System.out.println(p.getNombre() + " " + p.getTipo() + " " + p.getVida() + " " + p.getMisiles());
		}

		JComboBox desplegable= new JComboBox();

		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setFont(new Font("Haettenschweiler", Font.BOLD, 21));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
						.addGap(528)
						.addComponent(desplegable, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(314, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(256)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)	
								.addComponent(formattedTextField, Alignment.TRAILING)
								.addComponent(desplegable, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
						.addContainerGap(468, Short.MAX_VALUE))
				);

		desplegable.setMaximumRowCount(10);
		desplegable.setBounds(51, 92, 172, 34);
		for(int i=0;i<paisesCreados.size();i++) {
			desplegable.addItem(paisesCreados.get(i).getNombre());

		}


		setLayout(groupLayout);





	}
}
