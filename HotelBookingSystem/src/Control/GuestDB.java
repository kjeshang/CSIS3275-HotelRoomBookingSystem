package Control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mongodb.AggregationOptions;
import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import Model.Login;
import Model.Guest.GuestBooking;
import Model.Guest.GuestInfo;

/**
 * 
 * @author kunaljeshang
 * Extends connection class to connect to database, creates/opens hotel guest related collections, and appropriate query operations
 */
public class GuestDB extends Connection {

	@Override
	public DBCollection getCollection(String collection) {
		return super.getCollection(collection);
	}
	
	// -----------------------------------------------------------------------------
	
	// Login
	/**
	 * 
	 * @param guestLogin hotel guest username
	 * @param guestPassword hotel guest password
	 * @return true (if hotel guest login exists in Guest_Login collection), or false
	 */
	public boolean checkIfExists(String guestLogin, String guestPassword) {
		boolean status = false;
		BasicDBObject andQuery = new BasicDBObject();
		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("username",guestLogin));
		obj.add(new BasicDBObject("password",guestPassword));
		andQuery.put("$and",obj);
		DBCursor cursor = getCollection("Guest_Login").find(andQuery);
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
	
	public void insertGuestLogin(Login login) {
		getCollection("Guest_Login").insert(createGuestLogin(login));
	}
	
	private BasicDBObject createGuestLogin(Login login) {
		BasicDBObject doc = new BasicDBObject("username",login.getUsername());
		doc.append("password", login.getPassword());
		return doc;
	}
	
	public void deleteGuestLogin(Login login) {
		BasicDBObject andQuery = new BasicDBObject();
	    List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("username",login.getUsername()));
		obj.add(new BasicDBObject("password",login.getPassword()));
		andQuery.put("$and", obj);
		getCollection("Guest_Login").remove(andQuery);
	}
	
	// ------------------------------------------------------------------------------
	
	// Info
	
	public void insertGuest(GuestInfo guestInfo, GuestBooking guestBooking) {
		getCollection("Guest").insert(createGuestInfo(guestInfo,guestBooking));
	}
	
	private BasicDBObject createGuestInfo(GuestInfo guestInfo, GuestBooking guestBooking) {
		BasicDBObject doc = new BasicDBObject("firstName",guestInfo.getFirstName());
		doc.append("lastName",guestInfo.getLastName());
		doc.append("address",guestInfo.getAddress());
		doc.append("email",guestInfo.getEmail());
		doc.append("phone",guestInfo.getPhone());
		doc.append("nationality",guestInfo.getNationality());
		doc.append("purposeOfStay",guestInfo.getPurposeOfStay());
		doc.append("booking",createGuestBooking(guestBooking));
		return doc;
	}
	
	// ------------------------------------------------------------------------------
	
	// Booking
	
	private BasicDBObject createGuestBooking(GuestBooking guestBooking) {
		BasicDBObject doc = new BasicDBObject("numPersons",guestBooking.getNumPersons());
		doc.append("roomType",guestBooking.getRoomType());
		doc.append("roomNumber",guestBooking.getRoomNumber());
		doc.append("checkInDate",guestBooking.getCheckInDate());
		doc.append("checkOutDate",guestBooking.getCheckOutDate());
		doc.append("lunchAndDinner",guestBooking.isLunchAndDinner());
		doc.append("addAccomodations",guestBooking.getAddAccomodations());
		doc.append("lengthOfStay",guestBooking.getLengthOfStay());
		doc.append("totalCost",guestBooking.getTotalCost());
		return doc;
	}
	
	public boolean checkIfReservationExists(GuestBooking guestBooking) {
		boolean status = false;
		BasicDBObject query = getGuestBooking(guestBooking);
		DBCursor cursor = getCollection("Guest").find(query);
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
	
	private BasicDBObject getGuestBooking(GuestBooking guestBooking) {
		BasicDBObject andQuery = new BasicDBObject();
	    List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
	    obj.add(new BasicDBObject("booking.roomType",guestBooking.getRoomType()));
	    obj.add(new BasicDBObject("booking.roomNumber",guestBooking.getRoomNumber()));
	    obj.add(new BasicDBObject("booking.checkInDate",guestBooking.getCheckInDate()));
	    obj.add(new BasicDBObject("booking.checkOutDate",guestBooking.getCheckOutDate()));
	    andQuery.put("$and", obj);
	    return andQuery;
	}
	
	// ------------------------------------------------------------------------------
	
	// Guest
	
	public String findGuest(GuestInfo guestInfo) {
		String guest = "";
		BasicDBObject query = getGuest(guestInfo);
		DBCursor cursor = getCollection("Guest").find(query);
		guest = cursor.next().toString();
		return guest;
	}
	
	private BasicDBObject getGuest(GuestInfo guestInfo) {
		BasicDBObject andQuery = new BasicDBObject();
	    List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
	    obj.add(new BasicDBObject("firstName", guestInfo.getFirstName()));
	    obj.add(new BasicDBObject("lastName", guestInfo.getLastName()));
	    obj.add(new BasicDBObject("email", guestInfo.getEmail()));
	    obj.add(new BasicDBObject("phone", guestInfo.getPhone()));
	    andQuery.put("$and", obj);
	    return andQuery;
	}
	
	public Object[][] getBasicGuestInfo() {		
		DBObject jsonRow;
		DBCursor cursor = getCollection("Guest").find();
		String[] columns = {"firstName","lastName","email","phone"};
		int count = (int) getCollection("Guest").count();
		Object[][] guestsBasicInfo = new Object[count][columns.length];
		
		for (int i = 0; cursor.hasNext(); i ++)
		{
			jsonRow = cursor.next();
			System.out.println(jsonRow);
			for (int j = 0; j < columns.length; j++)
			{				
				guestsBasicInfo[i][j] = jsonRow.get(columns[j]);		    
			}	
		}		
		return guestsBasicInfo;
	}
	
	/**
	 * 
	 * @param phone hotel guest phone number
	 * @return array of hotel guests 
	 */
	public DBObject[] searchGuest(Object phone) {
		
		DBObject[] result = new DBObject[2];
		
		BasicDBObject GuestInfoQuery = new BasicDBObject();
		GuestInfoQuery.put("phone", phone);
				
        List<BasicDBObject> pipeline = Arrays.asList(
                new BasicDBObject()
                        .append("$group", new BasicDBObject()
                                .append("_id", "$phone")
                                .append("numPersons", new BasicDBObject()
                                        .append("$first", "$booking.numPersons")
                                )
                                .append("roomType", new BasicDBObject()
                                        .append("$first", "$booking.roomType")
                                )
                                .append("roomNumber", new BasicDBObject()
                                        .append("$first", "$booking.roomNumber")
                                )
                                .append("checkInDate", new BasicDBObject()
                                        .append("$first", "$booking.checkInDate")
                                )
                                .append("checkOutDate", new BasicDBObject()
                                        .append("$first", "$booking.checkOutDate")
                                )
                                .append("lunchAndDinner", new BasicDBObject()
                                        .append("$first", "$booking.lunchAndDinner")
                                )
                                .append("addAccomodations", new BasicDBObject()
                                        .append("$first", "$booking.addAccomodations")
                                )
                                .append("lengthOfStay", new BasicDBObject()
                                        .append("$first", "$booking.lengthOfStay")
                                )
                                .append("totalCost", new BasicDBObject()
                                        .append("$first", "$booking.totalCost")
                                )
                        )
        );
		AggregationOptions options = AggregationOptions.builder().build();
        
		//get Guest personal info
		Cursor cursor = getCollection("Guest").find(GuestInfoQuery);
		result[0] = cursor.next();
		
		//get Guest booking info
		cursor =  getCollection("Guest").aggregate(pipeline, options);
		result[1] = cursor.next();
		
		return result;
	}
	
	public void deleteRecord(String phone) {
		BasicDBObject deletequery = new BasicDBObject();
		deletequery.put("phone", phone);		
		getCollection("Guest").remove(deletequery);
	}
	
}
