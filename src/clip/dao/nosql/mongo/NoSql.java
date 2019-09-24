package clip.dao.nosql.mongo;

import com.mongodb.Mongo;

import clip.DataBasePropierties;
import clip.bussines.dto.DtoConection;

public class NoSql {
	
	public void getConectionMongoDB() {   
		DataBasePropierties prop = new DataBasePropierties();
		DtoConection dto = prop.readPropertiesNoSql();		
		String server = dto.getServer();
		String port=dto.getPort();
		String collection =dto.getBd();
		
		try {
			Mongo mongo = new Mongo(server,Integer.parseInt(port));
			mongo.getDB("test");
			System.out.println("conctado a mongo");
		}catch (Exception e) {
			System.out.println("Error de conexion con mongo DB  "+e.getMessage());		
		}
		              
    }   

}
