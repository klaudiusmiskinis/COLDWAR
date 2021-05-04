package coldwar;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.JFormattedTextField;

public class PanelResumen extends JPanel {

	ArrayList <Paises> paisesCreados = new ArrayList() ;
	public PanelResumen(ArrayList <Paises> paisesCreados) {

		this.paisesCreados = paisesCreados;
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1080,768);
		panel.setLayout(null);
		add(panel);


		for(int i=0;i<paisesCreados.size();i++) {
		}

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(27, 57, 500,500);
		panel.add(tabbedPane);

		JFormattedTextField formattedTextField = new JFormattedTextField();
		tabbedPane.addTab("New tab", null, formattedTextField, null);
		for(int i = 0; i < paisesCreados.size(); i++) {
			String a = "Nombre : " + paisesCreados.get(i).getNombre() + "\nVida : " + paisesCreados.get(i).getVida() + "\nMisiles : " + paisesCreados.get(i).getMisiles();
			System.out.println(a);
			a = a + formattedTextField.getText();
			formattedTextField.setText("\n" + a);
		}
	}
}