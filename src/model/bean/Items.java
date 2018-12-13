package model.bean;

public class Items {
	private String itemId;
	private String shopID;
	private String itemName;
	private String numberOfOrder;
	private String imageLinkItem;
	private String price;

	public Items( String shopID, String itemName, String numberOfOrder, String imageLinkItem,
			String price) {
		super();
		this.shopID = shopID;
		this.itemName = itemName;
		this.numberOfOrder = numberOfOrder;
		this.imageLinkItem = imageLinkItem;
		this.price = price;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getShopID() {
		return shopID;
	}

	public void setShopID(String shopID) {
		this.shopID = shopID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getNumberOfOrder() {
		return numberOfOrder;
	}

	public void setNumberOfOrder(String numberOfOrder) {
		this.numberOfOrder = numberOfOrder;
	}

	public String getImageLinkItem() {
		return imageLinkItem;
	}

	public void setImageLinkItem(String imageLinkItem) {
		this.imageLinkItem = imageLinkItem;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
