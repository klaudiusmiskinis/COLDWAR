package coldwar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelReglas extends JPanel implements ActionListener{
	
	JButton botonAtras;
	public PanelReglas() {
		setToolTipText("");
		setBorder(null);
		
		botonAtras = new JButton ("Atras");
		botonAtras.setBounds(10, 11, 89, 23);
		botonAtras.addActionListener(this);
		setLayout(null);
		add(botonAtras);
		
		JTextPane txtpnLituaniaPuntos = new JTextPane();
		txtpnLituaniaPuntos.setBounds(21, 70, 665, 83);
		txtpnLituaniaPuntos.setText("Lituania:\r\n240 puntos de vida\r\n50 misiles por ronda\r\nLos ataques que pare con los misiles de defensa, hay un 30% de probabilidad que devuelvas los misiles a tus atacantes. ( a cada uno de los misiles de forma independiente)");
		add(txtpnLituaniaPuntos);
		
		JTextPane txtpnRusia = new JTextPane();
		txtpnRusia.setText("Rusia : \r\n240 puntos de vida\r\n45 misiles por ronda\r\nAtaca el dobla a USA\r\nAtaca la mitad a Lituania");
		txtpnRusia.setBounds(21, 180, 665, 83);
		add(txtpnRusia);
		
		JTextPane txtpnUsaPuntos = new JTextPane();
		txtpnUsaPuntos.setText("USA :\r\n180 puntos de vida\r\n70 misiles por ronda\r\nAtaca el dobla a Rusia\r\nAtaca la mitad a Vietnam");
		txtpnUsaPuntos.setBounds(21, 290, 665, 83);
		add(txtpnUsaPuntos);
		
		JTextPane txtpnEspaa = new JTextPane();
		txtpnEspaa.setText("Espa\u00F1a :\r\n180 puntos de vida\r\n50 misiles por ronda\r\nCada ronda tiene un 10% de probabilidad de a\u00F1adir conseguir 40 puntos de vida extra");
		txtpnEspaa.setBounds(21, 400, 665, 83);
		add(txtpnEspaa);
		
		JTextPane txtpnVietnamPuntos = new JTextPane();
		txtpnVietnamPuntos.setText("Vietnam :\r\n130 puntos de vida\r\n60 misiles por ronda\r\nProbabilidad de esquivar del 50% (se esquiva cada uno de los misiles de forma independiente, por ejemplo, si le atacan con 50 misiles, puede ser que le impacten 37).");
		txtpnVietnamPuntos.setBounds(21, 510, 665, 83);
		add(txtpnVietnamPuntos);
		
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
