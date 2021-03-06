package com.springboot.sprint1.model;

import java.time.LocalDate;

public class Post {
	
	private int postId;
	private int userId;
	private int donorId;
	private LocalDate postDate;
	private String categoryName;
	private String userDescription;
	private float fundNeeded;
	private float fundCollected;
	
	public float getFundCollected() {
		return fundCollected;
	}
	public void setFundCollected(float fundCollected) {
		this.fundCollected = fundCollected;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getDonorId() {
		return donorId;
	}
	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}
	public LocalDate getPostDate() {
		return postDate;
	}
	public void setPostDate(LocalDate postDate) {
		this.postDate = postDate;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getUserDescription() {
		return userDescription;
	}
	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}
	public float getFundNeeded() {
		return fundNeeded;
	}
	public void setFundNeeded(float fundNeeded) {
		this.fundNeeded = fundNeeded;
	}
	
}
