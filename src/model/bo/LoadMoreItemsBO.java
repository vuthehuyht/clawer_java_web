package model.bo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Config;

public class LoadMoreItemsBO {
	private WebElement load_more_btn;

	public void LoadMoreItems() throws Exception {
		WebDriver driver = Config.getDriver();
		load_more_btn = driver.findElement(By.cssSelector("div .fd-btn-more"));
		while (load_more_btn.isDisplayed()) {
			load_more_btn.click();
		}
	}
}
