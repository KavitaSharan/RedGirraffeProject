package redgirraffepages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage {
	
	@FindBy(xpath = "//button//span[text()='Close']")
	WebElement alerMsg;
	
	@FindBy(xpath = "//div[text()='API TESTING - Voucher code']")
	WebElement apiTesting_voucher;
	
	@FindBy(xpath = "//div[@class='custom_prices' and text()=' 1000']")
	WebElement amount;
	
	@FindBy(xpath = "//input[@name='quantity']")
	WebElement quantity;
	
	@FindBy(xpath="//div//span[contains(text(),'Net Amount')]/following::div//span[@class='text-bold']")
	//(//div//span[contains(text(),'Total value of CHECKOUT')]/following::div[@class='col-md-2 col-2 p-0']//span[@class='text-bold'])[1]
	WebElement tot_amt;
	
	@FindBy(xpath = "//button//span[contains(text(),'Buy Now')]")
	WebElement click_buyNow;
	
	@FindBy(xpath="//div[contains(text(),'Net Amount')]/following-sibling::div//span")
	WebElement  net_amt;
	
	public void click_card()
	{
		if(alerMsg.isDisplayed())
		{
			alerMsg.click();
			apiTesting_voucher.click();
		}
		else
			apiTesting_voucher.click();
	}

	public void enterAmount()
	{
		amount.click();
	}
	public void enterQuantity()
	{
		quantity.clear();
		quantity.sendKeys("2",Keys.ENTER);
	}
	public String getAmount()
	{
		String amount=tot_amt.getText();
		return amount;
	}
	public void clickBuyNowBtn()
	{
		click_buyNow.click();
	}
	public String getNetAmount()
	{
		String amount=net_amt.getText();
		return amount;
	}
}
