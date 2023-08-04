package com.model;

public class commentDTO {

	private int commentNum;
	private String commentContent;
	private String ID;
	private int reviewNum;
	private String registerDate;
	private int commentLikeNum;
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public int getReviewNum() {
		return reviewNum;
	}
	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public int getCommentLikeNum() {
		return commentLikeNum;
	}
	public void setCommentLikeNum(int commentLikeNum) {
		this.commentLikeNum = commentLikeNum;
	}
	public commentDTO(int commentNum, String commentContent, String iD, int reviewNum, String registerDate,
			int commentLikeNum) {
		super();
		this.commentNum = commentNum;
		this.commentContent = commentContent;
		ID = iD;
		this.reviewNum = reviewNum;
		this.registerDate = registerDate;
		this.commentLikeNum = commentLikeNum;
	}
	
	
	
}
