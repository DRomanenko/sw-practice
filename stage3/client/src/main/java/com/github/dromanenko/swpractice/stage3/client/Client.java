package com.github.dromanenko.swpractice.stage3.client;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import com.github.dromanenko.swpractice.stage3.service.Hello;

@Component
public class Client {
    @Reference
    private Hello hello;

    @Activate
    public void start() {
        System.out.println("Client started");
        hello.printHello();
    }

    @Deactivate
    public void stop() {
        System.out.println("Client stopped");
    }

}