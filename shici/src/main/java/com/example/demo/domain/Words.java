
package com.example.demo.domain;

public class Words {

    public String nicheng;
    public String words;

    public String getNicheng() {
        return nicheng;
    }

    public void setNicheng(String nicheng) {
        this.nicheng = nicheng;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public Words(String nicheng, String words) {
        this.nicheng = nicheng;
        this.words = words;
    }

    @Override
    public String toString() {
        return "Words{" +
                "nicheng='" + nicheng + '\'' +
                ", words='" + words + '\'' +
                '}';
    }
}
