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


How the framework works?
I have put all base,page,config and listener files in src/main/java. All tests are in src/test/java. 
BaseTest class has all scrolling, swiping and longpressing methods.It has constructor which load and fetch data from properties file in config.
It also has Initialization method which will directly open Home Page. Application opens everytime as new, from get start or login option page. I have made automatic code to 


Data from excel sheet will be available as Hashtable parameter to your tests. You can fetch the value using data.get("columnnameinexcel") Refer the already existing tests for more details.
Make sure that your appium server is up and running before starting the tests.
