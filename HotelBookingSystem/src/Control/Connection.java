package Control;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

/**
 * 
 * @author kunaljeshang
 * Initiate MongoDB connection, and creates/opens database
 */
public abstract class Connection {
	
	@SuppressWarnings({ "resource", "deprecation" })
	public DBCollection getCollection(String collection) {
		MongoClient mongoClient = new MongoClient("localhost",27017);
		DB db = mongoClient.getDB("CSIS3275");
		DBCollection coll = db.getCollection(collection);
		return coll;
	}
}
