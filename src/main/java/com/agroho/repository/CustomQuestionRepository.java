package com.agroho.repository;

import com.agroho.model.Question;
import org.springframework.stereotype.Repository;

/**
 * Created by rezaul on 5/26/16.
 */
@Repository
public interface CustomQuestionRepository {

    public Question getQuestionByUserId(Long id);
}
