package controller;

import java.util.ArrayList;

import model.bo.ProcessScrapLinkBO;
import model.dao.ProcessScrapLinkDAO;
import view.ScrapLinkView;

public class ProcessScrapLinkController {
	ProcessScrapLinkBO scrapLinkBO;
	ProcessScrapLinkDAO scrapLinkDAO;
	ScrapLinkView scrapLinkView;

	public ProcessScrapLinkController(ProcessScrapLinkBO scrapLinkBO, ProcessScrapLinkDAO scrapLinkDAO,
			ScrapLinkView scrapLinkView) {
		super();
		this.scrapLinkBO = scrapLinkBO;
		this.scrapLinkDAO = scrapLinkDAO;
		this.scrapLinkView = scrapLinkView;
	}

	public void scrapLink() throws InterruptedException {
		scrapLinkBO.scrapLink();
		ArrayList<String> links = this.scrapLinkBO.getScrapLinks();
		scrapLinkView.showLink(links);
	}
}
