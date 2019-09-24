package clip;

import clip.dao.json.JsonTransaction;
import clip.dao.sql.BdSql;

public class Principale {

	public static void main(String[] args) {
		JsonTransaction json = new JsonTransaction();
		
		json.createJson(345, "{ \"amount\": 1.23, \"description\": \"Joes Tacos\", \"date\":\"2018-12-30\", \"user_id\": 345 }");
		
		BdSql bd = new BdSql();
		bd.implementDbMysql();

//		
//		Transactions transaction = new Transactions();
//		System.out.print("./application ");
//		
//		Scanner sc = new Scanner(System.in);
//		Integer cadena = sc.nextInt();
//		String cadena1 = sc.next();
//		String cadena2 = sc.nextLine();
//		//{ "amount": 1.23, "description": "Joes Tacos", "date":"2018-12-30", "user_id": 345 }
//		
//		switch (cadena1) {
//		case ("add"):
//			cadena2.replace("\"", " \\ \" ");
//			transaction.add(cadena,cadena2);			
//			break;
//			
//		case("list"):
//			System.out.println("list");
//			break;
//		case("sum"):
//			System.out.println("sum");
//			break;
//		
//		default:
//			System.out.println("otro caso");
//			break;
//		}								 					   			
//		sc.close();
		
	}

}
