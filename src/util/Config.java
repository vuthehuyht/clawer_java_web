package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Config {
	private static WebDriver driver;
	public static final String USER_NAME = "duykb11a4@gmail.com";
	public static final String PASSWORD = "godcupid";

	public static final String DRIVER_TYPE = "webdriver.chrome.driver";
	public static final String DRIVER_LOACTION = "src\\util\\browser\\chromedriver.exe";

	// set default location and type of chrome driver
	static {
		System.setProperty(DRIVER_TYPE, DRIVER_LOACTION);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void prepareDriver(String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			System.out.println("error navigator and preparing driver");
			e.printStackTrace();
		}
	}

	// singleton design pattern
	public static WebDriver getDriver() {
		return driver;
	}
}
