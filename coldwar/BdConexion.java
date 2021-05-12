package coldwar;

	import java.sql.*;

public class BdConexion {
	
	private static final String USER = "DAW1_48257371J";
	private static final String PWD = "A48257371J";
	private static final String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe";
	//private static final String URL = "jdbc:oracle:thin:@oracle.ilerna.com:1521:xe";
	static Connection conexion =  null;
	
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
		insertPartida("AAAAA",5);
		insertJugadores("Algo","A",20,50);
		}catch(Exception e) {
			System.out.println("FCK OFF MATE");
			System.out.println(e.getMessage());
		}	
	}
	public static void insertPartida(String nombre, int ronda) throws SQLException {
		Statement st = conexion.createStatement();
		
		st.executeUpdate("INSERT INTO PARTIDA (nombre, ronda) " + "VALUES ('"+ nombre+"',"+ronda+")");
	}
	
	public static void insertJugadores(String nombre, String tipo, int vida, int misiles) throws SQLException {
		Statement st = conexion.createStatement();
		
		st.executeUpdate("INSERT INTO JUGADORES(nombre, tipo, vida, misiles) " + "VALUES ('"+ nombre+"','"+ tipo+"',"+vida+","+misiles+")");
	}
}
