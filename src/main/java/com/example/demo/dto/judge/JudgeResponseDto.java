package com.example.demo.dto.judge;

public class JudgeResponseDto {

    private int id;
    private int questionId;
    private String question;
    private String answer;
    private String level;
    private String courseName;

    public JudgeResponseDto() {
    }

    public JudgeResponseDto(int id, int questionId, String question, String answer, String level, String courseName) {
        this.id = id;
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
        this.level = level;
        this.courseName = courseName;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
