package com.github.dromanenko.swpractice.stage4.impl;

import com.github.dromanenko.swpractice.stage4.Hello;

import java.util.Arrays;
import java.util.Objects;

public class HelloCommand implements Hello {
    @Override
    public void hello(final String[] args) {
        if (args == null || args.length < 1 || Arrays.stream(args).anyMatch(Objects::isNull)) {
            System.err.println("Expected: 'practice:hello <params>'");
            return;
        }
        System.out.println("Hello, " + String.join(" ", args));
    }
}