package com.model;

public class reviewDTO {

	private String reviewTitle;
	private String reviewContent;
	private int reviewGrade;
	private String ID;
	private int fileNum;
	private int facilityNum;
	
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
	public int getReviewGrade() {
		return reviewGrade;
	}
	public void setReviewGrade(int reviewGrade) {
		this.reviewGrade = reviewGrade;
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
	public int getFacilityNum() {
		return facilityNum;
	}
	public void setFacilityNum(int facilityNum) {
		this.facilityNum = facilityNum;
	}
	public reviewDTO(String reviewTitle, String reviewContent, int reviewGrade, String iD, int fileNum,
			int facilityNum) {
		super();
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewGrade = reviewGrade;
		ID = iD;
		this.fileNum = fileNum;
		this.facilityNum = facilityNum;
	}
	

	
	
	
}
