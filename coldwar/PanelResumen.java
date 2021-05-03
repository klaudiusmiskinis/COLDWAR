package coldwar;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JTabbedPane;

public class PanelResumen extends JPanel {

	/**
	 * Create the panel.
	 */
	ArrayList <Paises> paisesCrea2 = new ArrayList() ;
	public PanelResumen(ArrayList <Paises> paisesCreados) {
		
		this.paisesCrea2=paisesCreados;
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 450, 300);
		add(panel);
		panel.setLayout(null);
		
		for(int i=0;i<paisesCreados.size();i++) {
			
		}
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(27, 57, 316, 138);
		panel.add(tabbedPane);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_1, null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_2, null);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_3, null);

	}
}
