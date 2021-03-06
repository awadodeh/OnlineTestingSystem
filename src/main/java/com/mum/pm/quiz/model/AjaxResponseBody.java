package com.mum.pm.quiz.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class AjaxResponseBody {
    @JsonProperty("msg")
    @XmlElement(required = true)
    String msg;
    List<QuestionSet> result;
    List<Integer> selectedAnswer = new ArrayList<Integer>();
    @JsonProperty("subCategoryNames")
    String category = "";

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public List<Integer> getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(List<Integer> selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<QuestionSet> getResult() {
        return result;
    }

    public void setResult(List<QuestionSet> result) {
        this.result = result;
    }

}
