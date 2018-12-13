package controller;

import model.bo.LoadMoreItemsBO;
import model.dao.LoadMoreItemsDAO;

public class LoadMoreItemsController {
	LoadMoreItemsBO loadItemsBO;
	LoadMoreItemsDAO loadItemsDAO;

	public LoadMoreItemsController(LoadMoreItemsBO loadItemsBO, LoadMoreItemsDAO loadItemsDAO) {
		super();
		this.loadItemsBO = loadItemsBO;
		this.loadItemsDAO = loadItemsDAO;
	}

	public void loadItems() {
		try {
		loadItemsBO.LoadMoreItems();
		}catch (Exception e) {
			System.out.println("error load items");
			// TODO: handle exception
		}
	}
}