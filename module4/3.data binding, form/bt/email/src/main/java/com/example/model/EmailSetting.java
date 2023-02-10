package com.example.model;

public class EmailSetting {
    private String languages;
    private String size;
    private String filter;
    private String signature;

    public EmailSetting() {
    }

    public EmailSetting(String languages, String size, String filter, String signature) {
        this.languages = languages;
        this.size = size;
        this.filter = filter;
        this.signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
