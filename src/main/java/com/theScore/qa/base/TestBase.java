package com.theScore.qa.base;


import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import com.google.common.collect.ImmutableList;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;


public class TestBase {


	public static AndroidDriver driver; 
	public static Properties prop;
	
public TestBase() throws IOException {
		
		prop = new Properties();
		FileInputStream fi = new FileInputStream("C:\\QA\\SeleniumWorkSpace\\PremMaisuriya\\src\\main\\java\\com\\theScore\\qa\\config\\config.properties");
		prop.load(fi);
		
	}
	
	
	

	public static void longPress(WebElement ele) {
		
		Point Location = ele.getLocation();		
		PointerInput input = new PointerInput(PointerInput.Kind.TOUCH,"finger");
		Sequence sequence = new Sequence(input,0);
		
		sequence.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), Location.x,Location.y));
		sequence.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		sequence.addAction(input.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(),  Location.x,Location.y));
		sequence.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(ImmutableList.of(sequence));
		}

	protected static void swipe(Point start,Point end,Duration duration) {
		
		
		PointerInput input = new PointerInput(PointerInput.Kind.TOUCH,"finger");
		Sequence swipe = new Sequence(input,0);
		
		swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x,start.y));
		swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x,end.y));
		swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(ImmutableList.of(swipe));
		}


	public  void scroll(String pageDirection, double scrollRatio) {
		
		Duration SCROLL_DUR = Duration.ofMillis(3000);
		if(scrollRatio < 0 || scrollRatio>1) {
			throw new Error("Scroll distance must be between 0 to 1");
		}
		
		Dimension size = driver.manage().window().getSize();
//		System.out.println("Screen size = "+ size);
//		System.out.println("");
		
		Point midPoint = new Point((int)(size.width * 0.5),(int)(size.height * 0.5));
		
		int a = (int)(midPoint.x * scrollRatio);
		int b = (int)(midPoint.y * scrollRatio);
		
		int bottom = midPoint.y + (int)(midPoint.y * scrollRatio);
		int top = midPoint.y - (int)(midPoint.y * scrollRatio);
		int left = midPoint.x - (int)(midPoint.x * scrollRatio);
		int right = midPoint.x + (int)(midPoint.x * scrollRatio);
		
//		System.out.println("MidPoint ="+midPoint);
//		
//		System.out.println("MidPoint X ="+midPoint.x);
//		System.out.println("a ="+a);
//		
//		System.out.println("MidPoint Y ="+midPoint.y);
//		System.out.println("b ="+b);
//		
//		System.out.println("");
//		System.out.println("bottom ="+bottom);
//		System.out.println("top ="+top);
//		System.out.println("right"+right);
//		System.out.println("left ="+left);
//		System.out.println("-----------------");
		
		if(pageDirection == "UP") {
			//Swipe top to bottom then pahe will go UP
			
			swipe(new Point(midPoint.x,top), new Point(midPoint.x,bottom),SCROLL_DUR);
			
		}else if(pageDirection == "DOWN") {
			swipe(new Point(midPoint.x,bottom), new Point(midPoint.x,top),SCROLL_DUR);
		
		}else if(pageDirection == "LEFT") {
			swipe(new Point(left,midPoint.y), new Point(right,midPoint.y),SCROLL_DUR);
		
		}else{
			//RIGHT
			swipe(new Point(right,midPoint.y), new Point(left,midPoint.y),SCROLL_DUR);
		}
		
	}


		public void Initialization() throws MalformedURLException, InterruptedException  {
			UiAutomator2Options option = new UiAutomator2Options();
			option
			.setPlatformName(prop.getProperty("PlatformName"))
			.setPlatformVersion(prop.getProperty("PlatformVersion"))
			.setAutomationName(prop.getProperty("AutomationName"))
			.setDeviceName(prop.getProperty("DeviceName"))
			.setAppPackage(prop.getProperty("AppPackage"))
			.setAppActivity(prop.getProperty("AppActivity"))
			.setApp(System.getProperty("user.dir")+"/apps/TheScore.apk")
			.setNoReset(false);
			
			
			
			driver = new AndroidDriver(new URL(prop.getProperty("url")),option);
					
			Thread.sleep(3000);
			
			driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/action_button_text")).click();
			//Clicking on Get Start Button
			Thread.sleep(3000);
			
			scroll("DOWN",0.5);
			scroll("DOWN",0.5);
			
			driver.findElement(AppiumBy.xpath("//*[contains(@text,'UEFA Champions League')]")).click();
			driver.findElement(AppiumBy.xpath("//*[contains(@text,'England Soccer')]")).click();
			
			//Selecting Fav League
			Thread.sleep(3000);
			
			
			driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/btn_primary")).click();
			//Clicking on continue
			Thread.sleep(3000);
			
			List <WebElement> lo = driver.findElements(AppiumBy.id("com.fivemobile.thescore:id/btn_disallow"));
			
			if(lo.size() > 0) {
				lo.get(0).click();
			}
			//if if ask for location sharing click disallow
		    Thread.sleep(3000);
			
			driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/search_bar_placeholder")).click();
			
			driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/search_src_text")).sendKeys("Barcelona");
			// Searching Barcelona 
			Thread.sleep(5000);
			
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/txt_name\" and @text=\"FC Barcelona\"]")).click();
			//Clicking on Barcelona 
			
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/action_button_text\"]")).click();
			//Clicking on continue
			
			driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"com.fivemobile.thescore:id/btn_primary\"]")).click();
			//Clicking on continue
			
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/btn_secondary\"]")).click();
			//Clicking on May be later option
			Thread.sleep(2000);

			
			Alert al = driver.switchTo().alert();
			al.dismiss();
			
			
			//Clicking on Dont Allow 
			Thread.sleep(1000);
			
			
			
			List <WebElement> bl = driver.findElements(AppiumBy.id("com.fivemobile.thescore:id/dismiss_modal"));
			if(bl.size() > 0) {
				bl.get(0).click();
			}
			
			
			//click on close for Score Bet download
			
		   
		}

	

}
