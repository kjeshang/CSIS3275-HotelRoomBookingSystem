package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Control.AdminDB;
import Model.Admin.AdminInfo;

class AdminTest {

	private AdminDB adminDb;
	private static int testCount;
	private AdminInfo adminInfo;
	
	@BeforeAll
	static void setupAll() {
		System.out.println("Initializing Admin-related tests.");
		testCount = 1;
	}
	
	@BeforeEach
	void setup() {
		adminDb = new AdminDB();
	}
	
	@Test
	@DisplayName("Validate Admin Info")
	public void validateAdminInfo(){
		adminInfo = new AdminInfo("","","","","");
		assertFalse(adminInfo.validInfo());
		adminInfo =  new AdminInfo("FIRST_NAME","","","","");
		assertFalse(adminInfo.validInfo());
		adminInfo =  new AdminInfo("FIRST_NAME","LAST_NAME","","","");
		assertFalse(adminInfo.validInfo());
		adminInfo =  new AdminInfo("FIRST_NAME","LAST_NAME","ADDRESS","","");
		assertFalse(adminInfo.validInfo());
		adminInfo =  new AdminInfo("FIRST_NAME","LAST_NAME","ADDRESS","EMAIL","");
		assertFalse(adminInfo.validInfo());
		adminInfo =  new AdminInfo("FIRST_NAME","LAST_NAME","ADDRESS","EMAIL","PHONE");
		assertFalse(adminInfo.validInfo());
		// Valid AdminInfo with valid Email and Phone
		adminInfo =  new AdminInfo("FIRST_NAME","LAST_NAME","ADDRESS","EMAIL@domain.com","1234567890");
		assertTrue(adminInfo.validInfo());
	}


	@Test
	@DisplayName("Successfully insert admin Info and verify it")
	void shouldInteractWithDBCorrectlyAdminInfo() {
		adminDb.insertAdmin(getAdminInfo());
		System.out.println(adminDb.findAdmin(getAdminInfo()));
		assertTrue(adminDb.findAdmin(getAdminInfo()).contains(getAdminInfo().getEmail()));
		adminDb.deleteAdminInfo(getAdminInfo().getPhone());
	}

	private AdminInfo getAdminInfo() {
		AdminInfo adminInfo = new AdminInfo("ADMIN_FIRSTNAME","ADMIN_LASTnAME","ADMIN_ADDRESS",
				"ADMIN@EMAIL.COM","1234567890");
		return adminInfo;
	}


	@AfterEach
	void tearDown() {
		System.out.println("Test " + testCount + " completed.");
		testCount++;
	}

	@AfterAll
	static void tearDownAll() {
		System.out.println("Finished all Admin-related tests.");
	}

}
