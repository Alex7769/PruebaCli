package clip.bussines;

import clip.json.JsonTransaction;

public class Transactions {
		
	private JsonTransaction json = new JsonTransaction();
	
	public void add(Integer userId,String inputJson) {
		json.createJson(userId, inputJson);
	}
	
	public void list() {
		
	}
	
	public void sum() {
		
	}
	public void trasactionFound() {
		
	}

}
