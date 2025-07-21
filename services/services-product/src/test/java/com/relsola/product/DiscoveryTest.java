package com.relsola.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.DiscoveryClient;

/**
 * DiscoveryTest
 *
 * @author relsola
 */
@SpringBootTest
public class DiscoveryTest {
    @Autowired
    DiscoveryClient discoveryClient;

    @Test
     void discoveryClientTest() {
        // This test will fail if the discovery client is not configured correctly
        // or if the application is not registered with the discovery service.
        discoveryClient.getServices().forEach(service -> {
            System.out.println("Service: " + service);
             discoveryClient.getInstances(service).forEach(instance -> {
                 System.out.println("Instance: " + instance.getServiceId() + " - " + instance.getHost() + ":" + instance.getPort());
             });

        });

    }
}
