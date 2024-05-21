package com.theScore.qa.pages;

import java.io.IOException;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.theScore.qa.base.TestBase;

public class TheScoreTablePage extends TestBase {
	
	@FindBy(xpath= "//android.widget.TextView[@text=\"EPL\"]")
	WebElement TableTitle ;
	
	
    
	
    
	
    public TheScoreTablePage() throws IOException {
    	PageFactory.initElements(driver, this);
	}
    
    public String ValidateTablePageTitle() {
    	return TableTitle.getText();
    }

    public TheScoreHomePage BackAction() throws IOException {
    	driver.navigate().back();
    	return new TheScoreHomePage();
    }
		
    
    
}
