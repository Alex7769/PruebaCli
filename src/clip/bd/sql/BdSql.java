package clip.bd.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class BdSql {
	
	public void conectionMysql(String user,String pass,String server ,String port,String basedatos) {
		Connection conn = null;		
		try {		    
			Class.forName("com.mysql.jdbc.Driver"); 
		    String url = "jdbc:mysql://"+server+":"+port+"/?user="+user+"&password="+ pass;	
		    System.out.println(url+"  -----------------");
		    conn = DriverManager.getConnection(url);	
		    //Statement   s = (Statement) conn.createStatement();
            //int result = s.executeUpdate("CREATE DATABASE databasename");
		} catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            e.getCause();
        
		} finally {
		    try{
		           if(conn  != null)
		             conn.close();
		    }catch(SQLException ex){
		           System.out.println(ex.getMessage());
		    }
		}

	}
}
