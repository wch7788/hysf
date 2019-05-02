package com.example.demo.dto.paper;

public class NewPaperRequest {

    private String info;
    private String courseId;
    private int[] judgeList;
    private int[] choiceList;
    private int[] textList;

    public NewPaperRequest() {
    }

    public NewPaperRequest(String info, String courseId, int[] judgeList, int[] choiceList, int[] textList) {
        this.info = info;
        this.courseId = courseId;
        this.judgeList = judgeList;
        this.choiceList = choiceList;
        this.textList = textList;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int[] getJudgeList() {
        return judgeList;
    }

    public void setJudgeList(int[] judgeList) {
        this.judgeList = judgeList;
    }

    public int[] getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(int[] choiceList) {
        this.choiceList = choiceList;
    }

    public int[] getTextList() {
        return textList;
    }

    public void setTextList(int[] textList) {
        this.textList = textList;
    }
}
