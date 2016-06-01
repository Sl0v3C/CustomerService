package com.agroho.service;

import com.agroho.model.Question;
import com.agroho.repository.CustomQuestionRepository;
import com.agroho.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 * Created by rezaul on 5/27/16.
 */
@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    CustomQuestionRepository customQuestionRepository;

    @Override
    public List<Question> getQuestionList() {

       // List<Question> questions = questionRepository.findAll();
        List<Question> questions = questionRepository.getQuestionList();


        return questions;
    }

    @Override
    public Question getQuestionById(Long id) {

        return customQuestionRepository.getQuestionByUserId(id);
    }

    @Override
    public Question submitAnswer(Question question) {
        MimeMessage mail = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(question.getQuestionUserContact());
           // helper.setReplyTo("someone@localhost");
            helper.setFrom("rezaul@agroho.com");
            helper.setSubject(question.getQuestionSubject());
            helper.setText(question.getQuestionAnswer());
        } catch (MessagingException e) {
            e.printStackTrace();
        } finally {}
        mailSender.send(mail);


        return questionRepository.saveAndFlush(question);
    }

    @Override
    public List<Question> getAnsweredQuestionList() {
        return questionRepository.getAnsweredQuestionList();
    }

    @Override
    public Question getAnsweredQuestionById(int id) {
        return null;
    }
}
