package com.nnpia.cv01;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/*
 * @Controller is used to declare common web controllers which can return HTTP response but
 * @RestController is used to create controllers for REST APIs which can return JSON.
 *
 * XML uses tags to define the elements and stores data in a tree structure, whereas data in JSON is stored
 * like a map with key/value pairs. YAML, on the other hand, allows representation of data both in list or
 * sequence format and in the form of a map with key/value pairs. JSON and YAML uses different indentation
 * styles: JSON uses tabs, whereas YAML uses a hyphen (-) followed by whitespace.
 * */
@RestController
public class HelloController {
    @GetMapping("")
    public String helloWorld() {
        return "Hello world from Spring Boot application.";
    }

    @GetMapping("/path/{value}")
    public String helloWorldPathParameter(@PathVariable String value) {
        return "Parameter value: " + value;
    }

    @GetMapping("/query")
    public String helloWorldQueryParameter(@RequestParam String param) {
        return "Parameter value: " + param;
    }

    @PostMapping("/request_body")
    @ResponseStatus(value = HttpStatus.OK)
    public Person helloWorldRequestBody(@RequestBody Person person) {
        return person;
    }
}