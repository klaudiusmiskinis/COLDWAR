package coldwar;

import java.sql.*;
import java.util.ArrayList;

public class BdConexion {

	private static final String USER = "DAW1_48257371J";
	private static final String PWD = "A48257371J";
	private static final String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe";
	//private static final String URL = "jdbc:oracle:thin:@oracle.ilerna.com:1521:xe";
	static Connection conexion =  null;
	ArrayList <Paises> paisesCreados = new ArrayList<Paises>();
	static String nombre = "";
	static String tipo = "";
	static int vida = 0;
	static int misiles = 0;

	public static void main(String[] args) throws SQLException {


		try {
			System.out.println("A");
			//DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());S
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(URL, USER, PWD);
			System.out.println("awp");
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect the database! ", e);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Statement st = conexion.createStatement();
			
			int idpartida = obtenerIdpartida();
			System.out.println(idpartida);
			//insertJugadores(idpartida,nombre,tipo,vida,misiles);


		}catch(Exception e) {
			System.out.println("FCK OFF MATE");
			System.out.println(e.getMessage());
		}	
	}
	public static void guardarDatos (ArrayList <Paises> paisesCreados,String nombre,int ronda) throws SQLException, ClassNotFoundException {

			insertPartida(nombre,ronda);
		for (int i = 0; i < paisesCreados.size();i++) {
			nombre = paisesCreados.get(i).getNombre();
			tipo = paisesCreados.get(i).getTipo();
			vida = paisesCreados.get(i).getVida();
			misiles = paisesCreados.get(i).getMisiles();
			int idpartida = obtenerIdpartida();
			insertJugadores(idpartida,nombre,tipo,vida,misiles);
		}
	}
	
	public static void insertPartida(String nombre, int ronda) throws SQLException {
		try {
		String insertTabla = "INSERT INTO partida (ronda,nombre) VALUES (?,?)";
			PreparedStatement insert = conexion.prepareStatement(insertTabla);
		insert.setInt(1,ronda);
		insert.setString(2,nombre);
		insert.executeUpdate();
		}catch(Exception e) {
			System.out.println("FCK OFF MATE");
			System.out.println(e.getMessage());
		}	
	}

	public static void insertJugadores(int idpartida,String nombre, String tipo, int vida, int misiles) throws SQLException {
		String insertTabla = "INSERT INTO jugadores VALUES (?,?,?,?,?)";

		PreparedStatement insert = conexion.prepareStatement(insertTabla);
		insert.setInt(1,idpartida);
		insert.setString(2,nombre);
		insert.setString(3,tipo);
		insert.setInt(4,vida);
		insert.setInt(5,misiles);
		insert.executeUpdate();
	}

	public static int obtenerIdpartida() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conexion = DriverManager.getConnection(URL, USER, PWD);
		Statement st = conexion.createStatement();
		int codigo = 0;
		System.out.println("g");
		ResultSet rs = st.executeQuery("SELECT LAST_VALUE(idpartida)OVER (ORDER BY idpartida ROWS BETWEEN CURRENT ROW AND 1 FOLLOWING) AS last_idpartida FROM partida");
		while(rs.next()) {
			codigo = rs.getInt("last_idpartida");
		}

		return codigo;
	}
	

}
