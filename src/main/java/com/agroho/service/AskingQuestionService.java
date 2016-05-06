package com.agroho.service;

import com.agroho.model.Question;
import org.springframework.stereotype.Service;

/**
 * Created by rezaul on 5/6/16.
 */
@Service
public interface AskingQuestionService {

    public String saveQuestion(Question question);
}
