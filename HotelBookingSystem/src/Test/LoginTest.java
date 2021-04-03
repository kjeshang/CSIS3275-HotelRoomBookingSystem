package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Control.AdminDB;
import Control.GuestDB;
import Model.Login;

class LoginTest {
	
	static int testCount;
	
	static String username;
	static String password;
	Login login;
	GuestDB guestDB;
	AdminDB adminDB;
	
	@BeforeAll
	static void setupAll() {
		System.out.println("Initializing Login-related tests.");
		testCount = 1;
	}
	
	@BeforeEach
	void setup() {
		username =  "testuser";
		password = "testuser123";
		login = new Login(username,password);
		guestDB = new GuestDB();
		adminDB = new AdminDB();
	}
	
	@Test
	@DisplayName("Should create login as both username & password have a valid format, and prove its validity to be true")
	void shouldCreateLogin() {
		assertTrue(login.getUsername().equals("testuser"));
		assertTrue(login.getPassword().equals("testuser123"));
		assertTrue(login.validLogin());
	}
	
	@Test
	@DisplayName("Prove invalidity of logins due to username & password not being in the appropriate format")
	void shouldNotCreateLogin() {
		for(Login l : invalidLoginList()) {
			assertFalse(l.validLogin());
		}
	}
	
	private List<Login> invalidLoginList(){
		List<Login> list = new ArrayList<>();
		list.add(new Login("","")); // 1
		list.add(new Login("a","a")); // 2
		login.setPassword("tes"); // 3
		list.add(login);
		login.setPassword("123"); // 4
		list.add(login);
		login.setPassword("test"); // 5
		list.add(login);
		login.setPassword(password); // 6
		login.setUsername("tes");
		list.add(login);
		return list;
	}
	
	@Test
	@DisplayName("Should correctly check whether or not guest login exists in database, sucessfully insert guest login if it does not exist, and delete sucessfully from database")
	void shouldInteractWithDBCorrectlyGuestLogin() {
		assertFalse(guestDB.checkIfExists(login.getUsername(), login.getPassword()));
		guestDB.insertGuestLogin(login);
		assertTrue(guestDB.checkIfExists(login.getUsername(), login.getPassword()));
		guestDB.deleteGuestLogin(login);
		assertFalse(guestDB.checkIfExists(login.getUsername(), login.getPassword()));
	}
	
	@Test
	@DisplayName("Should correctly check whether or not admin login exists in database, sucessfully insert admin login if it does not exist, and delete sucessfully from database")
	void shouldInteractWithDBCorrectlyAdminLogin() {
		assertFalse(adminDB.checkIfExists(login.getUsername()));
		adminDB.insertAdminLogin(login);
		assertTrue(adminDB.checkIfExists(login.getUsername()));
		adminDB.deleteAdminLogin(login);
		assertFalse(adminDB.checkIfExists(login.getUsername()));
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("Login Test " + testCount + " completed.");
		testCount++;
	}
	
	@AfterAll
	static void tearDownAll() {
		System.out.println("Finished all Login-related tests.");
	}
}
