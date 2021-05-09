package coldwar;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PanelGanador extends JPanel {
	ArrayList <Paises> paisesCreados = new ArrayList<Paises>() ;
	/**
	 * Create the panel.
	 */
	
	JButton volverBoton;
	public PanelGanador(ArrayList <Paises> paisesCreados) {
		
		Paises ganador= new Paises();
		this.paisesCreados=paisesCreados;
		setBounds(0,0,1080,768);
		setBackground(Color.BLACK);
		setLayout(null);
		
		for(int i =0;i<paisesCreados.size();i++) {
			if(paisesCreados.get(i).getVida()>0) {
				ganador=paisesCreados.get(i);
			}
			
		}
		
		
		JTextPane txtpnElGanadorEs = new JTextPane();
		txtpnElGanadorEs.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 55));
		txtpnElGanadorEs.setText("EL GANADOR ES "+ ganador.getNombre()+"\nFELICIDADES.");
		txtpnElGanadorEs.setBounds(86, 156, 822, 185);
		add(txtpnElGanadorEs);
		
		volverBoton = new JButton("VOLVER AL MENU");
		volverBoton.setBounds(437, 572, 185, 45);
		add(volverBoton);

	}
	
	public void actionPerformed(ActionEvent e) throws IOException {



		if (e.getSource() == volverBoton) {
			System.out.println("Volver");
			JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.getContentPane().add(new Menu());
			marco.setVisible(true);
			
			}
			
		}


	
	
}
