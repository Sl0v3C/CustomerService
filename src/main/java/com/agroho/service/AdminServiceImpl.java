package com.agroho.service;

import com.agroho.model.Question;
import com.agroho.repository.CustomQuestionRepository;
import com.agroho.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rezaul on 5/27/16.
 */
@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    CustomQuestionRepository customQuestionRepository;

    @Override
    public List<Question> getQuestionList() {

        List<Question> questions = questionRepository.findAll();

        return questions;
    }

    @Override
    public Question getQuestionById(Long id) {

        return customQuestionRepository.getQuestionByUserId(id);
    }

    @Override
    public Question submitAnswer(Question question) {
        return questionRepository.saveAndFlush(question);
    }

    @Override
    public List<Question> getAnsweredQuestionList() {
        return null;
    }

    @Override
    public Question getAnsweredQuestionById(int id) {
        return null;
    }
}
