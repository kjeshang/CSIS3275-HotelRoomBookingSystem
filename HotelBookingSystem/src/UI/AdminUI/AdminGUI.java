package UI.AdminUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Control.AdminDB;
import Model.Details;
import Model.Login;
import Model.Admin.AdminInfo;
import UI.LoginGUI;

@SuppressWarnings("serial")
public class AdminGUI extends JFrame implements ActionListener,Details {

	private JPanel contentPane;
	// GuestInfo
	private JLabel Admin_lblInfo;
	private JLabel Admin_lblFirstName;
	private JTextField Admin_txtFirstName;
	private JTextField Admin_txtLastName;
	private JTextField Admin_txtAddress;
	private JLabel Admin_lblAddress;
	private JLabel Admin_lblLastName;
	private JLabel Admin_lblEmail;
	private JTextField Admin_txtEmail;
	private JLabel Admin_lblPhone;
	private JTextField Admin_txtPhone;
	private JButton Admin_btnConfirm;
	private JLabel admin_usernamelbl;
	private JLabel admin_passlbl;
	private JLabel admin_PassConflbl;
	private JTextField Admin_txtUsername;
	private JPasswordField Admin_txtPassword;
	private JPasswordField Admin_txtConfPassword;
	
	
	private void setupComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 498);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// ************************ AdminInfo *********************************
		// Admin_lblTitle
		Admin_lblInfo = new JLabel("Admin Information");
		Admin_lblInfo.setBackground(Color.CYAN);
		Admin_lblInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		Admin_lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		Admin_lblInfo.setBounds(0, 0, 481, 48);
		contentPane.add(Admin_lblInfo);
		Admin_lblInfo.setOpaque(true);
		// Admin_lblFirstName
		Admin_lblFirstName = new JLabel("First Name");
		Admin_lblFirstName.setBounds(6, 58, 76, 26);
		contentPane.add(Admin_lblFirstName);
		// Admin_txtFirstName
		Admin_txtFirstName = new JTextField();
		Admin_txtFirstName.setBounds(120, 58, 130, 26);
		contentPane.add(Admin_txtFirstName);
		Admin_txtFirstName.setColumns(10);
		// Admin_lblLastName
		Admin_lblLastName = new JLabel("Last Name");
		Admin_lblLastName.setBounds(6, 96, 76, 16);
		contentPane.add(Admin_lblLastName);
		// Admin_txtLastName
		Admin_txtLastName = new JTextField();
		Admin_txtLastName.setBounds(120, 91, 130, 26);
		contentPane.add(Admin_txtLastName);
		Admin_txtLastName.setColumns(10);
		// Admin_lblAddress
		Admin_lblAddress = new JLabel("Address");
		Admin_lblAddress.setBounds(6, 124, 61, 16);
		contentPane.add(Admin_lblAddress);
		// Admin_txtAddress
		Admin_txtAddress = new JTextField();
		Admin_txtAddress.setBounds(120, 119, 296, 26);
		contentPane.add(Admin_txtAddress);
		Admin_txtAddress.setColumns(10);
		// Admin_lblEmail
		Admin_lblEmail = new JLabel("Email");
		Admin_lblEmail.setBounds(6, 180, 61, 16);
		contentPane.add(Admin_lblEmail);
		// Admin_txtEmail
		Admin_txtEmail = new JTextField();
		Admin_txtEmail.setBounds(120, 175, 210, 26);
		contentPane.add(Admin_txtEmail);
		Admin_txtEmail.setColumns(10);
		// Admin_lblPhone
		Admin_lblPhone = new JLabel("Phone");
		Admin_lblPhone.setBounds(6, 152, 76, 16);
		contentPane.add(Admin_lblPhone);
		// Admin_txtPhone
		Admin_txtPhone = new JTextField();
		Admin_txtPhone.setBounds(120, 147, 210, 26);
		contentPane.add(Admin_txtPhone);
		Admin_txtPhone.setColumns(10);
		//Admin_Loginlbl
		JLabel login_Info_Title = new JLabel("Login Information");
		login_Info_Title.setBounds(180, 215, 124, 20);
		contentPane.add(login_Info_Title);
		//Admin_lblUsername
		admin_usernamelbl = new JLabel("Username");
		admin_usernamelbl.setBounds(6, 254, 82, 16);
		contentPane.add(admin_usernamelbl);
		//Admin_lblpassword
		admin_passlbl = new JLabel("Password");
		admin_passlbl.setBounds(6, 282, 61, 16);
		contentPane.add(admin_passlbl);
		//Admin_lblConfPassword
		admin_PassConflbl = new JLabel("Confirm Password");
		admin_PassConflbl.setBounds(6, 310, 117, 16);
		contentPane.add(admin_PassConflbl);
		//Admin_txtUsername
		Admin_txtUsername = new JTextField();
		Admin_txtUsername.setBounds(130, 247, 142, 26);
		contentPane.add(Admin_txtUsername);
		Admin_txtUsername.setColumns(10);
		//Admin_txtPassword
		Admin_txtPassword = new JPasswordField();
		Admin_txtPassword.setBounds(130, 277, 142, 26);
		contentPane.add(Admin_txtPassword);
		Admin_txtPassword.setColumns(10);
		//Admin_txtConfPassword
		Admin_txtConfPassword = new JPasswordField();
		Admin_txtConfPassword.setBounds(130, 305, 142, 26);
		contentPane.add(Admin_txtConfPassword);
		Admin_txtConfPassword.setColumns(10);
		//Admin_confirmbtn
		Admin_btnConfirm = new JButton("Confirm");
		Admin_btnConfirm.setBackground(Color.WHITE);
		Admin_btnConfirm.setBounds(181, 376, 117, 29);
		contentPane.add(Admin_btnConfirm);
		Admin_btnConfirm.addActionListener(this);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(181, 19, 1, 1);
		contentPane.add(desktopPane);
		
		Admin_txtFirstName.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char ch = e.getKeyChar();
                if(!Character.isLetter(ch)){
                	e.consume();
                }
            }
        });
		Admin_txtLastName.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char ch = e.getKeyChar();
                if(!Character.isLetter(ch)){
                	e.consume();
                }
            }
        });
	}

	public AdminGUI() {
		setBackground(Color.WHITE);
		setTitle("Admin");
		setupComponents();
	}
	
	AdminInfo adminInfo;
	AdminDB db = new AdminDB();
	String adminUsername;
	String adminPassword;
	Login adminLogin;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Confirm Button:
		if(e.getSource() == Admin_btnConfirm) {
			String pass = String.valueOf(Admin_txtPassword.getPassword());
			String confPass = String.valueOf(Admin_txtConfPassword.getPassword());
			if(pass.equals(confPass))
			{
				adminUsername = Admin_txtUsername.getText().toString();
				adminPassword = String.valueOf(Admin_txtPassword.getPassword());
				adminLogin = new Login(adminUsername, adminPassword);
				adminInfo = admin();
				boolean adminLoginExists = db.checkIfExists(adminUsername);
				if(adminInfo.validInfo() == false || adminLogin.validLogin() == false) {
					JOptionPane.showMessageDialog(null, invalidNewAdminInfo());
				}
				else if(adminLoginExists == true) {
					JOptionPane.showMessageDialog(null,"The provided hotel admin login credentials are already taken. Please provide alternate username and password to create a hotel admin account.");
				}
				else {
					int reply1 = JOptionPane.showConfirmDialog(null, adminInfo.toString(), "Please confirm your information", JOptionPane.YES_NO_OPTION);
					if(reply1 == JOptionPane.YES_OPTION) {
						db.insertAdmin(adminInfo);
						db.insertAdminLogin(adminLogin);
						//insertCredentials(Admin_txtUsername.getText().toString(),pass);
						//showConfirmation();
						dispose();
						new LoginGUI().setVisible(true);
					}
			    }
			}
			else {
				JOptionPane.showMessageDialog(null, "Oops! Password does not match");
			}
			
		}

	}
	
	private AdminInfo admin() {
		String firstName = Admin_txtFirstName.getText().toString();
		String lastName = Admin_txtLastName.getText().toString();
		String address = Admin_txtAddress.getText().toString();
		String email = Admin_txtEmail.getText().toString();
		String phone = Admin_txtPhone.getText().toString();
		AdminInfo adminInfo = new AdminInfo(firstName,lastName,address,email,phone);
		return adminInfo;
	}
	
//	private void showConfirmation() {
//		JTextArea textArea = new JTextArea(confirmation(adminInfo));
//		textArea.setLineWrap(true);
//        textArea.setWrapStyleWord(true);
//        textArea.setMargin(new Insets(5,5,5,5));
//        textArea.setEditable(false);
//		JScrollPane scrollPane = new JScrollPane(textArea);
//        scrollPane.setPreferredSize(new Dimension(380,300));
//        JOptionPane.showMessageDialog(null, scrollPane,"Admin account Created",JOptionPane.INFORMATION_MESSAGE);
//	}
	
//	private String confirmation(AdminInfo adminInfo) {
//		String message = "";
//		message += "Admin account details below:\n";
//		message += "-------------------------------------------\n";
//		message += db.findAdmin(adminInfo) + "\n\n";
//		message += "-------------------------------------------\n\n";
//		message += "** Please save the above details for your own record & future reference. **";
//		return message;
//	}
	
	private String invalidNewAdminInfo() {
		String message = "";
		message += "Invalid hotel admin login & background information. Please provide valid information and try again. The following conditions must be fulfilled in order to proceed:\n";
		message += "1. You need to enter a valid email address as your login username.\n";
		message += "2. You need to enter a login password that is at least 6 characters long with a mix of numbers and letters.\n";
		message += "\t\t2.1. The password must contain at least 1 numeric character.\n";
		message += "\t\t2.2. The password must contain at least 4 alphabetic characters.\n";
		message += "3. All required background information fields must be filled.\n";
		message += "4. A valid email address must be provided (e.g. janedoe@gmail.com)\n";
		message += "5. A phone number must contain 10 numeric characters.";
		return message;
	}
	
//	private void insertCredentials(String username, String password)
//	{
//		Login login = new Login(username,password);
//		db.insertAdminLogin(login);
//	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGUI frame = new AdminGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
