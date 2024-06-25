package com.learn.model;


import lombok.Data;

@Data
public class QuizDto {
    String categoryName;
    Integer numQuestions;
    String title;
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * @return the numQuestions
	 */
	public Integer getNumQuestions() {
		return numQuestions;
	}
	/**
	 * @param numQuestions the numQuestions to set
	 */
	public void setNumQuestions(Integer numQuestions) {
		this.numQuestions = numQuestions;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
    
    
}
