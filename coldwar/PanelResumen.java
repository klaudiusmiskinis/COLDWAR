package coldwar;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.*;



public class PanelResumen extends JPanel implements ActionListener{

	ArrayList <Paises> paisesCreados = new ArrayList<Paises>() ;
	JTextPane texto, titulo;
	JButton bRonda;
	int turno = 0;
	public PanelResumen(ArrayList <Paises> paisesCreados) {

		this.paisesCreados = paisesCreados;
		setLayout(null);
		setBounds(0,0,1080,768);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1080,768);
		panel.setLayout(null);
		add(panel);

		texto= new JTextPane();
		texto.setBounds(173, 197, 632, 258);
		panel.add(texto);

		bRonda = new JButton("Siguiente ronda\r\n");
		bRonda.setBounds(910, 708, 117, 23);
		bRonda.addActionListener(this);
		panel.add(bRonda);

		titulo = new JTextPane();
		titulo.setText("Resumen de esta ronda");
		titulo.setBounds(206, 33, 533, 92);
		panel.add(titulo);

		for(int i=0;i<paisesCreados.size();i++) {
		}
		for(int i = 0; i < paisesCreados.size(); i++) {
			String resumen = "Nombre : " + paisesCreados.get(i).getNombre() + "\nVida : " + paisesCreados.get(i).getVida()+ "\n";
			System.out.println(resumen);
			resumen = resumen + texto.getText();
			texto.setText("\n" + resumen);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bRonda) {
			System.out.println("A");
			JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.getContentPane().add(new PanelPartida(paisesCreados,turno));
			marco.setVisible(true);
		}
		
		
		
	}
}