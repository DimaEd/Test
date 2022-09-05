package com.ednach.form.controller;

import com.ednach.form.dto.QuestionDto;
import com.ednach.form.dto.requestDto.AnswerRequestDto;
import com.ednach.form.dto.requestDto.QuestionRequestDto;
import com.ednach.form.mapper.QuestionMapper;
import com.ednach.form.model.Question;
import com.ednach.form.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/question")

public class QuestionController {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/fullList")

    public List<QuestionDto> getAllQuestion() {
        List<Question> questionList = questionService.findAll();
        return questionList.stream().map(question -> questionMapper.createQuestionResponseDto(question))
                .collect(Collectors.toList());
    }

    @GetMapping()
    public List<QuestionDto> getQuestionsWithPagination(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        List<Question> questionList = questionService.getAllQuestion(pageNo, pageSize, sortBy);

        return questionList.stream()
                .map(question -> questionMapper.createQuestionResponseDto(question)).collect(Collectors.toList());
    }

    @PostMapping
    public QuestionDto createQuestion(@RequestBody QuestionRequestDto questionRequestDto) {

        return questionMapper.createQuestionResponseDto(questionService.save(questionMapper.createQuestion(questionRequestDto)));
    }

    @PutMapping("/{id}")
    public QuestionDto createAnswer(@RequestBody AnswerRequestDto answerRequestDto, @PathVariable Integer id) {

        return questionMapper.createQuestionResponseDto(questionService.update(id, questionMapper.createAnswer(answerRequestDto)));
    }

    @DeleteMapping("/{id}")
    public void deleteQuestionById(@PathVariable Integer id) {

        questionService.deleteQuestionById(id);
    }


}
