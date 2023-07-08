package id.supriadi.sample.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(path = "v1")
public class commonController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Map<String, Object> greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        Map<String, Object> greeting = new HashMap();
        greeting.put("greetingId", counter.incrementAndGet());
        greeting.put("message", String.format(template, name));
        return greeting;
    }

}
