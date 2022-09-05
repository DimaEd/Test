package com.ednach.form.service.impl;

import com.ednach.form.model.Question;
import com.ednach.form.repository.QuestionRepository;
import com.ednach.form.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    final QuestionRepository questionRepository;

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public List<Question> getAllQuestion(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Question> pagedResult = questionRepository.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Question findById(Integer id) {
        return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("question does not exist"));
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question update(Integer id, Question newAnswer) {

         return questionRepository.findById(id)
                .map(question -> {
                    question.setAnswer(newAnswer.getAnswer());
                    return questionRepository.save(question);
                }).orElseThrow(()->new RuntimeException("this question does not exist"));
    }

    @Override
    public void deleteQuestionById(Integer id) {
        questionRepository.deleteById(id);
    }

}
