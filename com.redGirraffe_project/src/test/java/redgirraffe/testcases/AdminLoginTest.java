package redgirraffe.testcases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import redgirraffepages.LoginPage;
import utils.AppUtils;
import utils.GenericMethods;

public class AdminLoginTest extends AppUtils
{
	@Test(priority = 1,dataProvider = "invalidLoginData")
	public void checkLogin(String uName,String password) throws InterruptedException
	{	
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		String emailRegex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
		String userName,pword;
		boolean res= lp.isLoginButtonDispalyed();
		Assert.assertTrue(res);
		lp.clickingLoginButton();
		lp.enterUsername(uName);
		lp.enterPassword(password);
		userName=lp.getUsername();
		pword=lp.getPassword();
		System.out.println(userName+"  "+pword);
	    Pattern pattern = Pattern.compile(emailRegex);
	    Matcher matcher = pattern.matcher(userName);
	    
	    if (matcher.matches()) {
            System.out.println("Valid email address");
            lp.LoginButton();
            String errorMsg=lp.getErrorMessage();
    		if(errorMsg.contains("No Account exists with the provided Email or Mobile Number."))
    		{
    			System.out.println("Error message is correct");
            } else {
                System.out.println("Error message is incorrect");
            }
    		lp.clickOK();
    		lp.clickX();
        } else {
        	GenericMethods.threadWait();
        	String errMsg=lp.getEmailErrorMessage();
            System.out.println(errMsg);
           // lp.clickOK();
            lp.clickX();
        }
	}
	@Test(priority = 2,dataProvider = "validLoginData",groups = "login")
	public void loginWithValidcredentials(String uName,String password)
	{
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		lp.clickingLoginButton();
		//lp.login("emmittdavis3316@redgirraffe.com", "1B4SF#K1Cj");
		lp.enterUsername(uName);
		lp.enterPassword(password);
		lp.LoginButton();
	}
	
	@DataProvider(name="validLoginData")
	public Object[][] addData()
	{
		Object[][] redData=new Object[1][2];
		
		redData[0][0]="emmittdavis3316@redgirraffe.com";
		redData[0][1]="1B4SF#K1Cj";
		

		return redData;
	}
	
	@DataProvider(name="invalidLoginData")
	public Object[][] getData()
	{
		return new Object[][] {{"emmittdavis3316@redgirraffe.com","admin123"},{"admin","1B4SF#K1Cj"},
			{"Admin","Admin123"},{"",""}};

	}
}
