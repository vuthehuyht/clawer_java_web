package controller;

import model.bo.ProcessLoginBO;
import model.dao.ProcessLoginDAO;

public class ProcessLoginController {
	private ProcessLoginBO loginBO;

	public ProcessLoginController(ProcessLoginBO loginBO, ProcessLoginDAO loginDAO) {
		this.loginBO = loginBO;
	}

	public void connectToWebPage(String url) {
		loginBO.connectToWebPage(url);
	}

	public void loginToWebPage(String userName, String password) throws InterruptedException {
		loginBO.login(userName,password);
	}
}
