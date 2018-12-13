package controller;

import java.io.IOException;
import java.util.ArrayList;

import model.bo.ProcessScrapInfoBO;
import model.dao.ProcessScrapInfoDAO;

public class ProcessScrapInfoController {
	private ProcessScrapInfoBO scrapInfoBO;
	private ProcessScrapInfoDAO scrapInfoDAO;
	private ArrayList<String> arrayList;
	private ArrayList<String> arrayListItem;


	public ProcessScrapInfoController(ProcessScrapInfoBO scrapInfoBO, ProcessScrapInfoDAO scrapShopDAO) {
		super();
		this.scrapInfoBO = scrapInfoBO;
		this.scrapInfoDAO = scrapShopDAO;
	}

	public void setArrayList(ArrayList<String> linkList) {
		this.arrayList = linkList;
	}

	public void setArrayListItem(ArrayList<String> arrayListItem) {
		this.arrayListItem = arrayListItem;
	}

	public void scrapInfoShop() {
		try {
			scrapInfoBO.scrapShopInfo(arrayList);
		} catch (IOException e) {
			System.out.println("error scrap link");
			e.printStackTrace();
		}
	}
	public void scrapItem() {
		try {
			scrapInfoBO.scrapItem(arrayListItem);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
