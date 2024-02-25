package redgirraffe.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;


import redgirraffepages.DashBoardPage;
import utils.AppUtils;
import utils.GenericMethods;

public class DashBoardTest extends AppUtils
{
	@Test(dependsOnGroups = "login")
	public void enterDetails() throws InterruptedException
	{
		DashBoardPage db=PageFactory.initElements(driver, DashBoardPage.class);
		db.click_card();
		GenericMethods.implicitWait(driver);
		db.enterAmount();
		GenericMethods.threadWait();
		db.enterQuantity();
		GenericMethods.threadWait();
		String totlaAmt=db.getAmount();
		System.out.println(totlaAmt);
		db.clickBuyNowBtn();
		String netAmt=db.getNetAmount();
		System.out.println(totlaAmt+"        "+netAmt);
		Assert.assertEquals(totlaAmt, netAmt);
	}

}
