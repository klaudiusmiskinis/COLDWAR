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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PanelGanador extends JPanel implements ActionListener {
	ArrayList <Paises> paisesCreados = new ArrayList<Paises>() ;

	JButton botonAdelante;
	public PanelGanador(ArrayList <Paises> paisesCreados) {
		int contaWin = 0;
		Paises ganador= new Paises();
		this.paisesCreados=paisesCreados;
		
		setBounds(0,0,1080,768);
		setBackground(Color.BLACK);
		setLayout(null);

		botonAdelante = new JButton ();
		botonAdelante.setIcon(new ImageIcon(PanelReglas.class.getResource("/coldwar/assets/iconos/ADELANTE.png")));
		botonAdelante.setOpaque(false);
		botonAdelante.setContentAreaFilled(false);
		botonAdelante.setBounds(489, 668, 89, 59);
		botonAdelante.setFocusable(false);
		botonAdelante.setBorderPainted(false);
		botonAdelante.addActionListener(this);
		add(botonAdelante);

		for(int i =0;i<paisesCreados.size();i++) {
			if(paisesCreados.get(i).getVida()>0) {
				ganador=paisesCreados.get(i);
				contaWin++;
			}
		}
		if(contaWin==1) {
			JTextPane txtpnElGanadorEs = new JTextPane();
			txtpnElGanadorEs.setForeground(new Color(255, 51, 0));
			txtpnElGanadorEs.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 50));
			txtpnElGanadorEs.setText(ganador.getNombre());
			txtpnElGanadorEs.setBounds(394, 237, 293, 59);
			txtpnElGanadorEs.setOpaque(false);
			txtpnElGanadorEs.setFocusable(false);
			add(txtpnElGanadorEs);

			JLabel recuadro = new JLabel("");
			recuadro.setIcon(new ImageIcon(PanelReglas.class.getResource("/coldwar/assets/fondos/PanelGanador.png")));
			recuadro.setBounds(0,0,1080,768);
			add(recuadro);
		}
		else {
			JLabel recuadro = new JLabel("");
			recuadro.setIcon(new ImageIcon(PanelReglas.class.getResource("/coldwar/assets/fondos/PanelEmpate.png")));
			recuadro.setBounds(0,0,1080,768);
			add(recuadro);
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonAdelante) {
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



