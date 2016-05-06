package com.agroho.service;

import com.agroho.model.Question;
import com.agroho.repository.AskingQuestionRepositoriy;
import com.agroho.repository.AskingQuestionRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rezaul on 5/6/16.
 */
@Service
public class AskingQuestionServiceImpl implements AskingQuestionService {

    @Autowired
    AskingQuestionRepositoryImpl askingQuestionRepository;

    @Override
    public String saveQuestion(Question question) {

        String questionFeedback = askingQuestionRepository.saveQuestion(question);

        return questionFeedback;
    }
}
