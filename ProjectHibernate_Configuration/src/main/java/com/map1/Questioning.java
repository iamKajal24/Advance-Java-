package com.map1;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Questioning {
    @Id
    @Column(name = "ques_id")
    private int ques_id;

    private String questions;

   @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  //  @OneToMany(mappedBy = "question")
    private List<Answering> answers;

    public int getQues_id() {
        return ques_id;
    }

    public void setQues_id(int ques_id) {
        this.ques_id = ques_id;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public List<Answering> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answering> answers) {
        this.answers = answers;
    }
}
