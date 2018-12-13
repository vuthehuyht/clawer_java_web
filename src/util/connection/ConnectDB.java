package util.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectDB {
	private static String url = "jdbc:mysql://localhost:3306/clawler_web?seUnicode=true&characterEncoding=utf-8";
	private static String user = "root";
	private static String password = "123456a@";
	private static Connection connect = null;
	private static PreparedStatement ps;
	static {
		try {
			initConnection();
		} catch (ClassNotFoundException e) {
			System.out.println("loi khoi tao driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("loi khoi tao ket noi");
			e.printStackTrace();
		}
	}

	private static void initConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager.getConnection(url, user, password);
		
		System.out.println("success connection");
	}

	public static Connection getConnection() {
		return connect;
	}

	public static void main(String[] args) {
//		Document doc;
//			try {
//				doc = Jsoup.connect("https://www.foody.vn/ha-noi/banh-trang-bo-hang-trong").timeout(18000).get();
//				System.out.println(doc);
//				Elements titles = doc.getElementsByClass("title-name-food");
//				Elements = doc.
//				for (Element element : titles) {
//					System.out.println(element.text());
//					System.out.println("thanh cong");
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
//		WebDriver driver = Config.getDriver();
//		driver.get("https://www.foody.vn/ha-noi/tra-sua-taster-s-choice-o-cho-dua/goi-mon");
//		System.out.println(driver.getPageSource().length());
//		List<WebElement> linkList = driver.findElements(By.cssSelector(".deli-name-food-detail .deli-title-name-food:nth-child(1) h3"));
//		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
//		for (int i = 0; i < linkList.size(); i++) {
//			String price = linkList.get(i).getText();
//			System.out.println(price);
//		}
//		driver.get("https://www.foody.vn/ha-noi/tra-sua-sharetea-nguyen-chi-thanh/goi-mon");
//		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
//		List<WebElement> linkList2 = driver.findElements(By.cssSelector(".deli-name-food-detail .deli-title-name-food:nth-child(1) h3"));
//		for (int i = 0; i < linkList2.size(); i++) {
//			String price = linkList2.get(i).getText();
//			System.out.println(price);
//		}
	}
}
