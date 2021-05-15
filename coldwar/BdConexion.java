package coldwar;

import java.sql.*;
import java.util.ArrayList;

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

	//MAIN
	/*
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Paises pruebaInsert = new Paises("algo", 200, 0,"Espanya", 0, 0);
		paisesCreados.add(pruebaInsert);
		pruebaInsert = new Paises("Nelson", 400, 0,"Lituania", 0, 0);
		paisesCreados.add(pruebaInsert);
		pruebaInsert = new Paises("Jose", 500, 0,"Francia", 0, 0);
		paisesCreados.add(pruebaInsert);
		pruebaInsert = new Paises("Friki", 100, 0,"Alemania", 0, 0);
		paisesCreados.add(pruebaInsert);
		pruebaInsert = new Paises("Minguito", 300, 0,"Suiza", 0, 0);
		paisesCreados.add(pruebaInsert)
		
		int codigo;
		codigo = obtenerIdpartida();
		System.out.println("Insertando jugadores.");
		for(int i = 0; i < paisesCreados.size(); i++) {
			insertJugadores(codigo, paisesCreados.get(i).getNombre(), paisesCreados.get(i).getTipo(), paisesCreados.get(i).getVida(), paisesCreados.get(i).getMisiles());
		}
		System.out.println("¡Insertados todos los jugadores!");
		con.close();
		System.out.println("Cerrando conexión.");
	}
*/
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

	static void guardarDatos(ArrayList <Paises> paisesCreados,String nombre,int ronda) throws SQLException, ClassNotFoundException {
		int idpartida = 0;
		insertPartida(nombre,ronda);
		for (int i = 0; i < paisesCreados.size();i++) {
			nombre = paisesCreados.get(i).getNombre();
			tipo = paisesCreados.get(i).getTipo();
			vida = paisesCreados.get(i).getVida();
			misiles = paisesCreados.get(i).getMisiles();
			System.out.println(idpartida + "AAAAAAAAAAAAAAAAAA");
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
			String insertTabla = "INSERT INTO partida (ronda,nombre) VALUES (?,?)";

			PreparedStatement insert = con.prepareStatement(insertTabla);
			insert.setInt(1, ronda);
			insert.setString(2, nombre);
			insert.executeUpdate();
		} catch(Exception e) {
			System.out.println(e);
		}	
	}

	private static void insertJugadores(int idpartida,String nombre, String tipo, int vida, int misiles) throws SQLException {
		String insertTabla = "INSERT INTO jugadores VALUES (?,?,?,?,?)";
		PreparedStatement insert = con.prepareStatement(insertTabla);

		insert.setInt(1,idpartida);
		insert.setString(2,nombre);
		insert.setString(3,tipo);
		insert.setInt(4,vida);
		insert.setInt(5,misiles);
		insert.executeUpdate();
	}


}

