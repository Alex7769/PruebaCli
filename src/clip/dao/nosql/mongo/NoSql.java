package clip.dao.nosql.mongo;

import com.mongodb.Mongo;

public class NoSql {
	public static void main(String[] args) {        
		try {
			Mongo mongo = new Mongo("localhost",27017);
			mongo.getDB("test");
			System.out.println("conctado a mongo");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
               
    }   

}
