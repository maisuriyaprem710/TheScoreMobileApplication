package com.theScore.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.theScore.qa.base.TestBase;

public class TheScoreEPLPage extends TestBase{
	
	@FindBy(xpath= "//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/titleTextView\"]")
	WebElement Title ;
	
	
    @FindBy(xpath="//android.widget.LinearLayout[@content-desc=\"Table\"]")
	WebElement TableButton ;
	
    
	
    public TheScoreEPLPage() throws IOException {
    	PageFactory.initElements(driver, this);
	}


    public String ValidateEPLPageTitle() {
    	return Title.getText();
    }
    
    public TheScoreTablePage OpenTablePage() throws IOException {
    	TableButton.click();
    	return new TheScoreTablePage();
    }

}
