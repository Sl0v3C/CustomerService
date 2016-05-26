package com.agroho.service;

import com.agroho.model.Question;
import com.agroho.repository.QuestionRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rezaul on 5/6/16.
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepositoryImpl askingQuestionRepository;

    @Override
    public String saveQuestion(Question question) {

        String questionFeedback = askingQuestionRepository.saveQuestion(question);

        return questionFeedback;
    }

    @Override
    public List<Question> getQuestionList() {
        return null;
    }
}
