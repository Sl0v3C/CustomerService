package com.agroho.service;

import com.agroho.model.Question;
import com.agroho.repository.CustomQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agroho.repository.QuestionRepository;

import java.util.List;

/**
 * Created by rezaul on 5/6/16.
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    CustomQuestionRepository customQuestionRepository;

    @Override
    public String saveQuestion(Question question) {

        Question questionFeedback = questionRepository.saveAndFlush(question);
        String feedback = questionFeedback.getQuestionUserName();

        return feedback;
    }


}
