package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.LoginPage;

public class InvalidLogin extends BaseTest {

	@Test(priority=2)
	public void testInvalidLogin() {
		String un=Excel.getData(XL_PATH, "InvalidLogin", 1, 0);
		String pw=Excel.getData(XL_PATH, "InvalidLogin", 1, 1);
		String msg=Excel.getData(XL_PATH, "InvalidLogin", 1, 2);
		//Enter Valid User Name
		LoginPage l= new LoginPage(driver);
		l.setUserName(un);
		//Enter Valid Password
		l.setPassword(pw);
		//click on Login Button
		l.clickLogin();
		//verify that Home Page is Displayed
		l.waitTillErrMsgDisplayed(driver);
		l.verifyErrMsg(msg);
	}

}
