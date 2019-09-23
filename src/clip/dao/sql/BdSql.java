package clip.dao.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import clip.DataBasePropierties;
import clip.bussines.dto.DtoConection;



public class BdSql {
	
	public Connection getConnection() {
	DataBasePropierties prop = new DataBasePropierties();
	prop.readProperitesSql();
	DtoConection dtoConec= new DtoConection();
	dtoConec.getServer();
	dtoConec.getUser();
	dtoConec.getPass();
	dtoConec.getPort();
	dtoConec.getBd();
	System.out.println("{------"+dtoConec.getServer());
				
		Connection conn = null;
		try {		    
			Class.forName("com.mysql.jdbc.Driver"); 
		    String url = "jdbc:mysql://"+dtoConec.getServer()+":"+dtoConec.getPort()+"/?user="+dtoConec.getUser()+"&password="+ dtoConec.getPass()+"&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";	
		    System.out.println(url+"  -----------------");
		    conn = DriverManager.getConnection(url);
		    return conn;
		} catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error al conectar con la base de datos mysql");    
		} 
		return null;
	}
//	public void createDB() {
//		Connection conn = getConnection();
//		PreparedStatement createDB = conn.prepareStatement("int Result=s.executeUpdate(\"CREATE DATABASE clipClients\"");
//		conn.close();
//	}
//	public void createTable() {
//		Connection conn = getConnection();
//		PreparedStatement ps = conn.prepareStatement("CREATE TABLE IF NOT EXISTS transactionClip(\r\n" + 
//				"userId int NOT NULL PRIMARY KEY,\r\n" + 
//				"transaction_id varchar(225) NOT NULL UNIQUE,\r\n" + 
//				"date_transaction varchar(225),\r\n" + 
//				"description_transaction varchar(50),\r\n" + 
//				"amount INT (10));");
//		ps.executeUpdate();
//		ps.close();
//	}
//	
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
//		insertTransactionQuery.execute();
//		
//	}
//	public void selectAllTransactionUser(Integer userId) {
//		String user= userId.toString();
//		String query = " select * from  transactionClip where userId='"+user+"'";
//		
//	}
}
