package com.example.questionanddrink;

public class Question {
    private String question, answer;
    private Boolean asked;

    public Question(String question, String answer, Boolean asked) {
        this.question = question;
        this.answer = answer;
        this.asked = asked;
    }

    //Setter and Getter Methods
    public String getQuestion(){return question;}
    public void setQuestion(String question){this.question = question;}

    public String getAnswer(){return answer;}
    public void setAnswer(String answer){this.answer = answer;}

    public Boolean getAsked(){return asked;}
    public void setAsked(Boolean asked){this.asked = asked;}
}
