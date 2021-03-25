package com.github.dromanenko.swpractice.stage3.service.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import com.github.dromanenko.swpractice.stage3.service.Hello;

@Component
public class Service implements Hello {
    @Override
    public void printHello() {
        System.out.println("Hello OSGi world!");
    }

    @Activate
    public void start() {
        System.out.println("Service started");
        printHello();
    }

    @Deactivate
    public void stop() {
        System.out.println("Service stopped");
    }

}