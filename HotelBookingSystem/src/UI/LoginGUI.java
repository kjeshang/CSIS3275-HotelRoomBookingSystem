package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DateDV;

import DAO.AdminDB;
import DAO.GuestDB;
import Model.Login;
import UI.Admin.AdminGUI;
import UI.Admin.AdminPortalGUI;
import UI.Guest.GuestGUI;

import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

@SuppressWarnings({ "serial", "unused" })
public class LoginGUI extends JFrame implements ActionListener {
	
	private JPanel contentPane;
	private JLabel Login_lblTitle;
	private JTextField Login_txtUsername;
	private JPasswordField Login_txtPassword;
	private JLabel Login_lblUsername;
	private JLabel Login_lblPassword;
	private JButton Login_btnLogin;
	private JRadioButton Login_rdbAdmin;
	JRadioButton Login_rdbGuest;
	private final ButtonGroup Login_grpType = new ButtonGroup();
	
	private void setupComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// Login_lblTitle
		Login_lblTitle = new JLabel("Hotel Login");
		Login_lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		Login_lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		Login_lblTitle.setBackground(Color.GREEN);
		Login_lblTitle.setBounds(0, 0, 450, 61);
		Login_lblTitle.setOpaque(true);
		contentPane.add(Login_lblTitle);
		// Login_grpType
		Login_rdbGuest = new JRadioButton("Hotel Guest");
		Login_rdbGuest.setSelected(true);
		Login_grpType.add(Login_rdbGuest);
		Login_rdbGuest.setBounds(235, 87, 108, 23);
		contentPane.add(Login_rdbGuest);
		Login_rdbAdmin = new JRadioButton("Admin");
		Login_grpType.add(Login_rdbAdmin);
		Login_rdbAdmin.setBounds(108, 87, 73, 23);
		contentPane.add(Login_rdbAdmin);
		// Login_lblUsername
		Login_lblUsername = new JLabel("Username");
		Login_lblUsername.setBounds(73, 148, 71, 16);
		contentPane.add(Login_lblUsername);
		// Login_txtUsername
		Login_txtUsername = new JTextField();
		Login_txtUsername.setBounds(156, 145, 191, 21);
		contentPane.add(Login_txtUsername);
		Login_txtUsername.setColumns(10);
		// Login_lblPassword
		Login_lblPassword = new JLabel("Password");
		Login_lblPassword.setBounds(73, 195, 61, 16);
		contentPane.add(Login_lblPassword);
		// Login_txtPassword
		Login_txtPassword = new JPasswordField();
		Login_txtPassword.setBounds(156, 190, 191, 26);
		contentPane.add(Login_txtPassword);
		// Login_btnLogin
		Login_btnLogin = new JButton("Login");
		Login_btnLogin.setBounds(156, 232, 117, 29);
		contentPane.add(Login_btnLogin);
		Login_btnLogin.addActionListener(this);
	}
	
	public LoginGUI() {
		setTitle("Login");
		setupComponents();
	}
	
	Login login;
	GuestDB guestDb = new GuestDB();
	AdminDB adminDb = new AdminDB();
	String adminUsername;
	String adminPassword;
	String guestUsername;
	String guestPassword;
	

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Login_btnLogin) {
			if(Login_rdbGuest.isSelected()) {
				guestUsername = Login_txtUsername.getText().toString();
				guestPassword = String.valueOf(Login_txtPassword.getPassword());
				login = new Login(guestUsername,guestPassword);
				boolean guestExists = guestDb.checkIfExists(login.getUsername(),login.getPassword());
				if(guestExists == false) {
					int reply = JOptionPane.showConfirmDialog(null, "A guest with the given login information does not exist. Would you like to create a new guest account?", "New Guest", JOptionPane.YES_NO_OPTION);
					if(reply == JOptionPane.YES_OPTION) {
						guestDb.insertGuestLogin(login);
						JOptionPane.showMessageDialog(null,login.toString(),"New Guest created!",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Welcome Guest! (username: " + login.getUsername() + ")");
					dispose();
					new GuestGUI().setVisible(true);
				}
			}
			// admin login part
			if(Login_rdbAdmin.isSelected()) {
				adminUsername = Login_txtUsername.getText().toString();
				adminPassword = String.valueOf(Login_txtPassword.getPassword());
				System.out.println(adminUsername+ "  "+ adminPassword);
				login  = new Login(adminUsername,adminPassword);
				boolean adminExists = adminDb.checkIfExists(login.getUsername());
				System.out.println(adminExists);
				if(adminExists) {
					//JOptionPane.showMessageDialog(null,"Welcome Admin!");
				}
				else {
					int reply = JOptionPane.showConfirmDialog(null, "An Admin with the given login information does not exist. Would you like to create a new Admin account?", "New Admin", JOptionPane.YES_NO_OPTION);
					if(reply == JOptionPane.YES_OPTION) {
						dispose();
						new AdminGUI().setVisible(true);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}