package com.learn.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.learn.model.QuestionWrapper;
import com.learn.model.QuizDto;
import com.learn.model.Response;
import com.learn.service.QuizService;

import java.util.List;

@RestController
@RequestMapping("quiz")

public class QuizController {

    //@Autowired
    //QuizService quizService;
    
    private QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
    
    @GetMapping("/test")
    public ResponseEntity<String> test(){
    	System.out.println("GET METHOD on /test: test called here");
    	return new ResponseEntity<>("test success",HttpStatus.OK);
    }
    
    

    @PostMapping("/create")    
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
    	System.out.println("/quiz/create: createQuiz called here quizDto="+quizDto);
        return quizService.createQuiz(quizDto.getCategoryName(), quizDto.getNumQuestions(), quizDto.getTitle());
    }

    @PostMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
    	System.out.println("/get/id: getQuizQuestions called here");
    	return quizService.getQuizQuestions(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
    	System.out.println("/submit/id: submitQuiz called here");
    	return quizService.calculateResult(id, responses);
    }


}