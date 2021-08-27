package com.example.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/helloworld")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/helloworldbean")
    public HelloWorldBean helloworldbean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/helloworld/{name}")
    public HelloWorldBean helloworldbean(@PathVariable String name) {
        return new HelloWorldBean("Hello " + name);
    }
}
