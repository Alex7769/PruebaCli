package clip.dao.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import clip.DataBasePropierties;
import clip.bussines.dto.DtoConection;

public class BdSql {

	public void implementDbMysql() {
		getConnection();
		createDB();
		createTable();
	}

	private Connection getConnection() {
		DataBasePropierties prop = new DataBasePropierties();
		DtoConection dto = prop.readProperitesSql();
		String server = dto.getServer();
		String user = dto.getUser();
		String pass = dto.getPass();
		String port = dto.getPort();

		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + server + ":" + port + "?user=" + user + "&password=" + pass
					+ "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			conn = DriverManager.getConnection(url);
			return conn;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error al conectar con la base de datos mysql");
		}
		return null;
	}

	private void createDB() {

		Connection conn = getConnection();
		Statement createDbStatement;
		try {
			createDbStatement = conn.createStatement();
			createDbStatement.execute("CREATE DATABASE Clip");
			System.out.println("Base de datos Clip creada");
			conn.close();
		} catch (SQLException e) {
			System.out.println("Base de datos ya creada");

		}

	}

	private static Connection getConnectionDB() {
		try {
		DataBasePropierties prop = new DataBasePropierties();
		DtoConection dto = prop.readProperitesSql();
		String server = dto.getServer();
		String user = dto.getUser();
		String pass = dto.getPass();
		String port = dto.getPort();
		String db = "Clip";
		
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + server + ":" + port + "/"+db+"?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";		
			return DriverManager.getConnection(url, user, pass);
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println("Erro de conexion a bd ya creada "+e.getMessage());
		}
		return null;
		
	}

	private void createTable() {
		Connection conn = getConnectionDB();
		Statement createDbStatement;
		try {
			createDbStatement = conn.createStatement();
			createDbStatement.execute(
					"CREATE TABLE IF NOT EXISTS transactionClip(\r\n" + "userId int NOT NULL PRIMARY KEY,\r\n"
							+ "transaction_id varchar(225) NOT NULL UNIQUE,\r\n" + "date_transaction varchar(225),\r\n"
							+ "description_transaction varchar(50),\r\n" + "amount INT (10));");
			conn.close();
			System.out.println("Tabla creada transactionClip");
			} catch (SQLException e) {
			System.out.println("ya estan creadas la tablas en base de datos clip");
		}

	}
	
//	public void insertRegister(DtoTransaction dto) {
//		Connection conn = getConnection();
//		String query = " insert into transactionClip (userId, transaction_id, date_transaction, description_transaction, amount)"
//		        + " values (?, ?, ?, ?, ?)";
//		PreparedStatement insertTransactionQuery = conn.prepareStatement(query);
//		insertTransactionQuery.setInt(1, dto.getUserId());
//		insertTransactionQuery.setString (2, dto.getTransaction_id());
//		insertTransactionQuery.setString (3, dto.getDate());
//		insertTransactionQuery.setString(4, dto.getDescription());
//		insertTransactionQuery.setDouble(5, dto.getAmount());
//	      // execute the preparedstatement
//		try {
//			insertTransactionQuery.execute();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	public void selectAllTransactionUser(Integer userId) {
//		String user= userId.toString();
//		String query = " select * from  transactionClip where userId='"+user+"'";
//		
//	}
}
