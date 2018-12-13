package model.bo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Config;

public class ProcessLoginBO extends Thread {
	private WebDriver driver;
	private Config c;
	private String url;
	private String userName;
	private String password;

	public ProcessLoginBO() {
		c = new Config();
		driver = Config.getDriver();
	}

	public String getUrl() {
		return url;
	}

	public void connectToWebPage(String url) {
		this.url = url;
		c.prepareDriver(this.url);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void login(String userName, String password) throws InterruptedException {
		this.userName = userName;
		this.password = password;
		driver.findElement(By.cssSelector(".fd-btn-login-new")).click();
		// waiting 5 sencond to loading page
		// login
		Thread.sleep(3000);
		driver.findElement(By.name("Email")).sendKeys(userName);
		driver.findElement(By.name("Password")).sendKeys(password);
		// click login
		driver.findElement(By.id("bt_submit")).click();
	}
	public void signup(String userName, String password) throws InterruptedException {
		
	}
}
