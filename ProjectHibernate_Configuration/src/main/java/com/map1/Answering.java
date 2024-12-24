package com.map1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answering {
    @Id
    @Column(name = "ans_id")
    private int ansId;

    private String answer;

    @ManyToOne
    private Questioning question;

    public int getAnsId() {
        return ansId;
    }

    public void setAnsId(int ansId) {
        this.ansId = ansId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Questioning getQuestion() {
        return question;
    }

    public void setQuestion(Questioning question) {
        this.question = question;
    }
}
