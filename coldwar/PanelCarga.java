package coldwar;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import java.awt.Toolkit;

public class PanelCarga extends JWindow  {

	static boolean isRegistered;
	private static JProgressBar progressBar = new JProgressBar();
	private static PanelCarga execute;
	private static int count;
	private static Timer timer1;

	public PanelCarga() throws IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PanelCarga.class.getResource("/coldwar/assets/fondos/Fondo_Menu.png")));

		Container container = getContentPane();
		container.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new javax.swing.border.EtchedBorder());
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0,0,1080,768);
		panel.setLayout(null);
		container.add(panel);

		JLabel lblColdwar = new JLabel("");
		lblColdwar.setIcon(new ImageIcon(PanelCarga.class.getResource("/coldwar/assets/textos/Coldwar_texto.png")));
		lblColdwar.setFont(new Font("Verdana", Font.BOLD, 14));
		lblColdwar.setBounds(316, 56, 589, 330);
		panel.add(lblColdwar);
		progressBar.setForeground(new Color(255, 51, 0));
		progressBar.setBounds(0, 560, 1080, 27);
		panel.add(progressBar);

		progressBar.setMaximum(50);

		JLabel loading = new JLabel("");
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/coldwar/assets/loading.gif"));
		loading.setIcon(icon);
		loading.setBounds(451, 348, 156, 144);
		panel.add(loading);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PanelCarga.class.getResource("/coldwar/assets/fondos/Fondo_Menu.png")));
		lblNewLabel.setBounds(0, 0, 1080, 768);
		panel.add(lblNewLabel);
		loadProgressBar();
		setSize(1080,768);
		setLocationRelativeTo(null);
		setVisible(true);
	}


	private void loadProgressBar() { 
		ActionListener al = new ActionListener() { 

			public void actionPerformed(java.awt.event.ActionEvent evt) { 
				boolean cerrar = false;
				
				count++; 

				progressBar.setValue(count); 

				System.out.println(count); 

				if (count == 55) { 
					timer1.stop(); 
					Menu window;
					try {

						window = new Menu();
						window.setVisible(true);
						cerrar = true;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} 
			} 
		};
		
		timer1 = new Timer(50, al); 
		timer1.start(); 
		
	} 
	public static void main(String[] args) throws IOException{
		PanelCarga vent= new PanelCarga();
		vent.setVisible(true);

	

	}
};