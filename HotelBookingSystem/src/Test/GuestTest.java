package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Control.GuestDB;
import Model.Details;
import Model.Guest.GuestBooking;
import Model.Guest.GuestInfo;

class GuestTest implements Details {
	
	static int testCount;
	
	static String firstName;
	static String lastName;
	static String address;
	static String email;
	static String phone;
	static String nationality;
	static String purposeOfStay;
	GuestInfo guestInfo;
	
	static int numPersons;
	static String roomType;
	static int roomNumber;
	static LocalDate checkInDate;
	static LocalDate checkOutDate;
	static boolean lunchAndDinner;
	static String addAccomodations;
	GuestBooking guestBooking;
	
	GuestDB guestDB;
	
	@BeforeAll
	static void setupAll() {
		System.out.println("Initializing Guest-related tests.");
		testCount = 1;
	}
	
	@BeforeEach
	void setup() {
		firstName = "Peter";
		lastName = "Parker";
		address = "Queens, New York, New York";
		email = "peter.parker@dailybugle.com";
		phone = "1234567890";
		nationality = "American";
		purposeOfStay = "Business";
		guestInfo = new GuestInfo(firstName,lastName,address,email,phone,nationality,purposeOfStay);
		numPersons = 1;
		roomType = ROOM_TYPE[0]; // Standard
		roomNumber = 100;
		checkInDate = LocalDate.now();
		checkOutDate = checkInDate.plus(1, ChronoUnit.DAYS);
		lunchAndDinner = false; // Lunch and dinner provided
		addAccomodations = ""; // No extra accommodations for room
		guestBooking = new GuestBooking(numPersons,roomType,roomNumber,checkInDate,checkOutDate,lunchAndDinner,addAccomodations);
		guestDB = new GuestDB();
	}
	
	@Test
	@DisplayName("Should create entity of guest background information with all valid paramters, and prove validity to be true")
	void shouldCreateGuestInfo() {
		assertTrue(guestInfo.getFirstName().equals("Peter"));
		assertTrue(guestInfo.getLastName().equals("Parker"));
		assertTrue(guestInfo.getAddress().equals("Queens, New York, New York"));
		assertTrue(guestInfo.getEmail().equals("peter.parker@dailybugle.com"));
		assertTrue(guestInfo.getPhone().equals("1234567890"));
		assertTrue(guestInfo.getNationality().equals("American"));
		assertTrue(guestInfo.getPurposeOfStay().equals("Business"));
		assertTrue(guestInfo.validInfo());
	}
	
	@Test
	@DisplayName("Prove invalidity of guest background information due to incorrect format of required parameters")
	void shouldNotCreateGuestInfo() {
		for(GuestInfo gi : invalidGuestInfoList()) {
			assertFalse(gi.validInfo());
		}
	}
	
	private List<GuestInfo> invalidGuestInfoList(){
		List<GuestInfo> list = new ArrayList<>();
		list.add(new GuestInfo("","","","","","","")); // 1
		list.add(new GuestInfo(firstName,lastName,"","","","","")); // 2
		list.add(new GuestInfo("","","","","",nationality,purposeOfStay)); // 3
		guestInfo.setEmail("pe"); // 4
		list.add(guestInfo);
		guestInfo.setEmail("peter.parkerdailybugle.com"); // 5
		list.add(guestInfo);
		guestInfo.setEmail("peter.parker@dailybugle"); // 6
		list.add(guestInfo);
		guestInfo.setEmail(email); // 7
		guestInfo.setPhone("123");
		list.add(guestInfo);
		return list;
	}
	
	@Test
	@DisplayName("Should create entity of guest booking information with all valid paramters, and prove validity to be true")
	void shouldCreateGuestBooking() {
		assertTrue(guestBooking.getNumPersons() == 1);
		assertTrue(guestBooking.getRoomType().equals(ROOM_TYPE[0]));
		assertTrue(guestBooking.getRoomNumber() == 100);
		assertTrue(guestBooking.getCheckInDate().compareTo(LocalDate.now()) == 0);
		assertTrue(guestBooking.getCheckOutDate().compareTo(guestBooking.getCheckInDate().plus(1, ChronoUnit.DAYS)) == 0);
		assertTrue(guestBooking.isLunchAndDinner() == false);
		assertTrue(guestBooking.getAddAccomodations().equals(""));
		assertTrue(guestBooking.getLengthOfStay() == 1);
		assertTrue(guestBooking.getTotalCost() == 50);
		assertTrue(guestBooking.validBooking());
	}
	
	@Test
	@DisplayName("Prove invalidity of guest booking information due to incorrect format of required parameters")
	void shouldNotCreateGuestBooking() {
		for(GuestBooking gb : invalidGuestBookingList()) {
			assertFalse(gb.validBooking());
		}
	}
	
	private List<GuestBooking> invalidGuestBookingList(){
		List<GuestBooking> list = new ArrayList<>();
		list.add(new GuestBooking(0,ROOM_TYPE[0],0,LocalDate.now(),LocalDate.now(),false,"")); // 1
		guestBooking.setNumPersons(0); // 2
		list.add(guestBooking);
		guestBooking.setNumPersons(1); // 3
		guestBooking.setCheckInDate(LocalDate.now());
		guestBooking.setCheckOutDate(LocalDate.now().minus(-1,ChronoUnit.DAYS));
		list.add(guestBooking);
		guestBooking.setCheckInDate(checkInDate); // 4
		guestBooking.setCheckOutDate(checkOutDate);
		guestBooking.setRoomType(ROOM_TYPE[1]); // 5
		list.add(guestBooking);
		return list;
	}
	
	@Test
	@DisplayName("Should correctly check whether or not guest (i.e. guest background information & reservation) exists in database, sucessfully insert guest if it does not exist, and delete sucessfully from database")
	void shouldInteractWithDBCorrectlyGuest() {
		assertFalse(guestDB.checkIfReservationExists(guestBooking));
		guestDB.insertGuest(guestInfo, guestBooking);
		assertTrue(guestDB.checkIfReservationExists(guestBooking));
		guestDB.deleteRecord(guestInfo.getPhone());
		assertFalse(guestDB.checkIfReservationExists(guestBooking));
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("Guest Test " + testCount + " completed.");
		testCount++;
	}
	
	@AfterAll
	static void tearDownAll() {
		System.out.println("Finished all Guest-related tests.");
	}

}
