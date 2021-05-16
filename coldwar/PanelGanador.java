package coldwar;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PanelGanador extends JPanel implements ActionListener {
	ArrayList <Paises> paisesCreados = new ArrayList<Paises>() ;

	JButton volverBoton;
	public PanelGanador(ArrayList <Paises> paisesCreados) {
		int contaWin = 0;
		Paises ganador= new Paises();
		this.paisesCreados=paisesCreados;
		setBounds(0,0,1080,768);
		setBackground(Color.BLACK);
		setLayout(null);

		for(int i =0;i<paisesCreados.size();i++) {
			if(paisesCreados.get(i).getVida()>0) {
				ganador=paisesCreados.get(i);
				contaWin++;
			}
		}
		if(contaWin==1) {
		JTextPane txtpnElGanadorEs = new JTextPane();
		txtpnElGanadorEs.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 55));
		txtpnElGanadorEs.setText("EL GANADOR ES "+ ganador.getNombre()+"\nFELICIDADES.");
		txtpnElGanadorEs.setBounds(86, 156, 822, 185);
		add(txtpnElGanadorEs);

		volverBoton = new JButton("VOLVER AL MENU");
		volverBoton.setBounds(437, 572, 185, 45);
		volverBoton.addActionListener(this);
		add(volverBoton);
		}
		else {
			JTextPane txtpnElGanadorEs = new JTextPane();
			txtpnElGanadorEs.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 55));
			txtpnElGanadorEs.setText("Hay un empate, todos los paises estan destruidos. Ha sido una masacre. ");
			txtpnElGanadorEs.setBounds(86, 156, 822, 185);
			add(txtpnElGanadorEs);

			volverBoton = new JButton("VOLVER AL MENU");
			volverBoton.setBounds(437, 572, 185, 45);
			volverBoton.addActionListener(this);
			add(volverBoton);
			
		}
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == volverBoton) {
			JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			try {
				marco.getContentPane().add(new MenuPrincipal());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			marco.setVisible(true);
		}
	}
}





