package clip.dao.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class JsonTransaction {

	public void createJson(Integer userId, String inputJson) {
		JsonObject jsonObject = new JsonObject();
		try {
			String idtransaction = UUID.randomUUID().toString(); // validar autenticidad
			
			jsonObject = new JsonParser().parse(inputJson).getAsJsonObject();
			jsonObject.addProperty("transaction_id", new String(idtransaction));

			System.out.println("\n objeto json creado \n");
			
			writeJson(jsonObject, userId);
			readJson(userId);
		} catch (Exception e) {
			System.out.println("ocurrio un error al crear el objeto Json: createJson   " + e.getMessage());
		}

	}

	public void writeJson(JsonObject json, int idUser) {
		System.out.println("escribiendo json");

		if (idUser != 0) {
			String usuario = Integer.toString(idUser);
			try {
				File file = new File("trasaction_clip_" + usuario + ".json");
				if (!file.exists()) {
					try (Writer writer = new FileWriter("trasaction_clip_" + usuario + ".json")) {
						Gson gson = new GsonBuilder().create();
						gson.toJson(addArray(json), writer);
					}
				} else {
					System.out.println("else");									
					
					
				}

			} catch (Exception e) {
				System.out.println("Error en  write json " + e.getCause());
			}
		} else {
			System.out.println("el idusuario no es valido, el valor de idUsuario es numerico");
		}

	}

	public void readJson(Integer idUser) {
		System.out.println(":::::::::::::::::::ReadJson");
		idUser = 345;
		String usuario = idUser.toString();				
		JSONParser parser = new JSONParser();
		try {
			Object object = parser.parse(new FileReader("trasaction_clip_" + usuario + ".json"));
			JSONObject jsonObject = (JSONObject)object;
			JSONArray array = (JSONArray) jsonObject.get("");
			for (Object js: array) {
				
				System.out.println("\t"+js.toString());
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		try {
//			String usuario = Integer.toString(idUser);
//			System.out.println("Reading JSON from a file");
//			System.out.println("----------------------------");
//
//			BufferedReader br = new BufferedReader(new FileReader("trasaction_clip_" + usuario + ".json"));
//			String str = null;
//			while ((str = br.readLine()) != null) {
//				System.out.println(str);
//			}
//			JsonParser jsonPars = new JsonParser();
//			jsonPars.parse(str);
//			
//
//			return jsonPars;
//		} catch (IOException e) {
//			System.out.println("no se puede leer el archivo json " + e.getMessage());
//		}
//		return null;

	}

	public JsonArray addArray(JsonObject json) {
		JsonArray jsonArr = new JsonArray();
		jsonArr.add(json);
		return jsonArr;
	}

}
