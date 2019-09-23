package clip.json;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

@Component("json-transactions")
public class JsonTransaction {
	
	@SuppressWarnings("unchecked")
	public JSONObject createJson( Integer userId ,double amount,String description,String date) {
		
		JSONObject obj =new JSONObject();	    	
	      try {	    		
	    	
	    	String idtransaction = UUID.randomUUID().toString();	//validar autenticidad	    	
	    	obj.put("transaction_id",new String(idtransaction));
			obj.put("amount",new Double(amount));
			obj.put("description", new String(description));
		    obj.put("date", new String(date));
		    obj.put("userId", new Integer(userId));
		    
		    System.out.println("\n objeto json creado \n");
		    System.out.print(obj);
		    
		    writeJson(obj,userId);
		    		      
		} catch (Exception e) {
			System.out.println("ocurrio un error al crear el objeto Json: createJson");
		}
		return obj;
	}
	
	public void writeJson(JSONObject json,int idUser) {
		
		if(idUser != 0 ) {
			String usuario = Integer.toString(idUser);
			try {
				File file= new File("trasaction_clip"+usuario+".json");
				if(!file.exists()) {
					FileWriter fileWrite = new FileWriter("trasaction_clip_"+usuario+".json");	
					JSONArray  arrayJson = new JSONArray ();				
					arrayJson.add(json);
					fileWrite.write(json.toJSONString());
					fileWrite.flush();	
					fileWrite.close();
				}else {
					//modifi
				}				
			            
	            }catch (Exception e) {
					// TODO: handle exception
				}
		}else {
			System.out.println("el idusuario no es valido, el valor de idUsuario es numerico");
		}
		
	}
	
	public void readJson() {
		JSONParser parser = new JSONParser();
		try{
			Object obj = parser.parse(new FileReader("trasaction_clip.json"));
			 
			JSONObject jsonObject = (JSONObject) obj;
			
			Integer userId =  (Integer) jsonObject.get("userId");
			Double amount = (Double) jsonObject.get("amount");
			String description = (String) jsonObject.get("description");
			String date = (String) jsonObject.get("date");
			String transaction_id = (String) jsonObject.get("transaction_id");
				
		}catch(Exception ex){
			System.err.println("Error: "+ex.toString());
		}finally{
			
		}
}
	
	
//	public String validateUUID() {
//		
//		
//		String idtransaction = UUID.randomUUID().toString();	
//		
//		if(idtransaction ) {
//						
//		}else {
//			System.out.println("no se genero ningun id");
//		}
//		return idtransaction;
//		
//	} 
	
}
