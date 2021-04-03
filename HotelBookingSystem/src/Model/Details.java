package Model;

public interface Details {
	
	public final static String[] ROOM_TYPE = {"Standard", "Family", "Luxury"};
	public final static double[] ROOM_COST = {50.00, 100.00, 150.00};
	public final static int[][] ROOM_NUMBERS = {{100,200},{201,250},{251,260}};
	public final static double LUNCH_DINNER_COST = 30.00;
	public final static double ACCOMODATION_COST = 50.00;
	public final static int NUMPERSONS_LIMIT = 3;
	public final static double NUMPERSONS_EXTRACHARGE = 10.00;
	public final static Object[] COLUMNS = {"firstname","lastname","email","phone"};
	public final static int PHONE_INDEX = 3;
}
