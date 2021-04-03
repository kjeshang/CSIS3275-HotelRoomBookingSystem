package Model.Guest;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import Model.Details;

public class GuestBooking implements Details {
	
	private int numPersons; // i.e. Size of Reservation
	private String roomType;
	private int roomNumber;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private boolean lunchAndDinner; // Note - Breakfast inclusive
	private String addAccomodations; // i.e. Additional Accommodations
	
	private int lengthOfStay;
	private double totalCost;
	
	public GuestBooking(int numPersons, String roomType, int roomNumber, LocalDate checkInDate, LocalDate checkOutDate, boolean lunchAndDinner, String addAccomodations) {
		setNumPersons(numPersons);
		setRoomType(roomType);
		setRoomNumber(roomNumber);
		setCheckInDate(checkInDate);
		setCheckOutDate(checkOutDate);
		setLunchAndDinner(lunchAndDinner);
		setAddAccomodations(addAccomodations);
		setLengthOfStay();
		setTotalCost();
	}
	
	// *************************************************************
	
	public int getNumPersons() {
		return numPersons;
	}
	public void setNumPersons(int numPersons) {
		this.numPersons = numPersons;
	}
	
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public LocalDate getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}
	
	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
	public boolean isLunchAndDinner() {
		return lunchAndDinner;
	}
	public void setLunchAndDinner(boolean lunchAndDinner) {
		this.lunchAndDinner = lunchAndDinner;
	}
	
	public String getAddAccomodations() {
		return addAccomodations;
	}
	public void setAddAccomodations(String addAccomodations) {
		this.addAccomodations = addAccomodations;
	}
	
	// ***************************************************************
	
	public int getLengthOfStay() {
		return lengthOfStay;
	}

	public void setLengthOfStay() {
		this.lengthOfStay = calculateLengthOfStay();
	}
	
	private int calculateLengthOfStay() {
		long daysBetween = ChronoUnit.DAYS.between(getCheckInDate(), getCheckOutDate()); 
		int days = (int) daysBetween; 
		return days;
	}
	
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost() {
		this.totalCost = calculateTotalCost();
	}
		
	private double calculateTotalCost() {
		double perDayCost = 0;
		double totalCost = 0;
		String room = getRoomType();
		for(int i = 0; i < ROOM_TYPE.length; i++) {
			if(room.equals(ROOM_TYPE[i])) {
				perDayCost += ROOM_COST[i];
			}
		}
		if(isLunchAndDinner() == true) {
			perDayCost += LUNCH_DINNER_COST;
		}
		if(!getAddAccomodations().equals("")) {
			perDayCost += ACCOMODATION_COST;
		}
		if(getNumPersons() > NUMPERSONS_LIMIT) {
			perDayCost += NUMPERSONS_EXTRACHARGE;
		}
		totalCost = perDayCost * getLengthOfStay();
		return totalCost;
	}
	
	// ***************************************************************
	
	public boolean validBooking() {
		boolean status = false;
		if(getNumPersons() < 1 || getLengthOfStay() <= 0 || checkRoomTypeAndNumber() == false) {
			status = false;
		}
		else {
			status = true;
		}
		return status;
	}
	
	private boolean checkRoomTypeAndNumber() {
		boolean status = false;
		if(getRoomNumber() < 1) {
			status = false;
		}
		else {
			for(int i = 0; i < ROOM_TYPE.length; i++) {
				if(getRoomType().equals(ROOM_TYPE[i])) {
					if(getRoomNumber() < ROOM_NUMBERS[i][0] || getRoomNumber() > ROOM_NUMBERS[i][1]) {
						status = false;
					}
					else {
						status = true;
					}
				}
			}
		}
		return status;
	}
	
	// ***************************************************************
	
	@Override
	public String toString() {
		DecimalFormat currency = new DecimalFormat("$###,###.##");
		return "Number of Persons: " + getNumPersons() + "\n" +
			   "Room Type: " + getRoomType() + "\n" +
			   "Room Number: " + getRoomNumber() + "\n" +
			   "Check-In Date: " + getCheckInDate() + "\n" +
			   "Check-Out Date: " + getCheckOutDate() + "\n" +
			   "Lunch and Dinner: " + isLunchAndDinner() + "\n" +
			   "Additional Accomodations: " + getAddAccomodations() + "\n" +
			   "Length of Stay: " + getLengthOfStay() + "\n" +
			   "Total Cost: " + currency.format(getTotalCost());
	}
}
