package com.example.demo.bean;

public class PaperQuestion {

    private int id;
    private int paperId;
    private int questionId;
    private String type;

    public PaperQuestion() {
    }

    public PaperQuestion(int id, int paperId, int questionId, String type) {
        this.id = id;
        this.paperId = paperId;
        this.questionId = questionId;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
