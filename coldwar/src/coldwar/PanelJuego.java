package coldwar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelJuego extends JPanel implements ActionListener{
	
	JButton botonAtras;
	public PanelJuego() {
		setLayout(null);
		
		botonAtras = new JButton ("Atras");
		botonAtras.setBounds(10, 11, 89, 23);
		botonAtras.addActionListener(this);
		add(botonAtras);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DAW1\\eclipse-workspace\\coldwar\\src\\coldwar\\assets\\fondo.png"));
		lblNewLabel.setBounds(0,0,800,800);
		add(lblNewLabel);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonAtras) {
			JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.getContentPane().add(new MenuPrincipal());
			marco.setVisible(true);

		}
	}

}
