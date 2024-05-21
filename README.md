This is Maven Project using Page Object Model and Test Driven Framework developed using Java, Selenium, TestNG, Extent Reports.
I have used Java 11 and Appium2.0 and Appium-doctor and Appium-Inspector.
Can work on android physical device. This project was created with Android device having version 13.0.

How to use this framework?

Clone the repository to your workspace.
Open the config.properties under the src/main/java then com.theScore.qa.config.
Modify the data in config.properties file for passing the specification of your mobile device.
TheScore apk file is under Apps folder.
Start Appium2.0 from command line and then start Appium-Inspector.
Run the testng.xml file. You can even run as mvn test which will trigger the testng.xml
Each time after running the test, Extent Report will be generated. Refresh Project, go to test-output>Extent.html.This html file can be opened on any browser using its path.

How the framework works?
I have put all base,page,config and listener files in src/main/java. All tests are in src/test/java. 
BaseTest class has all scrolling, swiping and longpressing methods.It has constructor which load and fetch data from properties file in config.
BaseTest class has Initialization method which will directly open Home Page. Application opens everytime as new, from get start or login option page. I have made automatic code to go directly while selecting some league and some team to Home page.
On home page first English Soccer will open. After that Table will be click. Then go back will take to Home page. 

Test Scenarios:
1)HomePageTest : First account image is tested if displayed.Then click on English Soccer is done to check if it opens Correct League.
2)EPLPageTest: First Title of league is checked from screen. It verifies the title got from test with Title manually added in config file.Then click on Table happens to check if working.
3)tablePageTest: First table from which league is checked. It verifies the table title got from test with table Title manually added in config file. Then back option is checked if it carries to HomePage. 

Make sure that your appium server is up and running before starting the tests.
