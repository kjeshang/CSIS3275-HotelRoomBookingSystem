package DAO;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import Model.Login;
import Model.Admin.AdminInfo;


public class AdminDB extends Connection {

	@Override
	public DBCollection getCollection(String collection) {
		return super.getCollection(collection);
	}
	

	
	// Admin Login
	
	public boolean checkIfExists(String adminLogin) {
		boolean status = false;
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("username", adminLogin);

		DBCursor cursor = getCollection("Admin_Login").find(whereQuery);
		while(cursor.hasNext()) {
			if(cursor.next().toString().equals("")) {
				status = false;
			}
			else {
				status = true;
			}
		}
		return status;
	}
	
	public void insertAdminLogin(Login login) {
		getCollection("Admin_Login").insert(createAdminLogin(login));
	}
	
	private BasicDBObject createAdminLogin(Login login) {
		BasicDBObject doc = new BasicDBObject("username",login.getUsername());
		doc.append("password", login.getPassword());
		return doc;
	}
	
	// ------------------------------------------------------------------------------
	
	// Info
	
	public void insertAdmin(AdminInfo adminInfo) {
		getCollection("Admin").insert(createAdminInfo(adminInfo));
	}
	
	private BasicDBObject createAdminInfo(AdminInfo adminInfo) {
		BasicDBObject doc = new BasicDBObject("firstName",adminInfo.getFirstName());
		doc.append("lastName",adminInfo.getLastName());
		doc.append("address",adminInfo.getAddress());
		doc.append("email",adminInfo.getEmail());
		doc.append("phone",adminInfo.getPhone());
		return doc;
	}
		
	public String findAdmin(AdminInfo adminInfo) {
		String admin = "";
		BasicDBObject query = getAdmin(adminInfo);
		DBCursor cursor = getCollection("Guest").find(query);
		admin = cursor.next().toString();
		return admin;
	}
	
	private BasicDBObject getAdmin(AdminInfo adminInfo) {
		BasicDBObject andQuery = new BasicDBObject();
	    List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
	    obj.add(new BasicDBObject("firstName", adminInfo.getFirstName()));
	    obj.add(new BasicDBObject("lastName", adminInfo.getLastName()));
	    obj.add(new BasicDBObject("email", adminInfo.getEmail()));
	    obj.add(new BasicDBObject("phone", adminInfo.getPhone()));
	    andQuery.put("$and", obj);
	    return andQuery;
	}
	
	
	
}
