package clip;

import clip.json.jsonTransaction;

public class beggin {

	public static void main(String[] args) {
		propierties prop = new propierties();
		jsonTransaction json = new jsonTransaction();
				
		prop.readProperites();		
	    json.createJson();
		
	}

}
