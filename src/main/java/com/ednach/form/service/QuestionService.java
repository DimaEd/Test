package com.ednach.form.service;

import com.ednach.form.model.Question;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface QuestionService {
    List<Question> findAll();

    List<Question> getAllQuestion(Integer pageNo, Integer pageSize, String sortBy);

    Question findById(Integer id);

    Question save(Question question);

    Question update(Integer id, Question question);

    void deleteQuestionById(Integer id);

}
