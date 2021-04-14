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
