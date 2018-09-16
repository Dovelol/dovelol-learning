package com.dove.lol.dovelol.demo.date201809.demo20180916;

/**
 * @author Dovelol
 * @date 2018/9/16 10:12
 */
public enum SizeEnum {

    SMALL("S"),
    MEDIUM("M"),
    LARGE("L"),
    EXTRA_LARGE("XL");

    SizeEnum(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    private String abbreviation;

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
