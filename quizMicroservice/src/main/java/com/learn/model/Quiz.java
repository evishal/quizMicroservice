package com.learn.model;



import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import org.springframework.stereotype.Component;




@Component
@Entity
@Data
@Table(name = "quizbank")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ElementCollection
    private List<Integer> questionIds;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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

	/**
	 * @return the questionIds
	 */
	public List<Integer> getQuestionIds() {
		return questionIds;
	}

	/**
	 * @param questionIds the questionIds to set
	 */
	public void setQuestionIds(List<Integer> questionIds) {
		this.questionIds = questionIds;
	}
    
    

}
