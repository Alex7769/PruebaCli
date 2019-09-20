package clip;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import clip.bd.sql.BdSql;

public class propierties {
	
	public void readProperites () {		
		Properties p = new Properties();
		try {
			p.load(new FileReader("BD.properties"));
			
			String serverSQL = p.getProperty("serverName") ;
			String serverNoSql = p.getProperty("serverName2"); 
			
			if( serverSQL != null) {
				BdSql sql= new BdSql();
				String server = p.getProperty("serverName");
				String user = p.getProperty("userName");
				String pass = p.getProperty("pass");
				String port =p.getProperty("port");
				String bd =p.getProperty("basedatos");
				System.out.println("+++++++++"+pass);			
				sql.conectionMysql(user, pass, server, port, bd);
			}
			if(serverNoSql != null) {
				System.out.println("-----"+p.getProperty("serverName2"));
				System.out.println("------"+p.getProperty("userName2"));
				System.out.println("--------"+p.getProperty("pass2"));	
			}
		}catch (FileNotFoundException e) {
			System.out.println("no se encuentra archivo properties de conexion a la bd");
		}
		catch (IOException e) {
			e.getMessage();
		}
		
	}
}
