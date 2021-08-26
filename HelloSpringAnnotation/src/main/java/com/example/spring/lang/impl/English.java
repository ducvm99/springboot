package com.example.spring.lang.impl;

import com.example.spring.lang.Language;

// Tiếng anh
public class English implements Language {
    @Override
    public String getGreeting() {
        return "Hello";
    }

    @Override
    public String getBye() {
        return "Bye bye";
    }
}
