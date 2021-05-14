package coldwar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.*;



public class PanelResumen extends JPanel implements ActionListener{

	ArrayList <Paises> paisesCreados = new ArrayList<Paises>() ;
	ArrayList <String> historials = new ArrayList <String>();
	String story=" ";
	JTextPane texto, titulo;
	JButton bRonda;
	int turno = 0;
	int contadorVidas=0;
	String guardar =" ";
	public PanelResumen(ArrayList <Paises> paisesCreados,String story) {


		this.paisesCreados = paisesCreados;
		this.story = story;
		setLayout(null);
		setBounds(0,0,1080,768);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1080,768);
		panel.setLayout(null);
		add(panel);

		texto= new JTextPane();
		texto.setBackground(Color.BLACK);
		texto.setForeground(Color.WHITE);
		texto.setBounds(224, 113, 632, 529);
		panel.add(texto);

		bRonda = new JButton("Siguiente ronda\r\n");
		bRonda.setBounds(910, 708, 117, 23);
		bRonda = new JButton("");
		bRonda.setIcon(new ImageIcon(PanelPartida.class.getResource("/coldwar/assets/textos/ADELANTE_boton.png")));
		bRonda.setBounds(961, 643, 94, 53);
		bRonda.addActionListener(this);
		bRonda.setOpaque(false);
		bRonda.setContentAreaFilled(false);
		bRonda.setFocusable(false);
		bRonda.setBorderPainted(false);
		panel.add(bRonda);

		titulo = new JTextPane();
		titulo.setForeground(Color.RED);
		titulo.setBackground(Color.BLACK);
		titulo.setText("Resumen de esta ronda");
		titulo.setBounds(479, 33, 121, 34);
		panel.add(titulo);

		String resumen=" ";
		
		for(int i = 0; i < paisesCreados.size(); i++) {

			if(paisesCreados.get(i).getVida()<0) {
				paisesCreados.get(i).setVida(0);
			}
			if(paisesCreados.get(i).getVida() == 0) {
				resumen = "El pais : " + paisesCreados.get(i).getNombre() + " ha muerto."+ "\n";
				System.out.println(resumen);
				resumen = texto.getText() + resumen;
			}
			else {
				resumen = "\nEl jugador " + paisesCreados.get(i).getNombre() + " tiene " + paisesCreados.get(i).getVida()+ " de vida\n";
				System.out.println(resumen);
				story =story + resumen;
				System.out.println("PMC2");
			}
		}

		texto.setText(story);
		System.out.println("MONOL "+ story +"\n"+ resumen);

		for(int w=0;w<paisesCreados.size();w++) {
			if(paisesCreados.get(w).getVida()>0) {
				contadorVidas++;
			}
		}
	}
	public void actionPerformed(ActionEvent e) {



		if (e.getSource() == bRonda) {
			guardar=guardar+story;
			story=" ";
			if(contadorVidas>1) {
				System.out.println("A");
				JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
				marco.remove(this);
				marco.getContentPane().add(new PanelPartida(paisesCreados,turno,story));
				marco.setVisible(true);
				contadorVidas=0;


			}
			else if(contadorVidas==1) {
				System.out.println("B");
				JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
				marco.remove(this);
				marco.getContentPane().add(new PanelGanador(paisesCreados));
				marco.setVisible(true);
			}



		}
	}
}