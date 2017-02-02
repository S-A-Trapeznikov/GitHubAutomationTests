package by.trapeznikov.tests.driver;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
	
	private static WebDriver driver;
	private static final Logger logger = LogManager.getRootLogger();
	private static final String WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";
	private static final String GECKODRIVER_PATH = ".\\drivers\\geckodriver.exe";
	
	private DriverSingleton(){};
	
	public static WebDriver getDriver(){
		if (null == driver){
			System.setProperty(WEBDRIVER_GECKO_DRIVER, GECKODRIVER_PATH);
			driver = new FirefoxDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			logger.info("Browser Firefox started");
			}
		return driver;
	}
	
	public static void closeDriver(){
		driver.close();
		driver = null;
	}
	

}
