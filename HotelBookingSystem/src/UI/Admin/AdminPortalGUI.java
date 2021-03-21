package UI.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mongodb.DBObject;
import com.toedter.calendar.JDateChooser;

import Model.Details;

import DAO.GuestDB;
import Model.Guest.GuestBooking;
import Model.Guest.GuestInfo;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import javax.swing.JSpinner;
import javax.swing.JCheckBox;

import javax.swing.JTextArea;

public class AdminPortalGUI {

	private JFrame Admin_portalframe;
	private JTable queryOutputTbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPortalGUI window = new AdminPortalGUI();
					window.Admin_portalframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	GuestInfo guestInfo;
	GuestBooking guestBooking;
	GuestDB db = new GuestDB();
	private JScrollPane scrollPane;
	private JLabel firstnamelbl;
	private JTextField firstNametxt;
	private JTextField phonetxt;
	private JTextField lastNametxt;
	private JTextField emailtxt;
	private JTextField searchtxt;
	private JTextField nationalitytxt;
	private JTextField purposeOfStaytxt;
	private JTextField addresstxt;
	private JTextField roomNumbertxt;
	private JDateChooser dateCheckIn;
	private JDateChooser dateCheckOut;
	@SuppressWarnings("rawtypes")
	private JComboBox searchFilterBox;
	private JButton searchBtn;
	private JLabel searchCriterialbl;
	private JButton editbtn;
	private JButton deletebtn;
	private JButton newGuestbtn;
	private JLabel guestInfolbl;
	private JLabel lastNamelbl;
	private JLabel phonelbl;
	private JLabel emaillbl;
	private JLabel nationalitylbl;
	private JLabel purpose_Of_Staylbl;
	private JLabel addresslbl;
	private JLabel guestBookinglbl;
	private JLabel numOfPersonslbl;
	private JSpinner numOfPersonspinner;
	@SuppressWarnings("rawtypes")
	private JComboBox roomTypeBox;
	private JLabel roomNumberlbl;
	private JLabel checkInlbl;
	private JLabel dateCheckOutlbl;
	private JCheckBox lunchDinnerChkBox;
	private JLabel accomadationlbl;
	private JTextArea additionaltxt;
	private JButton confirmbtn;
	/**
	 * Initialize the contents of the frame.
	 */
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		Admin_portalframe = new JFrame();
		Admin_portalframe.setTitle("Admin Portal");
		Admin_portalframe.setBounds(100, 100, 684, 516);
		Admin_portalframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 68, 475, 104);
		Admin_portalframe.getContentPane().add(scrollPane);
		
		queryOutputTbl = new JTable();
		scrollPane.setViewportView(queryOutputTbl);
		
		searchCriterialbl = new JLabel("Search Criteria");
		searchCriterialbl.setBounds(34, 6, 605, 16);
		searchCriterialbl.setHorizontalTextPosition(SwingConstants.CENTER);
		searchCriterialbl.setHorizontalAlignment(SwingConstants.CENTER);
		Admin_portalframe.getContentPane().add(searchCriterialbl);
		
		firstnamelbl = new JLabel("First Name");
		firstnamelbl.setBounds(6, 212, 77, 16);
		Admin_portalframe.getContentPane().add(firstnamelbl);
		
		firstNametxt = new JTextField();
		firstNametxt.setBounds(83, 207, 130, 26);
		firstNametxt.setColumns(10);
		Admin_portalframe.getContentPane().add(firstNametxt);
		
		phonelbl = new JLabel("Phone");
		phonelbl.setBounds(225, 212, 61, 16);
		Admin_portalframe.getContentPane().add(phonelbl);
		
		phonetxt = new JTextField();
		phonetxt.setBounds(271, 207, 130, 26);
		phonetxt.setColumns(10);
		Admin_portalframe.getContentPane().add(phonetxt);
		
		lastNamelbl = new JLabel("Last Name");
		lastNamelbl.setBounds(6, 241, 77, 16);
		Admin_portalframe.getContentPane().add(lastNamelbl);
		
		lastNametxt = new JTextField();
		lastNametxt.setBounds(83, 236, 130, 26);
		lastNametxt.setColumns(10);
		Admin_portalframe.getContentPane().add(lastNametxt);
		
		emaillbl = new JLabel("Email");
		emaillbl.setBounds(225, 240, 61, 16);
		Admin_portalframe.getContentPane().add(emaillbl);
		
		emailtxt = new JTextField();
		emailtxt.setBounds(271, 235, 130, 26);
		emailtxt.setColumns(10);
		Admin_portalframe.getContentPane().setLayout(null);
		Admin_portalframe.getContentPane().add(emailtxt);
		
		searchtxt = new JTextField();
		searchtxt.setBounds(6, 34, 181, 26);
		Admin_portalframe.getContentPane().add(searchtxt);
		searchtxt.setColumns(10);
		
		searchFilterBox = new JComboBox();
		searchFilterBox.setBounds(199, 35, 147, 27);
		Admin_portalframe.getContentPane().add(searchFilterBox);
		searchFilterBox.addItem("None");
		for(int i = 0; i < Details.COLUMNS.length; i++) {
			searchFilterBox.addItem(Details.COLUMNS[i]);
		}

		newGuestbtn = new JButton("New Guest");
		newGuestbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.insertGuest(guest(), booking());
			}
		});
		newGuestbtn.setBounds(493, 143, 117, 29);
		Admin_portalframe.getContentPane().add(newGuestbtn);
		
		nationalitylbl = new JLabel("Nationality");
		nationalitylbl.setBounds(413, 212, 77, 16);
		Admin_portalframe.getContentPane().add(nationalitylbl);
		
		purpose_Of_Staylbl = new JLabel("Purpose Of Stay");
		purpose_Of_Staylbl.setBounds(413, 241, 99, 16);
		Admin_portalframe.getContentPane().add(purpose_Of_Staylbl);
		
		nationalitytxt = new JTextField();
		nationalitytxt.setBounds(524, 207, 130, 26);
		Admin_portalframe.getContentPane().add(nationalitytxt);
		nationalitytxt.setColumns(10);
		
		purposeOfStaytxt = new JTextField();
		purposeOfStaytxt.setBounds(524, 236, 130, 26);
		Admin_portalframe.getContentPane().add(purposeOfStaytxt);
		purposeOfStaytxt.setColumns(10);
		
		guestInfolbl = new JLabel("Guest Info");
		guestInfolbl.setBounds(8, 186, 86, 16);
		Admin_portalframe.getContentPane().add(guestInfolbl);
		
		addresslbl = new JLabel("Address");
		addresslbl.setBounds(6, 272, 61, 16);
		Admin_portalframe.getContentPane().add(addresslbl);
		
		addresstxt = new JTextField();
		addresstxt.setBounds(83, 267, 318, 26);
		Admin_portalframe.getContentPane().add(addresstxt);
		addresstxt.setColumns(10);
		
		guestBookinglbl = new JLabel("Guest Booking Information");
		guestBookinglbl.setBounds(6, 300, 181, 16);
		Admin_portalframe.getContentPane().add(guestBookinglbl);
		
		numOfPersonslbl = new JLabel("Number Of Persons");
		numOfPersonslbl.setBounds(6, 328, 130, 16);
		Admin_portalframe.getContentPane().add(numOfPersonslbl);
		
		numOfPersonspinner = new JSpinner();
		numOfPersonspinner.setBounds(140, 323, 47, 26);
		Admin_portalframe.getContentPane().add(numOfPersonspinner);
		
		JLabel roomTypelbl = new JLabel("Room Type");
		roomTypelbl.setBounds(199, 328, 77, 16);
		Admin_portalframe.getContentPane().add(roomTypelbl);
		
		roomTypeBox = new JComboBox();
		roomTypeBox.setBounds(271, 324, 130, 27);
		Admin_portalframe.getContentPane().add(roomTypeBox);
		for(int i = 0; i < Details.ROOM_TYPE.length; i++) {
			roomTypeBox.addItem(Details.ROOM_TYPE[i]);
		}
		
		roomNumberlbl = new JLabel("Room Number");
		roomNumberlbl.setBounds(413, 328, 99, 16);
		Admin_portalframe.getContentPane().add(roomNumberlbl);
		
		roomNumbertxt = new JTextField();
		roomNumbertxt.setBounds(524, 323, 130, 26);
		Admin_portalframe.getContentPane().add(roomNumbertxt);
		roomNumbertxt.setColumns(10);
		
		checkInlbl = new JLabel("Check In Date");
		checkInlbl.setBounds(6, 361, 99, 16);
		Admin_portalframe.getContentPane().add(checkInlbl);
		
		dateCheckIn = new JDateChooser();
		dateCheckIn.setBounds(106, 356, 149, 26);
		Admin_portalframe.getContentPane().add(dateCheckIn);
		
		dateCheckOutlbl = new JLabel("Check Out Date");
		dateCheckOutlbl.setBounds(271, 361, 109, 16);
		Admin_portalframe.getContentPane().add(dateCheckOutlbl);
		
		dateCheckOut = new JDateChooser();
		dateCheckOut.setBounds(392, 356, 149, 26);
		Admin_portalframe.getContentPane().add(dateCheckOut);
		
		lunchDinnerChkBox = new JCheckBox("Lunch & Dinner");
		lunchDinnerChkBox.setBounds(548, 357, 130, 23);
		Admin_portalframe.getContentPane().add(lunchDinnerChkBox);
		
		accomadationlbl = new JLabel("Additional Accomadation");
		accomadationlbl.setBounds(6, 389, 167, 16);
		Admin_portalframe.getContentPane().add(accomadationlbl);
		
		additionaltxt = new JTextArea();
		additionaltxt.setBounds(6, 417, 358, 64);
		Admin_portalframe.getContentPane().add(additionaltxt);
		
		deletebtn = new JButton("Delete Guest");
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.deleteRecord(getSelectedrowPhone().toString());
			}
		});
		deletebtn.setBounds(493, 113, 117, 29);
		Admin_portalframe.getContentPane().add(deletebtn);
		
		confirmbtn = new JButton("Confirm");
		confirmbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				db.deleteRecord(phonetxt.getText());
				db.insertGuest(guest(), booking());
			}
		});
		confirmbtn.setBounds(422, 417, 217, 38);
		Admin_portalframe.getContentPane().add(confirmbtn);
		
		searchBtn = new JButton("Search");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchandAddtoTable();
			}
		});
		searchBtn.setBounds(358, 34, 117, 29);
		Admin_portalframe.getContentPane().add(searchBtn);
		
		editbtn = new JButton("Edit Info");
		editbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DBObject[] jsonrow = db.searchGuest(getSelectedrowPhone());
				System.out.println("jsonrow" + jsonrow );
				printInfo(jsonrow);				
			}
		});
		editbtn.setBounds(493, 83, 117, 29);
		Admin_portalframe.getContentPane().add(editbtn);
	}
	
	/**
	 * Create the application.
	 */
	public AdminPortalGUI() {
		initialize();
	}
	
	
	public void searchandAddtoTable() {
		
			DefaultTableModel model = new DefaultTableModel();
			Object[][] rows = db.getBasicGuestInfo();
			
			for (int i = 0; i< Details.COLUMNS.length; i ++)
			{
				model.addColumn(Details.COLUMNS[i]);

			}
			int searchIndex = -1;
			String searchObject = searchtxt.getText().toString();
			
			if(searchObject != null || searchObject != "")
			{
				if(searchFilterBox.getSelectedItem() == "firstname") {
					searchIndex = 0;
				}else if (searchFilterBox.getSelectedItem() == "lastname") {
					searchIndex = 1;
					
				}else if (searchFilterBox.getSelectedItem() == "email") {
					searchIndex = 2;
					
				}else if (searchFilterBox.getSelectedItem() == "phone") {
					searchIndex = 3;	
				}else {
					searchIndex =-1;
				}
			}	
			for(int i=0; i < rows.length;i++)
			{
				if(searchIndex == -1)
				{
					model.addRow(rows[i]);	
				}
				else if (rows[i][searchIndex].equals(searchObject))
				{
					model.addRow(rows[i]);
				}
			}			
			queryOutputTbl.setModel(model);
		}
	
	public void printInfo(DBObject[] row) {
		
//		DBObject bookinginfo = row.get("booking");
		
		firstNametxt.setText(row[0].get("firstName").toString());
		lastNametxt.setText(row[0].get("lastName").toString());
		emailtxt.setText(row[0].get("email").toString());
		phonetxt.setText(row[0].get("phone").toString());
		nationalitytxt.setText(row[0].get("nationality").toString());
		addresstxt.setText(row[0].get("address").toString());
		purposeOfStaytxt.setText(row[0].get("purposeOfStay").toString());
		numOfPersonspinner.setValue(row[1].get("numPersons"));
		roomTypeBox.setSelectedItem(row[1].get("roomType"));
		roomNumbertxt.setText(row[1].get("roomNumber").toString());
		if(row[1].get("roomNumber").toString() == "true")
			lunchDinnerChkBox.setSelected(true);
		else
			lunchDinnerChkBox.setSelected(false);
		additionaltxt.setText(row[1].get("addAccomodations").toString());
		dateCheckIn.setDate((Date)row[1].get("checkInDate"));
		dateCheckOut.setDate((Date)row[1].get("checkOutDate"));

		
//		roomNumbertxt.setText(row.get("roomNumber").toString());
		
		
	}
	
	private GuestInfo guest() {
		String firstName = firstNametxt.getText().toString();
		String lastName = lastNametxt.getText().toString();
		String address = addresstxt.getText().toString();
		String email = emailtxt.getText().toString();
		String phone = phonetxt.getText().toString();
		String nationality = nationalitytxt.getText().toString();
		String purposeOfStay = purposeOfStaytxt.getText().toString();
		GuestInfo guestInfo = new GuestInfo(firstName,lastName,address,email,phone,nationality,purposeOfStay);
		return guestInfo;
	}
	
	private GuestBooking booking() {
		int numPersons = Integer.parseInt(numOfPersonspinner.getValue().toString());
		String roomType = roomTypeBox.getSelectedItem().toString();
		int roomNumber = Integer.parseInt(roomNumbertxt.getText().toString());
		LocalDate checkInDate = formatDate(dateCheckIn);
		LocalDate checkOutDate = formatDate(dateCheckOut);
		boolean lunchAndDinner;
		if(lunchDinnerChkBox.isSelected()) {
			lunchAndDinner = true;
		}
		else {
			lunchAndDinner = false;
		}
		String addAccomodations = additionaltxt.getText().toString();
		GuestBooking guestBooking = new GuestBooking(numPersons,roomType,roomNumber, checkInDate,checkOutDate,lunchAndDinner,addAccomodations);
		return guestBooking;
	}
	
	@SuppressWarnings("deprecation")
	private LocalDate formatDate(JDateChooser date) {
		LocalDate retDate = LocalDate.of(date.getDate().getYear()+1900,date.getDate().getMonth()+1,date.getDate().getDate());
		return retDate;
	}
	
	private Object getSelectedrowPhone() {
		int selectedIndex = queryOutputTbl.getSelectedRow();
		Object searchPhoneString = queryOutputTbl.getModel().getValueAt(selectedIndex, Details.PHONE_INDEX);
		return searchPhoneString;
		
	}
}
