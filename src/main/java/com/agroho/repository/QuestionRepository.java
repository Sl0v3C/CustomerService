package com.agroho.repository;

import com.agroho.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rezaul on 5/6/16.
 */

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long>{

}
