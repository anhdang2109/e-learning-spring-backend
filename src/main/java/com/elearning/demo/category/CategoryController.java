package com.elearning.demo.category;

import com.elearning.demo.attempt.Attempt;
import com.elearning.demo.question.Question;
import com.elearning.demo.question.QuestionService;
import com.elearning.demo.quiz.Quiz;
import com.elearning.demo.quiz.QuizService;
import com.elearning.demo.study.Study;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private QuizService quizService;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/admin/categories")
    public List<Category> categories() {return categoryService.findAllCategory();}

    @GetMapping("/admin/categories/{id}")
    public Category findCategoryById(@PathVariable(value = "id") Long id) { return categoryService.findCategoryById(id); }

    @PostMapping("/admin/categories")
    public void saveCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
    }

    @PutMapping("/admin/categories/{id}")
    public void updateStudy(@PathVariable(value = "id") Long id, @RequestBody Category category) {
        category.setId(id);
        categoryService.saveCategory(category);
    }

    @DeleteMapping("/admin/categories/{id}")
    public Category deleteStudy(@PathVariable(value = "id") Long id) {
        Category category = categoryService.findCategoryById(id);
        List<Question> categoryQuestions = category.getQuestions();
//        for (Question question: categoryQuestions) {
//            question.setCategory(null);
//            questionService.saveQuestion(question);
//        }
        List<Quiz> categoryQuizzes = category.getQuizzes();
//        for (Quiz quiz: categoryQuizzes) {
//            quiz.setCategory(null);
//            quizService.saveQuiz(quiz);
//        }
        if (categoryQuestions.size() != 0) {
            return null;
        }
        if (categoryQuizzes.size() != 0) {
            return null;
        }
        categoryService.removeCategory(id);
        return category;
    }
}
