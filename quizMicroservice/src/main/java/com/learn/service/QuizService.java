package com.learn.service;

import com.learn.model.QuestionWrapper;
import com.learn.model.Quiz;
import com.learn.model.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learn.dao.QuizDao;
import com.learn.feign.QuizInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    //@Autowired
    //QuizDao quizDao;
    
    private QuizDao quizDao;

    @Autowired
   public QuizService(QuizDao quizDao ) {
       this.quizDao = quizDao;
       
   }

    @Autowired
    QuizInterface quizInterface;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

    	System.out.println("inside createQuiz----");
    	
    	try {
    		
    		List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ).getBody();
    		
        
	        if(questions.isEmpty()) {
	        	
	        	System.out.println("EMPTY");
	    		return new ResponseEntity<>("QUESTIONS NOT FOUND", HttpStatus.NOT_FOUND);

	        }
	        else
	        {
		        Quiz quiz = new Quiz();
		        quiz.setTitle(title);
		        quiz.setQuestionIds(questions);
		        System.out.println("createQuiz----save here");
		        quizDao.save(quiz);
		
		        return new ResponseEntity<>("Success", HttpStatus.CREATED);
	        }
    	}
    	catch(Exception e)
    	{
    		System.out.println("Exception happened here:"+e.getMessage());
    		return new ResponseEntity<>("QUESTIONS NOT FOUND", HttpStatus.NOT_FOUND);
    	}
    	

  }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
          Quiz quiz = quizDao.findById(id).get();
          List<Integer> questionIds = quiz.getQuestionIds();
          ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);
          return questions;

    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        ResponseEntity<Integer> score = quizInterface.getScore(responses);
        return score;
    }
}
