package com.agroho.service;

import com.agroho.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rezaul on 5/27/16.
 */
@Service
public interface AdminService {

    public List<Question> getQuestionList();

    public Question getQuestionById(Long id);

    public Question submitAnswer(Question question);

    public List<Question> getAnsweredQuestionList();

    public Question getAnsweredQuestionById(int id);
}
