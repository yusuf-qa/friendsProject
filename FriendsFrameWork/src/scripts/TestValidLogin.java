package scripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestValidLogin extends BaseTest {
	@Test
	public void testValidLogin() {

		// org.apache.log4j.Logger log =
		// LogManager.getLogger(TestValidLogin.class.getName());
		// log.debug("Creating an object of LoginPage pom class");
		LoginPage lp = new LoginPage(driver);
		// log.info("Object is created successfully");
		// enter username
		// log.debug("Fetching username from excel file");
		String username = Lib.getCellValue("ValidLogin", 1, 0);
		// log.info("username is successfully fetched");
		lp.setUsername(username);
		// enter password
		String password = Lib.getCellValue("ValidLogin", 1, 1);
		lp.setPassword(password);
		// click on login button
		lp.clickLogin();

		// Expected Condition - Till the title of the home page is visible

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleIs("actiTIME - Enter Time-Track"));

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");

		sa.assertAll();
	}
}
