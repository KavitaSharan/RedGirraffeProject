package redgirraffepages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage
{

	//Define Elements
	@FindBy(name="uname")
	WebElement uid_element;
	
	@FindBy(name="password")
	WebElement pwd_element;
	
	@FindBy(xpath="//li//button[text()='Log In']")
	WebElement login_Button;
	
	@FindBy(xpath = "//button[@class='rentPayButton btn btn-default' and text()='Log In']")
	WebElement login_click;
	
	@FindBy(xpath="//div[@class='swal-text']")
	 WebElement errorMessage ;
	
	@FindBy(xpath="//*[@class='mat-error ng-tns-c67-2 ng-star-inserted']")
	 WebElement errorEmailMessage ;
	
	@FindBy(xpath="//button[text()='OK']")
	WebElement click_ok;
	
	@FindBy(xpath="//*[@mattooltip='Close']")
	WebElement click_wrongICon;
	
	//Define Methods
	public boolean isLoginButtonDispalyed()
	{
		if(login_Button.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	public boolean isLoginButtonPresent() {
          return login_Button.isDisplayed();
    }
	public void clickingLoginButton()
	{
    	login_Button.click();
	}
	public void enterUsername(String username) {
		uid_element.sendKeys(username);
    }
	public String getUsername() {
		return uid_element.getAttribute("value");
    }

    public void enterPassword(String password) {
    	pwd_element.sendKeys(password);
    }
    public String getPassword() {
    	return pwd_element.getAttribute("value");
    }
    public void LoginButton()
	{
    	login_click.click();
	}
    public String getErrorMessage() {
       
        return errorMessage.getText();
    }
    public String getEmailErrorMessage() {
        
        return errorEmailMessage.getText();
    }
    
    public void clickOK()
    {
    	click_ok.click();
    }
	
    public void clickX()
    {
    	click_wrongICon.click();
    }
}
