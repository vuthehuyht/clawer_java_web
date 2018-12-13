package model.bean;

public class Shop {
	private String shopID;
	private String kindShop;
	private String shopName;
	private String adress;
	private String openingTimes;
	private String openingState;
	private String priceShipping;
	private String rating;
	private String reviewID;
	private String totalReview;



	public Shop(String kindShop, String shopName, String adress, String openingTimes, String openingState,
			String priceShipping, String rating, String totalReview) {
		super();
		this.kindShop = kindShop;
		this.shopName = shopName;
		this.adress = adress;
		this.openingTimes = openingTimes;
		this.openingState = openingState;
		this.priceShipping = priceShipping;
		this.rating = rating;
		this.totalReview = totalReview;
	}

	public String getShopID() {
		return shopID;
	}

	public void setShopID(String shopID) {
		this.shopID = shopID;
	}

	public String getKindShop() {
		return kindShop;
	}

	public void setKindShop(String kindShop) {
		this.kindShop = kindShop;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getOpeningTimes() {
		return openingTimes;
	}

	public void setOpeningTimes(String openingTimes) {
		this.openingTimes = openingTimes;
	}

	public String getOpeningState() {
		return openingState;
	}

	public void setOpeningState(String openingState) {
		this.openingState = openingState;
	}

	public String getPriceShipping() {
		return priceShipping;
	}

	public void setPriceShipping(String priceShipping) {
		this.priceShipping = priceShipping;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getReviewID() {
		return reviewID;
	}

	public void setReviewID(String reviewID) {
		this.reviewID = reviewID;
	}

	public String getTotalReview() {
		return totalReview;
	}

	public void setTotalReview(String totalReview) {
		this.totalReview = totalReview;
	}
}
