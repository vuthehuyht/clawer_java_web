package model.bo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import model.dao.ProcessScrapLinkDAO;
import util.Config;

public class ProcessScrapLinkBO extends Thread {
	private ProcessScrapLinkDAO scrapLinkDAO;
	private ArrayList<String> links;
	private ArrayList<String> linksItem;
	private WebDriver driver;

	public ProcessScrapLinkBO() {
		this.scrapLinkDAO = new ProcessScrapLinkDAO();
		links = scrapLinkDAO.getLinkList();
		linksItem = scrapLinkDAO.getLinkListItems();
		driver = Config.getDriver();
	}

	public void scrapLink() {
		List<WebElement> linkList = driver.findElements(By.cssSelector(".content-item .avatar > a"));
		for (int i = 0; i < linkList.size(); i++) {
			String link = linkList.get(i).getAttribute("href");
			if (link.contains("ha-noi/")) {
				links.add(link);
				linksItem.add(link + "/goi-mon");
			}
		}
	}

	public ArrayList<String> getScrapLinks() {
		return links;
	}

	public ArrayList<String> getScrapLinksItem() {
		return linksItem;
	}
}
