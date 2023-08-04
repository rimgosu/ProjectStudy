package com.model;

public class reviewSelectDTO {

	private int reviewNum;
	private String reviewTitle;
	private String reviewContent;
	private int facilityNum;
	private String ID;
	
	private int fileNum;
	private String registerDate;
	private int reviewLike;
	private int reviewViews;
	private int reviewGrade;
	
	
	
	
	public int getReviewNum() {
		return reviewNum;
	}




	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}




	public String getReviewTitle() {
		return reviewTitle;
	}




	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}




	public String getReviewContent() {
		return reviewContent;
	}




	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}




	public int getFacilityNum() {
		return facilityNum;
	}




	public void setFacilityNum(int facilityNum) {
		this.facilityNum = facilityNum;
	}




	public String getID() {
		return ID;
	}




	public void setID(String iD) {
		ID = iD;
	}




	public int getFileNum() {
		return fileNum;
	}




	public void setFileNum(int fileNum) {
		this.fileNum = fileNum;
	}




	public String getRegisterDate() {
		return registerDate;
	}




	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}




	public int getReviewLike() {
		return reviewLike;
	}




	public void setReviewLike(int reviewLike) {
		this.reviewLike = reviewLike;
	}




	public int getReviewViews() {
		return reviewViews;
	}




	public void setReviewViews(int reviewViews) {
		this.reviewViews = reviewViews;
	}




	public int getReviewGrade() {
		return reviewGrade;
	}




	public void setReviewGrade(int reviewGrade) {
		this.reviewGrade = reviewGrade;
	}




	public reviewSelectDTO() {
		
	}




	public reviewSelectDTO(int reviewNum, String reviewTitle, String reviewContent, int facilityNum, String iD,
			int fileNum, String registerDate, int reviewLike, int reviewViews, int reviewGrade) {
		super();
		this.reviewNum = reviewNum;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.facilityNum = facilityNum;
		ID = iD;
		this.fileNum = fileNum;
		this.registerDate = registerDate;
		this.reviewLike = reviewLike;
		this.reviewViews = reviewViews;
		this.reviewGrade = reviewGrade;
	}
	
	
	
	
}
