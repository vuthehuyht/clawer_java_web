package model.bo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.jdbc.Blob;

import model.bean.Items;
import model.bean.Review;
import model.bean.Shop;
import model.dao.ProcessScrapInfoDAO;
import util.Config;

public class ProcessScrapInfoBO {
	private ProcessScrapInfoDAO scrapInfoDAO;
	private WebDriver driver;
	private Shop shopInfo;
	private Review reviewInfo;
	private Items items;
	private ArrayList<Items> arrayListItems;

	public ProcessScrapInfoBO() {
		super();
		scrapInfoDAO = new ProcessScrapInfoDAO();
		driver = Config.getDriver();
		arrayListItems = new ArrayList<Items>();
	}

	public void scrapShopInfo(ArrayList<String> listItem) throws IOException {
		for (int i = 0; i < listItem.size(); i++) {
			String link = listItem.get(i);
			Document doc = Jsoup.connect(link).timeout(10000).get();
			
			String shopName = doc.select(".main-info-title h1").text();
			String kindShop = doc.select(".category .category-items a").text();
			String adress = doc.select(".res-common-add span").text();
			String openingState = doc.select(".micro-timesopen span:nth-child(2)").first().text();
			String openingTimes = doc.select(".micro-timesopen span:nth-child(3)").text();
			String priceShipping = doc.select(".res-common-minmaxprice span:nth-child(2)").first().text();
			String rating = doc.select(".microsite-points-summary .microsite-point-avg").text();
			String totalReview = doc.select(".microsite-review-count").text();
			
			String locationReview = doc.select(".micro-home-static table tbody tr:nth-child(2) td:nth-child(3) b").text();
			String priceReview = doc.select(".micro-home-static table tbody tr:nth-child(3) td:nth-child(3) b").text();
			String qualityReview = doc.select(".micro-home-static table tbody tr:nth-child(4) td:nth-child(3) b").text();
			String serviceReview = doc.select(".micro-home-static table tbody tr:nth-child(5) td:nth-child(3) b").text();
			String spaceReview = doc.select(".micro-home-static table tbody tr:nth-child(6) td:nth-child(3) b").text();
			
			setShopInfo(kindShop, shopName, adress, openingTimes, openingState, priceShipping, rating, totalReview);
			setReviewInfo(locationReview, priceReview, qualityReview, serviceReview, spaceReview);
			
			System.out.println(shopName + " | " + kindShop + " | " + adress + " | " + openingState + " | "
					+ openingTimes + " | " + priceShipping + " | " + rating + " | " + totalReview + "    " + locationReview + " " +  priceReview + " " + qualityReview + " " + serviceReview + " " + spaceReview);
		}
//		for (int i = 0; i < listItem.size(); i++) {
//			String link = listItem.get(i);
//			Document doc = Jsoup.connect(link).get();
//			String shopName = doc.getElementsByClass("main-info-title").get(0).getElementsByTag("h1").text();
//			String kindShop = doc.getElementsByClass("category-items").get(0).getElementsByTag("a").text();
//			String adress = doc.getElementsByClass("res-common-add").get(0).getElementsByTag("span").text();
//			String openingState = doc.getElementsByClass("micro-timesopen").get(0).getElementsByTag("span").get(1).text();
//			String openingTimes = doc.getElementsByClass("micro-timesopen").get(0).getElementsByTag("span").get(2).text();
//			String priceShipping = doc.getElementsByClass("res-common-minmaxprice").get(0).getElementsByTag("span").get(0).text();
//			String rating = doc.getElementsByClass("microsite-point-avg").text();
//			String totalReview = doc.getElementsByClass("microsite-review-count").text();
//
//			setShopInfo(kindShop, shopName, adress, openingTimes, openingState, priceShipping, rating, totalReview);
//
//			System.out.println(shopName + " | " + kindShop + " | " + adress + " | " + openingState + " | "
//					+ openingTimes + " | " + priceShipping + " | " + rating + " | " + totalReview);
//		}
	}

	public void scrapItem(ArrayList<String> linksItem) throws IOException {
		for (int i = 0; i < linksItem.size(); i++) {
			String linkItem = linksItem.get(i);
			driver.get(linkItem);
			try {
				//dòng này để delay điều hướng trang web
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<WebElement> listItemName = driver
					.findElements(By.cssSelector(".deli-name-food-detail .deli-title-name-food:nth-child(1) h3"));
			List<WebElement> listItemPrice = driver.findElements(By.cssSelector(".current-price span"));
			List<WebElement> listItemCount = driver.findElements(By.cssSelector(".deli-name-food-detail p span"));
			List<WebElement> listItemImgLink = driver.findElements(By.cssSelector(".img-food-detail a img"));
			System.out.println(
					"=====================================item" + i + "============================================");
			System.out.println(listItemName.size());
			for (int j = 0; j < listItemName.size(); j++) {
				String shopId = Integer.toString(i+1);
				String itemName = listItemName.get(j).getText();
				String itemPrice = listItemPrice.get(j).getText();
				String itemCount = listItemCount.get(j).getText();
				String itemImgLink = listItemImgLink.get(j).getAttribute("src");
				System.out.println(itemName + " " + itemCount + " " + itemPrice + "     " + itemImgLink);
				items = new Items(shopId, itemName, itemCount, itemImgLink, itemPrice);
//				arrayListItems.add(items);
				scrapInfoDAO.insertItemsToDatabase(items);
			}
		}
	}

	private void setShopInfo(String kindShop, String shopName, String adress, String openingTimes, String openingState,
			String priceShipping, String rating, String totalReview) {
		// TODO Auto-generated method stub
		shopInfo = new Shop(kindShop, shopName, adress, openingTimes, openingState, priceShipping, rating, totalReview);
		scrapInfoDAO.insertShopInfoToDatabase(shopInfo);
	}

	public void setReviewInfo(String locationReview, String priceReview, String qualityReview, String serviceReview,
			String spaceReview) {
		reviewInfo = new Review(locationReview, priceReview, qualityReview, serviceReview, spaceReview);
		scrapInfoDAO.insertReviewToDatabase(reviewInfo);
	}
}
