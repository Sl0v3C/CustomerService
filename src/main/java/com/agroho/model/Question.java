package com.agroho.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Created by rezaul on 5/1/16.
 */
@Entity
public class Question {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionId;

    private String questionTitle;

    private String questionDetails;

    private String questionSubject;

    private String questionUserName;

    private String questionUserContact;

    private int questionAnswered;

    @ManyToOne @Cascade(CascadeType.ALL)
    @JoinColumn(name = "adminId")
    private Admin admin;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionDetails() {
        return questionDetails;
    }

    public void setQuestionDetails(String questionDetails) {
        this.questionDetails = questionDetails;
    }

    public String getQuestionSubject() {
        return questionSubject;
    }

    public void setQuestionSubject(String questionSubject) {
        this.questionSubject = questionSubject;
    }

    public String getQuestionUserName() {
        return questionUserName;
    }

    public void setQuestionUserName(String questionUserName) {
        this.questionUserName = questionUserName;
    }

    public String getQuestionUserContact() {
        return questionUserContact;
    }

    public void setQuestionUserContact(String questionUserContact) {
        this.questionUserContact = questionUserContact;
    }

    public int getQuestionAnswered() {
        return questionAnswered;
    }

    public void setQuestionAnswered(int questionAnswered) {
        this.questionAnswered = questionAnswered;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
