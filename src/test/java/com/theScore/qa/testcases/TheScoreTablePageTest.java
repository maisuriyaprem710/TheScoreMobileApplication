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

public class TheScoreTablePageTest extends TestBase{
	TheScoreHomePage Hp;
	TheScoreEPLPage Ep; 
	TheScoreTablePage Tp;
	
	public TheScoreTablePageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void OpenHomePage() throws IOException, Exception    {
		Initialization();
		Hp = new TheScoreHomePage();
		Hp.OpenEnglishLeague();
		Ep = new TheScoreEPLPage();
		Ep.OpenTablePage();
		Tp = new TheScoreTablePage();
		}
	
	@Test(priority =1)
	public void VerifyTableTitletest() {
		String tabletitle = Tp.ValidateTablePageTitle();
		System.out.println(tabletitle);
		Assert.assertEquals(tabletitle, prop.getProperty("TablePageTitle"));
	}
	
	@Test(priority = 2)
	public void VerifyBackToHomeWorking() throws IOException {
		Hp =  Tp.BackAction();
	}
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
