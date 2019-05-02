package com.example.demo.bean;

public class Text {

    private int id;
    private int questionId;
    private String question;
    private String answer;

    public Text() {
    }

    public Text(int id, int questionId, String question, String answer) {
        this.id = id;
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
