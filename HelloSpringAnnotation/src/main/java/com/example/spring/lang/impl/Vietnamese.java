package com.example.spring.lang.impl;

import com.example.spring.lang.Language;

public class Vietnamese implements Language {
    @Override
    public String getGreeting() {
        return "Xin chao";
    }

    @Override
    public String getBye() {
        return "Tam biet";
    }
}
