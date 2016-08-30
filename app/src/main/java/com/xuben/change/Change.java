package com.xuben.change;

import java.io.Serializable;

/**
 * Created by B58862 on 8/30/2016.
 */
public class Change implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String txt1;
    private String txt2;
    private String isBold;
    private String wordSize;

    public Change() {

    }

    public Change(String txt1, String txt2, String isBold, String wordSize) {
        this.txt1 = txt1;
        this.txt2 = txt2;
        this.isBold = isBold;
        this.wordSize = wordSize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText1() {
        return txt1;
    }

    public void setText1(String txt1) {
        this.txt1 = txt1;
    }

    public String getText2() {
        return txt2;
    }

    public void setText2(String txt2) {
        this.txt2 = txt2;
    }

    public String getBold() {
        return isBold;
    }

    public void setBold(String isBold) {
        this.isBold = isBold;
    }

    public String getWordSize() {
        return wordSize;
    }

    public void setWordSize(String wordSize) {
        this.wordSize = wordSize;
    }
}
