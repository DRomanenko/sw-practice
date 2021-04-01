package com.github.dromanenko.swpractice.stage4.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import java.util.Hashtable;

public class HelloActivator implements BundleActivator {
    @Override
    public void start(final BundleContext context) throws Exception {
        Hashtable<String, String> props = new Hashtable<>();
        props.put("osgi.command.scope", "practice");
        props.put("osgi.command.function", "hello");
        context.registerService(HelloCommand.class, new HelloCommand(), props);
        System.out.println("Command started");
    }

    @Override
    public void stop(final BundleContext context) throws Exception {
        System.out.println("Command stopped");
    }
}
