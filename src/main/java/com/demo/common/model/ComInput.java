package com.demo.common.model;

import java.util.List;
import java.util.Map;

public class ComInput {
    private List<Map> inputList;
    private List<Map<String,List<String>>>  multiSelectList;
    private List<Map<String,Map>> rangeList;

    public List<Map> getInputList() {
        return inputList;
    }

    public void setInputList(List<Map> inputList) {
        this.inputList = inputList;
    }

    public List<Map<String, List<String>>> getMultiSelectList() {
        return multiSelectList;
    }

    public void setMultiSelectList(List<Map<String, List<String>>> multiSelectList) {
        this.multiSelectList = multiSelectList;
    }

    public List<Map<String, Map>> getRangeList() {
        return rangeList;
    }

    public void setRangeList(List<Map<String, Map>> rangeList) {
        this.rangeList = rangeList;
    }
}
