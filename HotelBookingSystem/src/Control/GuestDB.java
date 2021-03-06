package Control;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import Model.Login;
import Model.Guest.GuestBooking;
import Model.Guest.GuestInfo;

public class GuestDB extends Connection {

	@Override
	public DBCollection getCollection(String collection) {
		return super.getCollection(collection);
	}
	
	// -----------------------------------------------------------------------------
	
	// Login
	
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
	
	
	
}
