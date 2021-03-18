package client;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import service.Hello;

public class HelloClient implements BundleActivator {
    // Modif solution from http://gg.gg/oqsa4
    // without "Unchecked assignment: 'org.osgi.framework.ServiceReference'
    // to 'org.osgi.framework.ServiceReference<java.lang.Object>'"
    @Override
    public void start(BundleContext bundleContext) {
        System.out.println("Client started");
        ServiceReference<Hello> reference = bundleContext.getServiceReference(Hello.class);
        bundleContext.getService(reference).printHello();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        System.out.println("Client stopped");
    }
}
