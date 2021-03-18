package service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class HelloService implements BundleActivator {
    @Override
    public void start(BundleContext bundleContext) {
        System.out.println("Service started");
        bundleContext.registerService(Hello.class.getName(), new HelloImpl(), null);
    }

    @Override
    public void stop(BundleContext bundleContext) {
        System.out.println("Service stopped");
    }
}
