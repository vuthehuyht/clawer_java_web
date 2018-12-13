package controller;

import model.bo.LoadMoreItemsBO;
import model.bo.ProcessLoginBO;
import model.bo.ProcessScrapLinkBO;
import model.bo.ProcessScrapInfoBO;
import model.dao.LoadMoreItemsDAO;
import model.dao.ProcessLoginDAO;
import model.dao.ProcessScrapLinkDAO;
import model.dao.ProcessScrapInfoDAO;
import util.Config;
import view.ScrapLinkView;

public class ClawlerWebTest {
	public static void main(String[] args) {
		String url = "http://foody.vn/ha-noi";
		ScrapLinkView scrapLinkView = new ScrapLinkView();

		LoadMoreItemsBO loadItemsBO = new LoadMoreItemsBO();
		ProcessLoginBO loginBO = new ProcessLoginBO();
		ProcessScrapLinkBO scrapLinkBO = new ProcessScrapLinkBO();
		ProcessScrapInfoBO scrapShopBO = new ProcessScrapInfoBO();

		LoadMoreItemsDAO loadItemsDAO = new LoadMoreItemsDAO();
		ProcessLoginDAO loginDAO = new ProcessLoginDAO();
		ProcessScrapLinkDAO scrapLinkDAO = new ProcessScrapLinkDAO();
		ProcessScrapInfoDAO scrapInfoDAO = new ProcessScrapInfoDAO();

		ProcessScrapLinkController scrapLinkController = new ProcessScrapLinkController(scrapLinkBO, scrapLinkDAO,
				scrapLinkView);
		ProcessLoginController LoginController = new ProcessLoginController(loginBO, loginDAO);
		LoadMoreItemsController loadItemsController = new LoadMoreItemsController(loadItemsBO, loadItemsDAO);
		ProcessScrapInfoController scrapInfoController = new ProcessScrapInfoController(scrapShopBO, scrapInfoDAO);

		LoginController.connectToWebPage(url);
		try {
			LoginController.loginToWebPage(Config.USER_NAME, Config.PASSWORD);
		} catch (InterruptedException e) {
			System.out.println("error login");
			e.printStackTrace();
		}
		try {
			//dòng này để chờ cho đến khi hiện nút xem thêm sau khi đăng nhập 10 giây
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		loadItemsController.loadItems();
		try {
			scrapLinkController.scrapLink();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scrapInfoController.setArrayList(scrapLinkDAO.getLinkList());
		scrapInfoController.setArrayListItem(scrapLinkDAO.getLinkListItems());
		scrapInfoController.scrapInfoShop();
		scrapInfoController.scrapItem();
		
		Config.getDriver().close();
		Config.getDriver().quit();
	}
}