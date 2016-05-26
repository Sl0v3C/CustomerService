package com.agroho.service;

import com.agroho.model.Question;
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

    @Override
    public String saveQuestion(Question question) {

        Question questionFeedback = questionRepository.saveAndFlush(question);
        String feedback = questionFeedback.getQuestionTitle();

        return feedback;
    }

    @Override
    public List<Question> getQuestionList() {
        return null;
    }

    @Override
    public Question getQuestionByUserContact(String contact) {
        return questionRepository.getQuestionByUserContact(contact);
    }
}
