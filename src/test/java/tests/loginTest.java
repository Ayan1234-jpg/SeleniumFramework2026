package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.extentReportManager;
import utils.log;

public class loginTest extends BaseTest {
	
	@DataProvider(name="LoginData")
	public Object[][] getLoginData() throws IOException
	{
		String filePath = System.getProperty("user.dir")+"/TestData/TestData.xlsx";
		ExcelUtils.loadExcel(filePath, "Sheet1");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount-1][2];
		
		for(int i=1;  i<rowCount; i++)
		{
			data[i-1][0]=ExcelUtils.getCellData(i, 0); //username
			data[i-1][1]=ExcelUtils.getCellData(i, 1); //password
			
		}
		ExcelUtils.closeExcel();
		return data;
	}
	

	@Test(dataProvider="LoginData")
	public void testValidLogin(String username, String password)
	{
		log.info("Starting login test....");
		test = extentReportManager.createTest("Login Test");
		LoginPage loginPage = new LoginPage(driver);
		
		log.info("Enter creadential....");
		//loginPage.enterUsername("admin@yourstore.com");
		//loginPage.enterPassword("admin");
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		System.out.println("Title of the page is "+ driver.getTitle());
		log.info("Verifying page title");
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
		log.info("Completed Login test");
		test.info("Competed Login testcase");
	}
	
	/* @Test
	public void testinValidLogin()
	{
		log.info("Starting login test....");
		test = extentReportManager.createTest("Login with invalid creadential");
		LoginPage loginPage = new LoginPage(driver);
		
		log.info("Enter creadential....");
		loginPage.enterUsername("admin1234@yourstore.com");
		loginPage.enterPassword("admin");
		loginPage.clickLogin();
		System.out.println("Title of the page is "+ driver.getTitle());
		log.info("Verifying page title");
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
		log.info("Completed Login test");
		test.info("Competed Login testcase");
	}
	*/

}
