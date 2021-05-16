package coldwar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CargaPartida extends JPanel implements ActionListener {

	// ATRIBUTOS
	JLabel fondo;
	JButton atras,cargarPartida;
	JComboBox<String> desplegable;
	JTextPane jugadores; 
	String datos = "";
	int idpartida = 0;
	ArrayList <String> datosCarga = new ArrayList<String>();
	ArrayList <String> datosJugadores = new ArrayList<String>();
	ArrayList<Paises> paisesJugar = new ArrayList<Paises>();
	int [] codigoPartidas = new int[100];

	public CargaPartida() throws SQLException, ClassNotFoundException {
		setBounds(0,0,1080,768);
		setLayout(null);


		//BOTON ATRAS
		atras = new JButton();
		atras.setForeground(Color.WHITE);
		atras.setBounds(10, 672, 91, 59);
		atras.addActionListener(this);
		atras.setIcon(new ImageIcon(PanelReglas1.class.getResource("/coldwar/assets/iconos/ATRAS_boton.png")));
		atras.setOpaque(false);
		atras.setContentAreaFilled(false);
		atras.setBorderPainted(false);
		atras.setFocusable(false);
		add(atras);

		//COMBOBOX DESPLEGABLE
		desplegable = new JComboBox<String>();
		desplegable.setForeground(Color.WHITE);
		desplegable.setBackground(Color.BLACK);
		desplegable.setBorder(new LineBorder(Color.BLACK));
		desplegable.setFocusable(false);
		desplegable.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		desplegable.setMaximumRowCount(10);
		desplegable.setBounds(297, 346, 284, 34);
		desplegable.addActionListener(this);
		add(desplegable);

		cargarPartida = new JButton("Cargar partida\r\n");
		cargarPartida.setBounds(398, 276, 136, 23);
		cargarPartida.addActionListener(this);
		add(cargarPartida);

		//FONDO JLABEL
		fondo = new JLabel();
		fondo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/coldwar/assets/fondos/FondoNegro_Menu.png")));
		fondo.setBackground(Color.BLACK);
		fondo.setBounds(0,0,1080,768);
		add(fondo);


		BdConexion.conexion();
		datosCarga = BdConexion.cargarPartida();
		codigoPartidas = BdConexion.cargarIdpartida();

		for (int i = 0; i < datosCarga.size();i++) {
			datos = datosCarga.get(i);
			desplegable.addItem(datos);
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cargarPartida) {

			try {
				idpartida = (codigoPartidas[desplegable.getSelectedIndex()]);
				datosJugadores = BdConexion.cargarJugadores(idpartida);
				for (int i = 0; i < datosJugadores.size();i++) {
					Paises pais = new Paises();
					for (int f = 0;f < 5; f++) {
						String[] parts = datosJugadores.get(i).split(",");
						pais.setNombre(parts[1]);
						pais.setTipo(parts[2]);
						pais.setVida(Integer.parseInt(parts[3]));
						pais.setMisiles(Integer.parseInt(parts[4]));
					}
					paisesJugar.add(pais);
				}				

				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
				marco.remove(this);
				marco.getContentPane().add(new PanelPartida(paisesJugar,0,""));
				marco.setVisible(true);

			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}




















		if (e.getSource() == atras) {
			JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			try {
				marco.getContentPane().add(new MenuPrincipal());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			marco.setVisible(true);
		}
	}
}
