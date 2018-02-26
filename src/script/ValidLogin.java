package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.EnterTTPage;
import page.LoginPage;

public class ValidLogin  extends BaseTest {
	@Test(priority=1)
	public void testValidLogin() {
		String un=Excel.getData(XL_PATH, "ValidLogin", 1, 0);
		String pw=Excel.getData(XL_PATH, "ValidLogin", 1, 1);
		String eTitle=Excel.getData(XL_PATH, "ValidLogin", 1, 2);

		//Enter Valid User Name
		LoginPage l= new LoginPage(driver);
		l.setUserName(un);
		//Enter Valid Password
		l.setPassword(pw);
		//click on Login Button
		l.clickLogin();
		//verify that Home Page is Displayed
		EnterTTPage e=new EnterTTPage(driver);
		e.verifyPageIsDisplayed(driver, eTitle);
	}

}
