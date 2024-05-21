package com.theScore.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.theScore.qa.base.TestBase;

public class TheScoreHomePage extends TestBase  {
	
	@FindBy(xpath="//android.widget.ImageButton")
	WebElement AccountButtonImg ;
	
	@FindBy(xpath="//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.fivemobile.thescore:id/horizontal_recycler_view\"]/android.view.ViewGroup[2]")
	WebElement EnglishLeague ;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/label\" and @text=\"BAR\"]")
	WebElement Barcelona ;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/label\" and @text=\"UCL\"]")
	WebElement UCL ;
	
	
	public TheScoreHomePage() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	
	public boolean ValidateAccountImg() {
		return AccountButtonImg.isDisplayed();
	}
	
	public TheScoreEPLPage OpenEnglishLeague() throws IOException {
		EnglishLeague.click();
		return new TheScoreEPLPage();
	}
	
	
}
