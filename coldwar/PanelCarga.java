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
		lblColdwar.setBounds(251, 58, 589, 330);
		panel.add(lblColdwar);
		progressBar.setForeground(new Color(139, 0, 0));
		progressBar.setBounds(88, 570, 887, 39);
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

	private void loadProgressBar() throws IOException {
		ActionListener al = new ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent evt) {
				count++;

				progressBar.setValue(1);
				progressBar.setMaximum(1);

				System.out.println(count);

				if (count == 1) {

					createFrame();

					execute.setVisible(false);//swapped this around with timer1.stop()

					timer1.stop();

				}

			}

			private void createFrame() throws HeadlessException {
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);

			}
		};
		timer1 = new Timer(100, al);
		timer1.start();
		Menu window = new Menu();
		window.setResizable(false);
	}

	public static void main(String[] args) throws IOException{
		execute = new PanelCarga();

	}
};