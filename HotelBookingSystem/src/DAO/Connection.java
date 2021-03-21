package DAO;




import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public abstract class Connection {
	
	String Database = "CSIS3275";
	

	public DBCollection getCollection(String collection) {
		@SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient("localhost",27017);
		@SuppressWarnings("deprecation")
		DB db = mongoClient.getDB(Database);
		DBCollection coll = db.getCollection(collection);
		return coll;
	}
}
