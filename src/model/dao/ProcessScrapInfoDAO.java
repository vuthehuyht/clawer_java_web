package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Items;
import model.bean.Review;
import model.bean.Shop;
import util.connection.ConnectDB;

public class ProcessScrapInfoDAO {
	PreparedStatement ps = null;
	Connection connect = ConnectDB.getConnection();

	public void insertShopInfoToDatabase(Shop arrayListItems) {
		// statement
		String sql = "insert into clawler_web.shop_info(shop_name,shop_kind,adress,opening_time,opening_state,price_ship,rating,total_review) values (?,?,?,?,?,?,?,?);";
		// connection mysql
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, arrayListItems.getShopName());
			ps.setString(2, arrayListItems.getKindShop());
			ps.setString(3, arrayListItems.getAdress());
			ps.setString(4, arrayListItems.getOpeningTimes());
			ps.setString(5, arrayListItems.getOpeningState());
			ps.setString(6, arrayListItems.getPriceShipping());
			ps.setString(7, arrayListItems.getRating());
			ps.setString(8, arrayListItems.getTotalReview());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error sql statement");
			e.printStackTrace();

		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				System.out.println("error preparing sql for shop");
				e.printStackTrace();
			}
		}
	}

	public void insertReviewToDatabase(Review reviewInfo) {
		// TODO Auto-generated method stub
		String sql = "insert into clawler_web.review(review_location, review_quality,review_service, review_space) values(?,?,?,?);";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, reviewInfo.getLocationReview());
			ps.setString(2, reviewInfo.getQualityReview());
			ps.setString(3, reviewInfo.getServiceReview());
			ps.setString(4, reviewInfo.getSpaceReview());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				System.out.println("error preparing sql for review");
				e.printStackTrace();
			}
		}
	}

	public void insertItemsToDatabase(Items items) {
		String sql = "insert into clawler_web.item(shop_id,name,count,price,img_link) values(?,?,?,?,?)";
		try {
			ps = connect.prepareStatement(sql);
				ps.setInt(1,Integer.parseInt(items.getShopID()));
				ps.setString(2, items.getItemName());
				ps.setString(3, items.getNumberOfOrder());
				ps.setString(4, items.getPrice());
				ps.setString(5, items.getImageLinkItem());
				ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error sql statement for item");
			e.printStackTrace();

		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				System.out.println("error preparing sql for item");
				e.printStackTrace();
			}
		}
	}
}
