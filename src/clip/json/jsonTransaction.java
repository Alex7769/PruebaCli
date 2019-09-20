package clip.json;

import java.io.FileWriter;

import org.json.simple.JSONObject;

public class jsonTransaction {
	
	public JSONObject createJson() {
		JSONObject obj = new JSONObject();

	      try {
			obj.put("name", "foo");
			 obj.put("num", new Integer(100));
		      obj.put("balance", new Double(1000.21));
		      obj.put("is_vip", new Boolean(true));
		      System.out.print(obj);
		      writeJson(obj);
		      
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public void writeJson(JSONObject json) {
		//Write JSON file
        try (FileWriter file = new FileWriter("employees.json")) {
 
            file.write(json.toJSONString());
            file.flush();
            }catch (Exception e) {
				// TODO: handle exception
			}
	}
	
}
