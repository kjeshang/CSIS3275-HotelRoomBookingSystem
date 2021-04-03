package UI.GuestUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Control.Connection;
import Control.GuestDB;
import Model.Details;
import Model.Guest.GuestBooking;
import Model.Guest.GuestInfo;
import UI.LoginGUI;

import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

@SuppressWarnings({ "serial", "unused" })
public class GuestGUI extends JFrame implements ActionListener,Details {

	private JPanel contentPane;
	// GuestInfo
	private JLabel Guest_lblInfo;
	private JLabel Guest_lblFirstName;
	private JTextField Guest_txtFirstName;
	private JTextField Guest_txtLastName;
	private JTextField Guest_txtAddress;
	private JLabel Guest_lblAddress;
	private JLabel Guest_lblLastName;
	private JLabel Guest_lblEmail;
	private JTextField Guest_txtEmail;
	private JLabel Guest_lblPhone;
	private JTextField Guest_txtPhone;
	private JLabel Guest_lblNationality;
	private JTextField Guest_txtNationality;
	private JLabel Guest_lblPurposeOfStay;
	private JTextField Guest_txtPurposeOfStay;
	private JButton Guest_btnConfirm;
	private JButton Guest_btnBookRoom;
	// GuestBooking
	private JLabel Guest_lblBooking;
	private JSpinner Guest_spNumPersons;
	private JLabel Guest_lblRoomType;
	@SuppressWarnings("rawtypes")
	private JComboBox Guest_cbxRoomType;
	private JLabel Guest_lblNumPersons;
	private JLabel Guest_lblRoomNumber;
	private JTextField Guest_txtRoomNumber;
	private JDateChooser Guest_dateCheckIn;
	private JLabel Guest_lblCheckInDate;
	private JLabel Guest_lblCheckOutDate;
	private JDateChooser Guest_dateCheckOut;
	private JCheckBox Guest_chkLunchDinner;
	private JTextArea Guest_txtAddAccomodation;
	private JPanel Guest_lblAddAccomodation;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void setupComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 692);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// ************************ GuestInfo *********************************
		// Guest_lblTitle
		Guest_lblInfo = new JLabel("Guest Information");
		Guest_lblInfo.setBackground(Color.CYAN);
		Guest_lblInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		Guest_lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		Guest_lblInfo.setBounds(0, 0, 481, 48);
		contentPane.add(Guest_lblInfo);
		Guest_lblInfo.setOpaque(true);
		// Guest_lblFirstName
		Guest_lblFirstName = new JLabel("First Name");
		Guest_lblFirstName.setBounds(6, 58, 76, 26);
		contentPane.add(Guest_lblFirstName);
		// Guest_txtFirstName
		Guest_txtFirstName = new JTextField();
		Guest_txtFirstName.setBounds(120, 58, 130, 26);
		contentPane.add(Guest_txtFirstName);
		Guest_txtFirstName.setColumns(10);
		// Guest_lblLastName
		Guest_lblLastName = new JLabel("Last Name");
		Guest_lblLastName.setBounds(6, 96, 76, 16);
		contentPane.add(Guest_lblLastName);
		// Guest_txtLastName
		Guest_txtLastName = new JTextField();
		Guest_txtLastName.setBounds(120, 91, 130, 26);
		contentPane.add(Guest_txtLastName);
		Guest_txtLastName.setColumns(10);
		// Guest_lblAddress
		Guest_lblAddress = new JLabel("Address");
		Guest_lblAddress.setBounds(6, 124, 61, 16);
		contentPane.add(Guest_lblAddress);
		// Guest_txtAddress
		Guest_txtAddress = new JTextField();
		Guest_txtAddress.setBounds(120, 119, 296, 26);
		contentPane.add(Guest_txtAddress);
		Guest_txtAddress.setColumns(10);
		// Guest_lblEmail
		Guest_lblEmail = new JLabel("Email");
		Guest_lblEmail.setBounds(6, 152, 61, 16);
		contentPane.add(Guest_lblEmail);
		// Guest_txtEmail
		Guest_txtEmail = new JTextField();
		Guest_txtEmail.setBounds(120, 147, 210, 26);
		contentPane.add(Guest_txtEmail);
		Guest_txtEmail.setColumns(10);
		// Guest_lblPhone
		Guest_lblPhone = new JLabel("Phone");
		Guest_lblPhone.setBounds(6, 180, 61, 16);
		contentPane.add(Guest_lblPhone);
		// Guest_txtPhone
		Guest_txtPhone = new JTextField();
		Guest_txtPhone.setBounds(120, 175, 130, 26);
		contentPane.add(Guest_txtPhone);
		Guest_txtPhone.setColumns(10);
		// Guest_lblNationality
		Guest_lblNationality = new JLabel("Nationality");
		Guest_lblNationality.setBounds(6, 208, 76, 16);
		contentPane.add(Guest_lblNationality);
		// Guest_txtNationality
		Guest_txtNationality = new JTextField();
		Guest_txtNationality.setBounds(120, 203, 130, 26);
		contentPane.add(Guest_txtNationality);
		Guest_txtNationality.setColumns(10);
		// Guest_lblPurposeOfStay
		Guest_lblPurposeOfStay = new JLabel("Purpose of Stay");
		Guest_lblPurposeOfStay.setBounds(6, 236, 105, 16);
		contentPane.add(Guest_lblPurposeOfStay);
		// Guest_txtPurposeOfStay
		Guest_txtPurposeOfStay = new JTextField();
		Guest_txtPurposeOfStay.setBounds(120, 231, 296, 26);
		contentPane.add(Guest_txtPurposeOfStay);
		Guest_txtPurposeOfStay.setColumns(10);
		// Guest_btnConfirm
		Guest_btnConfirm = new JButton("Confirm");
		Guest_btnConfirm.setBackground(Color.WHITE);
		Guest_btnConfirm.setBounds(148, 264, 117, 29);
		contentPane.add(Guest_btnConfirm);
		Guest_btnConfirm.addActionListener(this);
		// ************************ GuestBooking *********************************
		// Guest_lblBooking
		Guest_lblBooking = new JLabel("Guest Booking");
		Guest_lblBooking.setBackground(Color.RED);
		Guest_lblBooking.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		Guest_lblBooking.setHorizontalAlignment(SwingConstants.CENTER);
		Guest_lblBooking.setBounds(0, 305, 481, 41);
		contentPane.add(Guest_lblBooking);
		Guest_lblBooking.setOpaque(true);
		// Guest_lblNumPersons
		Guest_lblNumPersons = new JLabel("Number of Persons");
		Guest_lblNumPersons.setBounds(6, 358, 130, 16);
		contentPane.add(Guest_lblNumPersons);
		// Guest_spNumPersons
		Guest_spNumPersons = new JSpinner();
		Guest_spNumPersons.setBounds(148, 353, 34, 26);
		contentPane.add(Guest_spNumPersons);
		// Guest_lblRoomType
		Guest_lblRoomType = new JLabel("Room Type");
		Guest_lblRoomType.setBounds(56, 386, 76, 16);
		contentPane.add(Guest_lblRoomType);
		// Guest_cbxRoomType
		Guest_cbxRoomType = new JComboBox();
		Guest_cbxRoomType.setBounds(148, 382, 149, 27);
		contentPane.add(Guest_cbxRoomType);
		for(int i = 0; i < ROOM_TYPE.length; i++) {
			Guest_cbxRoomType.addItem(ROOM_TYPE[i]);
		}
		// Guest_lblRoomNumber
		Guest_lblRoomNumber = new JLabel("Room Number");
		Guest_lblRoomNumber.setBounds(35, 414, 97, 16);
		contentPane.add(Guest_lblRoomNumber);
		// Guest_txtRoomNumber
		Guest_txtRoomNumber = new JTextField();
		Guest_txtRoomNumber.setBounds(148, 409, 149, 26);
		contentPane.add(Guest_txtRoomNumber);
		Guest_txtRoomNumber.setColumns(10);
		// Guest_lblCheckInDate
		Guest_lblCheckInDate = new JLabel("Check-In Date");
		Guest_lblCheckInDate.setBounds(35, 442, 97, 16);
		contentPane.add(Guest_lblCheckInDate);
		// Guest_dateCheckIn <-
		Guest_dateCheckIn = new JDateChooser();
		Guest_dateCheckIn.setBounds(148, 439, 149, 26);
		contentPane.add(Guest_dateCheckIn);
		// Guest_lblCheckOutDate
		Guest_lblCheckOutDate = new JLabel("Check-Out Date");
		Guest_lblCheckOutDate.setBounds(28, 480, 104, 16);
		contentPane.add(Guest_lblCheckOutDate);
		// Guest_dateCheckOut <-
		Guest_dateCheckOut = new JDateChooser();
		Guest_dateCheckOut.setBounds(148, 477, 149, 26);
		contentPane.add(Guest_dateCheckOut);
		// Guest_chkLunchDinner
		Guest_chkLunchDinner = new JCheckBox("Lunch and Dinner (** Breakfast complimentary **)");
		Guest_chkLunchDinner.setBounds(28, 516, 373, 23);
		contentPane.add(Guest_chkLunchDinner);
		Guest_chkLunchDinner.addActionListener(this);
		// Guest_lblAddAccomodation
		Guest_lblAddAccomodation = new JPanel();
		Guest_lblAddAccomodation.setBorder(new TitledBorder(null, "Additional Accomodation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Guest_lblAddAccomodation.setBounds(28, 551, 428, 66);
		contentPane.add(Guest_lblAddAccomodation);
		Guest_lblAddAccomodation.setLayout(null);
		// Guest_txtAddAccomodation
		Guest_txtAddAccomodation = new JTextArea();
		Guest_txtAddAccomodation.setBounds(6, 18, 416, 42);
		Guest_lblAddAccomodation.add(Guest_txtAddAccomodation);
		Guest_txtAddAccomodation.setBackground(Color.WHITE);
		Guest_txtAddAccomodation.setRows(3);
		// Guest_btnBookRoom
		Guest_btnBookRoom = new JButton("Book Room");
		Guest_btnBookRoom.setBounds(188, 635, 117, 29);
		contentPane.add(Guest_btnBookRoom);
		Guest_btnBookRoom.setVisible(false);
		Guest_btnBookRoom.addActionListener(this);
		// **** VISIBILITY ****
		setVisibility(false);
		Guest_txtFirstName.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char ch = e.getKeyChar();
                if(!Character.isLetter(ch)){
                	e.consume();
                }
            }
        });

		Guest_txtLastName.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char ch = e.getKeyChar();
                if(!Character.isLetter(ch)){
                	e.consume();
                }
            }
        });
	}
	
	private void setVisibility(boolean status) {
		Guest_lblBooking.setVisible(status);
		Guest_lblNumPersons.setVisible(status);
		Guest_spNumPersons.setVisible(status);
		Guest_lblRoomType.setVisible(status);
		Guest_cbxRoomType.setVisible(status);
		Guest_lblRoomNumber.setVisible(status);
		Guest_txtRoomNumber.setVisible(status);
		Guest_lblCheckInDate.setVisible(status);
		Guest_dateCheckIn.setVisible(status);
		Guest_lblCheckOutDate.setVisible(status);
		Guest_dateCheckOut.setVisible(status);
		Guest_chkLunchDinner.setVisible(status);
		Guest_lblAddAccomodation.setVisible(status);
		Guest_txtAddAccomodation.setVisible(status);
		Guest_btnBookRoom.setVisible(status);
	}
	
	public GuestGUI() {
		setTitle("Guest");
		setupComponents();
	}
	
	GuestInfo guestInfo;
	GuestBooking guestBooking;
	GuestDB db = new GuestDB();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Confirm Button:
		if(e.getSource() == Guest_btnConfirm) {
			guestInfo = guest();
			if(guestInfo.validInfo() == false) {
				JOptionPane.showMessageDialog(null, invalidNewGuestInfo());
			}
			else {
				int reply1 = JOptionPane.showConfirmDialog(null, guestInfo.toString(), "Please confirm your information", JOptionPane.YES_NO_OPTION);
				if(reply1 == JOptionPane.YES_OPTION) {
					setVisibility(true);
				}
			}
		}
		// Book Room Button:
		if(e.getSource() == Guest_btnBookRoom) {
			guestBooking = booking();
			if(guestBooking.validBooking() == false) {
				JOptionPane.showMessageDialog(null, invalidNewGuestBooking());
			}
			else if(db.checkIfReservationExists(guestBooking) == true) {
				JOptionPane.showMessageDialog(null, "Booking Unavailable");
			}
			else {
				int reply2 = JOptionPane.showConfirmDialog(null, guestBooking.toString(), "Please confirm your booking", JOptionPane.YES_NO_OPTION);
				if(reply2 == JOptionPane.YES_OPTION) {
					db.insertGuest(guestInfo,guestBooking);
					showConfirmation();
					dispose();
					new LoginGUI().setVisible(true);
				}
			}
		}
	}
	
	private GuestInfo guest() {
		String firstName = Guest_txtFirstName.getText().toString();
		String lastName = Guest_txtLastName.getText().toString();
		String address = Guest_txtAddress.getText().toString();
		String email = Guest_txtEmail.getText().toString();
		String phone = Guest_txtPhone.getText().toString();
		String nationality = Guest_txtNationality.getText().toString();
		String purposeOfStay = Guest_txtPurposeOfStay.getText().toString();
		GuestInfo guestInfo = new GuestInfo(firstName,lastName,address,email,phone,nationality,purposeOfStay);
		return guestInfo;
	}
	
	private String invalidNewGuestInfo() {
		String message = "";
		message += "Invalid hotel guest background information. Please provide valid background information and try again. The following conditions must be fulfilled in order to proceed:\n";
		message += "1. All required fields must be filled.\n";
		message += "2. A valid email address must be provided (e.g.janedoe@gmail.com)\n";
		message += "3. A phone number must contain 10 numeric characters.";
		return message;
	}
	
	private GuestBooking booking() {
		int numPersons = Integer.parseInt(Guest_spNumPersons.getValue().toString());
		String roomType = Guest_cbxRoomType.getSelectedItem().toString();
		int roomNumber;
		try {
			roomNumber = Integer.parseInt(Guest_txtRoomNumber.getText().toString());
		}
		catch(NumberFormatException e) {
			System.out.println(e.getMessage());
			roomNumber = 0;
		}
		LocalDate checkInDate = formatDate(Guest_dateCheckIn);
		LocalDate checkOutDate = formatDate(Guest_dateCheckOut);
		boolean lunchAndDinner;
		if(Guest_chkLunchDinner.isSelected()) {
			lunchAndDinner = true;
		}
		else {
			lunchAndDinner = false;
		}
		String addAccomodations = Guest_txtAddAccomodation.getText().toString();
		GuestBooking guestBooking = new GuestBooking(numPersons,roomType,roomNumber, checkInDate,checkOutDate,lunchAndDinner,addAccomodations);
		return guestBooking;
	}
	
	private String invalidNewGuestBooking() {
		String message = "Invalid hotel guest booking information. Please provide valid booking information and try again. The following conditions must be fulfilled in order to proceed:\n";
		message += "1. At least one person must be staying in booked room.\n";
		message += "2. Valid check-in and check-out dates must be entered.\n";
		message += "\t\t2.1. Check-out date cannot be earlier than check-in date.\n";
		message += "\t\t2.2. Check-in & Check-out date fields must not be empty.\n";
		message += "3. The appropriate room number must be selected.\n";
		message += "\t\t3.1. Standard room: Unit 100 - 200\n";
		message += "\t\t3.2. Family room: Unit 201 - 250\n";
		message += "\t\t3.3. Luxury room: Unit 251 - 260\n";
		return message;
	}
	
	@SuppressWarnings("deprecation")
	private LocalDate formatDate(JDateChooser date) {
		LocalDate retDate;
		try {
			retDate = LocalDate.of(date.getDate().getYear()+1900,date.getDate().getMonth()+1,date.getDate().getDate());
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
			retDate = LocalDate.now();
		}
		return retDate;
	}
	
	private void showConfirmation() {
		JTextArea textArea = new JTextArea(confirmation(guestInfo));
		textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setMargin(new Insets(5,5,5,5));
        textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(380,300));
        JOptionPane.showMessageDialog(null, scrollPane,"Booking Confirmed!",JOptionPane.INFORMATION_MESSAGE);
	}
	
	private String confirmation(GuestInfo guestInfo) {
		String message = "";
		message += "Reservation details below:\n";
		message += "-------------------------------------------\n";
		message += db.findGuest(guestInfo) + "\n\n";
		message += "-------------------------------------------\n\n";
		message += "** Please save the above details for your own record & future reference. **";
		return message;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuestGUI frame = new GuestGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
