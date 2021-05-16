package coldwar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;



public class PanelResumen extends JPanel implements ActionListener{

	ArrayList <Paises> paisesCreados = new ArrayList<Paises>() ;
	ArrayList <String> historials = new ArrayList <String>();
	String story=" ";
	JButton bRonda,bGuardar;
	JLabel fondo;
	JTextPane texto;
	int turno = 0;
	int contadorVidas=0;
	String guardar =" ";

	public PanelResumen(ArrayList <Paises> paisesCreados,String story) {

		this.paisesCreados = paisesCreados;
		this.story = story;

		setLayout(null);
		setBounds(0,0,1080,768);

		bRonda = new JButton ();
		bRonda.setIcon(new ImageIcon(PanelReglas.class.getResource("/coldwar/assets/iconos/ADELANTE.png")));
		bRonda.setOpaque(false);
		bRonda.setContentAreaFilled(false);
		bRonda.setBounds(897, 587, 89, 59);
		bRonda.setFocusable(false);
		bRonda.setBorderPainted(false);
		bRonda.addActionListener(this);
		add(bRonda);

		texto= new JTextPane();
		texto.setBackground(Color.BLACK);
		texto.setForeground(Color.WHITE);
		texto.setBounds(224, 113, 632, 529);
		texto.setEditable(false);
		texto.setText(story);
		add(texto);

		String resumen=" ";

		for(int i = 0; i < paisesCreados.size(); i++) {

			if(paisesCreados.get(i).getVida()<0) {
				paisesCreados.get(i).setVida(0);
			}

			if(paisesCreados.get(i).getVida() == 0) {
				resumen = "\nEl pais : " + paisesCreados.get(i).getNombre() + " ha muerto."+ "\n";
				story =story + resumen;
			}else {
				resumen = "\nEl jugador " + paisesCreados.get(i).getNombre() + " tiene " + paisesCreados.get(i).getVida()+ " de vida\n";
				story =story + resumen;
			}
		}	

		StyledDocument doca = texto.getStyledDocument();
		SimpleAttributeSet centrar = new SimpleAttributeSet();
		StyleConstants.setAlignment(centrar, StyleConstants.ALIGN_CENTER);
		doca.setParagraphAttributes(0, doca.getLength(), centrar, false);
		texto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		texto.setText(story+"\n"+"\n"+"\n"+resumen);
		texto.setText(story);	

		fondo = new JLabel();
		fondo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/coldwar/assets/fondos/FondoPanelResumen.png")));
		fondo.setBackground(Color.WHITE);
		fondo.setBounds(0,0,1080,768);
		add(fondo);

		bGuardar = new JButton("");
		bGuardar.setBounds(652, 659, 344, 46);
		bGuardar.addActionListener(this);
		bGuardar.setFocusable(false);
		bGuardar.setContentAreaFilled(false);
		bGuardar.setOpaque(false);
		add(bGuardar);



		SimpleAttributeSet centrar1 = new SimpleAttributeSet();
		StyleConstants.setAlignment(centrar1, StyleConstants.ALIGN_CENTER);

		for(int i=0;i<paisesCreados.size();i++) {
			if(paisesCreados.get(i).getVida()>0) {
				contadorVidas++;
			}
		}
	}

	public void actionPerformed(ActionEvent e) {

		String nombre = "";
		boolean name;

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
			}else if(contadorVidas==1 || contadorVidas == 0) {
				System.out.println("B");
				JFrame marco=(JFrame) SwingUtilities.getWindowAncestor(this);
				marco.remove(this);
				marco.getContentPane().add(new PanelGanador(paisesCreados));
				marco.setVisible(true);
			}
		}
		if (e.getSource() == bGuardar) {
			do {
				Object[] options = {"Nombre del guardado"};
				JFrame parent = new JFrame();
				nombre = JOptionPane.showInputDialog(parent, options,"Jugador", 1);
			} while(nombre.equals(""));

			name = validarNombres(nombre);
			if (name == true) {
				try {
					System.out.println(nombre);
					System.out.println(PanelPartida.ronda);
					BdConexion.conexion();
					BdConexion.guardarDatos(paisesCreados,nombre,PanelPartida.ronda);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		}
	}


	//METODO PARA VALIDAR NOMBRES
	public boolean validarNombres(String name) {
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
		Matcher matcher = pattern.matcher(name);

		//CONTIENE SIMBOLOS
		if(matcher.find() == true) {
			JOptionPane.showMessageDialog(new JFrame(), "El nombre no puede contener símbolos y espacios", "ERROR",JOptionPane.ERROR_MESSAGE);
			return false;
		}

		//CONTIENE NUMEROS
		if (name.matches(".*\\d.*")) {
			JOptionPane.showMessageDialog(new JFrame(), "El nombre no puede contener números", "ERROR",JOptionPane.ERROR_MESSAGE);
			return false;
		}

		//EL NOMBRE ES DEMASIADO LARGO
		if (name.length() > 18) {
			JOptionPane.showMessageDialog(new JFrame(), "El nombre es demasiado largo", "ERROR",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
}