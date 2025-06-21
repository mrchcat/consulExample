package com.github.mrchcat.service_a;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Optional;

@RestController
public class ControllerA {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/get-data")
    public String callServiceB() {
        return restTemplate.getForObject("http://serviceB/api/hello", String.class);
    }

    @GetMapping("/get-data2")
    public String callServiceB4() {
        Optional<URI> uri = discoveryClient.getInstances("serviceB")
                .stream()
                .findFirst()
                .map(ServiceInstance::getUri);
        System.out.println("вызываем="+ uri.get() + "/api/hello");
        return restTemplate.getForObject(uri.get() + "/api/hello", String.class);
    }


}

