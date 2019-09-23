package clip;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import clip.bussines.dto.DtoConection;

public class DataBasePropierties {

	public DtoConection readProperitesSql() {
		Properties p = new Properties();
		DtoConection dtoConect = new DtoConection();
		try {
			p.load(new FileReader("BD.properties"));
			String serverSQL = p.getProperty("serverName");

			if (serverSQL != null) {				
				dtoConect.setServer(p.getProperty("serverName"));
				dtoConect.setUser(p.getProperty("userName"));
				dtoConect.setPass(p.getProperty("pass"));
				dtoConect.setPort(p.getProperty("port"));
				dtoConect.setBd(p.getProperty("basedatos"));
				return dtoConect;
			}

		} catch (FileNotFoundException e) {
			System.out.println("no se encuentra archivo properties de conexion a la bd");
		} catch (IOException e) {
			e.getMessage();
		}return null;

	}

	public void readPropertiesNoSql() {
		Properties p = new Properties();
		try {
			p.load(new FileReader("BD.properties"));
			String serverNoSql = p.getProperty("serverName2");
			if (serverNoSql != null) {
				System.out.println("-----" + p.getProperty("serverName2"));
				System.out.println("------" + p.getProperty("userName2"));
				System.out.println("--------" + p.getProperty("pass2"));
			}
		} catch (FileNotFoundException e) {
			System.out.println("no se encuentra archivo properties de conexion a la bd");
		} catch (IOException e) {
			e.getMessage();
		}

	}

}
