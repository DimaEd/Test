package com.ednach.form.mapper;

import com.ednach.form.dto.QuestionDto;
import com.ednach.form.dto.requestDto.AnswerRequestDto;
import com.ednach.form.dto.requestDto.QuestionRequestDto;
import com.ednach.form.model.Question;
import org.springframework.stereotype.Component;

@Component
public class QuestionMapper {

    public Question createQuestion(QuestionRequestDto questionRequestDto) {
        return Question.builder()
                .question(questionRequestDto.getQuestion())
                .build();
    }

    public Question createAnswer(AnswerRequestDto answerRequestDto) {
        return Question.builder()
                .answer(answerRequestDto.getAnswer())
                .build();
    }

    public QuestionDto createQuestionResponseDto(Question entity) {
        return QuestionDto.builder()
                .id(entity.getId())
                .question(entity.getQuestion())
                .answer(entity.getAnswer())
                .build();
    }
}
