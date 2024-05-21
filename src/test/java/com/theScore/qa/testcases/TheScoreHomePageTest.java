package com.theScore.qa.testcases;





import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.theScore.qa.base.TestBase;
import com.theScore.qa.pages.TheScoreEPLPage;
import com.theScore.qa.pages.TheScoreHomePage;




public class TheScoreHomePageTest extends TestBase  {
	
	TheScoreHomePage Hp;
	TheScoreEPLPage Ep;
	
	public TheScoreHomePageTest() throws IOException {
		super();
		
	}


	@BeforeMethod
	public void OpenHomePage() throws IOException, Exception    {
		Initialization();
		Hp = new TheScoreHomePage();
		}	 
	
	
	@Test(priority =1)
	public void AccountImgTest() {
		boolean flag = Hp.ValidateAccountImg();
		Assert.assertTrue(flag);
	}
	
	@Test(priority =2)
	public void OpenLeague() throws IOException  {
		Ep = Hp.OpenEnglishLeague();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
