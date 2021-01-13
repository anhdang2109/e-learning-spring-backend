package com.elearning.demo.category;

import com.elearning.demo.quiz.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/category")
public class CategoryController {
    @Autowired CategoryServiceImpl categoryService;
//    @Autowired
//    QuizServiceImpl quizService;
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public Iterable allQuiz() {
//        return quizService.findAllQuiz();
//    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable allCategory() {
        return categoryService.findAllCategory();
    }
    // Create Category
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Category createCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

}
