package clip.json;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;




public class JsonTransaction {
	
	public void createJson( Integer userId ,String inputJson) {			
		JsonObject jsonObject = new JsonObject();			    	
	    try {	    		
	    	String idtransaction = UUID.randomUUID().toString();	//validar autenticidad	    	   	  		    
	    	jsonObject = new JsonParser().parse(inputJson).getAsJsonObject();
	    	jsonObject.addProperty("transaction_id", new String (idtransaction));	 	    
	    	
		    System.out.println("\n objeto json creado \n");		  
		    writeJson(jsonObject,userId);
		    		      
		} catch (Exception e) {
			System.out.println("ocurrio un error al crear el objeto Json: createJson   "+e.getMessage());
		}
		
	}
	
	public void writeJson(JsonObject json,int idUser) {
		System.out.println("escribiendo json");
		
		
		JSONArray array=new JSONArray();
		System.out.println("-----"+json);
    	array.put(json);	 
    	System.out.println(array);
						
		if(idUser != 0 ) {
			String usuario = Integer.toString(idUser);
			try {
				File file= new File("trasaction_clip_"+usuario+".json");
				if(!file.exists()) {
					FileWriter fileWrite = new FileWriter("trasaction_clip_"+usuario+".json");							
						
			    	System.out.println(array);
					fileWrite.write(array.toString());
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
			
			
			
//			Integer userId =  (Integer) jsonObject.get("userId");
//			Double amount = (Double) jsonObject.get("amount");
//			String description = (String) jsonObject.get("description");
//			String date = (String) jsonObject.get("date");
//			String transaction_id = (String) jsonObject.get("transaction_id");
				
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
