package coldwar;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JTextPane;

public class BdConexion {

	//ATRIBUTOS 
	//DATOS DE CONEXION
	private static final String USER = "DAW1_48257371J";
	private static final String PWD = "A48257371J";
	private static final String URLinterna = "jdbc:oracle:thin:@192.168.3.26:1521:xe";
	private static final String URLexterna = "jdbc:oracle:thin:@oracle.ilerna.com:1521:xe";

	//ATRIBUTOS PARA TRATAR CON DATOS
	private static ArrayList <Paises> paisesCreados = new ArrayList<Paises>();
	private static String nombre = "";
	private static String tipo = "";
	private static int vida = 0;
	private static int misiles = 0;

	//ATRIBUTO PARA ENLAZAR CONEXION
	private static Connection con;

	static Connection conexion() throws SQLException {
		try {
			System.out.println("Intentado conexion a url externa...");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URLexterna, USER, PWD);
			System.out.println("¡Conectado!");
		} catch (Exception error) {
			System.out.println("Intentado conexion a url interna...");
			con = DriverManager.getConnection(URLinterna, USER, PWD);
			System.out.println("¡Conectado!");
		}
		return con;
	}
	// METODO para guardar los datos en la base de datos
	static void guardarDatos(ArrayList <Paises> paisesCreados,String nombre,int ronda) throws SQLException, ClassNotFoundException {
		int idpartida = 0;
		insertPartida(nombre,ronda);
		for (int i = 0; i < paisesCreados.size();i++) {
			nombre = paisesCreados.get(i).getNombre();
			tipo = paisesCreados.get(i).getTipo();
			vida = paisesCreados.get(i).getVida();
			misiles = paisesCreados.get(i).getMisiles();
			idpartida = obtenerIdpartida();

			insertJugadores(idpartida,nombre,tipo,vida,misiles);
		}
	}

	private static int obtenerIdpartida() throws SQLException, ClassNotFoundException {
		int codigo = 0;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT LAST_VALUE(idpartida)OVER (ORDER BY idpartida ROWS BETWEEN CURRENT ROW AND 1 FOLLOWING) AS last_idpartida FROM partida");

		while(rs.next()) {
			codigo = rs.getInt("last_idpartida");
		}
		return codigo;
	}

	private static void insertPartida(String nombre, int ronda) throws SQLException {
		try {
			System.out.println("ASD");
			String insertTabla = "INSERT INTO partida (nombre,ronda) VALUES (?,?)";

			PreparedStatement insert = con.prepareStatement(insertTabla);
			insert.setString(1, nombre);
			insert.setInt(2, ronda);
			insert.executeUpdate();
		} catch(Exception e) {
			System.out.println(e);
		}	
	}

	static void insertJugadores(int idpartida,String nombre, String tipo, int vida, int misiles) throws SQLException {
		String insertTabla = "INSERT INTO jugadores VALUES (?,?,?,?,?)";
		PreparedStatement insert = con.prepareStatement(insertTabla);

		insert.setInt(1,idpartida);
		insert.setString(2,nombre);
		insert.setString(3,tipo);
		insert.setInt(4,vida);
		insert.setInt(5,misiles);
		insert.executeUpdate();
	}

	static ArrayList<String> cargarPartida() throws SQLException, ClassNotFoundException {
		ArrayList <String> datosCarga = new ArrayList<String>();
		int codigo = 0;
		String nombre = "";
		int ronda = 0;
		String datos = "";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM partida ORDER BY idpartida");

		while(rs.next()) {
			codigo = rs.getInt("idpartida");
			nombre = rs.getString("nombre");
			ronda = rs.getInt("ronda");
			datos = (codigo + " , " + nombre + " , " + ronda).toString();
			datosCarga.add(datos);
		}
		return datosCarga;
	}
	static int[] cargarIdpartida() throws SQLException, ClassNotFoundException {
		int [] codigo = new int[100];
		int i = 0;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT idpartida FROM partida");

		while(rs.next()) {
			codigo[i] = rs.getInt("idpartida");
			i++;
		}
		return codigo;
	}
	static ArrayList<String> cargarJugadores(int idpartida) throws SQLException, ClassNotFoundException {
		ArrayList <String> datosCarga = new ArrayList<String>();
		int codigo = 0;
		String nombre = "";
		int vida = 0;
		String tipo = "";
		int misiles = 0;
		String datos = "";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM Jugadores WHERE idpartida = '" + idpartida + "' ORDER BY idpartida");

		while(rs.next()) {
			codigo = rs.getInt("idpartida");
			nombre = rs.getString("nombre");
			tipo = rs.getString("tipo");
			vida = rs.getInt("vida");
			misiles = rs.getInt("misiles");
			datos = (codigo + "," + nombre + "," + tipo + "," + vida +  "," + misiles).toString();
			datosCarga.add(datos);
		}
		return datosCarga;
	}

}

