package model.bean;

public class Review {
	private String locationReview;
	private String priceReview;
	private String qualityReview;
	private String serviceReview;
	private String spaceReview;

	public Review(String locationReview, String priceReview, String qualityReview, String serviceReview,
			String spaceReview) {
		super();
		this.locationReview = locationReview;
		this.priceReview = priceReview;
		this.qualityReview = qualityReview;
		this.serviceReview = serviceReview;
		this.spaceReview = spaceReview;
	}

	public String getLocationReview() {
		return locationReview;
	}

	public void setLocationReview(String locationReview) {
		this.locationReview = locationReview;
	}

	public String getPriceReview() {
		return priceReview;
	}

	public void setPriceReview(String priceReview) {
		this.priceReview = priceReview;
	}

	public String getQualityReview() {
		return qualityReview;
	}

	public void setQualityReview(String qualityReview) {
		this.qualityReview = qualityReview;
	}

	public String getServiceReview() {
		return serviceReview;
	}

	public void setServiceReview(String serviceReview) {
		this.serviceReview = serviceReview;
	}

	public String getSpaceReview() {
		return spaceReview;
	}

	public void setSpaceReview(String spaceReview) {
		this.spaceReview = spaceReview;
	}

}
