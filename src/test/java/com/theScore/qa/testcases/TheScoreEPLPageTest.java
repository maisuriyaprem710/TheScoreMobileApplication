package com.theScore.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.theScore.qa.base.TestBase;
import com.theScore.qa.pages.TheScoreEPLPage;
import com.theScore.qa.pages.TheScoreHomePage;
import com.theScore.qa.pages.TheScoreTablePage;


public class TheScoreEPLPageTest extends TestBase{
	
	
	TheScoreHomePage Hp;
	TheScoreEPLPage Ep; 
	TheScoreTablePage Tp;
	
	public TheScoreEPLPageTest() throws IOException {
		super();
		
	}

	
	@BeforeMethod
	public void OpenHomePage() throws IOException, Exception    {
		Initialization();
		Hp = new TheScoreHomePage();
		Hp.OpenEnglishLeague();
		Ep = new TheScoreEPLPage();
		}
	
	@Test(priority =1)
	public void VerifyEPLTitleTest() {
		String title = Ep.ValidateEPLPageTitle();
		Assert.assertEquals(title, prop.getProperty("EPLPageTitle"));
	}
	
	@Test(priority =2)
	public void OpenTable() throws IOException  {
		Tp = Ep.OpenTablePage();
	}
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
}
