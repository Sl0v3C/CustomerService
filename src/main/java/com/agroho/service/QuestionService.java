package com.agroho.service;

import com.agroho.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rezaul on 5/6/16.
 */
@Service
public interface QuestionService {

    public String saveQuestion(Question question);

}
