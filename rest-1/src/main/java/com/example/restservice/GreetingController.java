package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private static final String template2 = "Your primary skill is %s and you are amazing at it.";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name, @RequestParam(value = "Skill", defaultValue = "baker") String skill) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name), skill);
	}

	@RequestMapping(value = "/greeting2/{name}/Skill/{skill}", method = RequestMethod.GET)
	public Greeting greeting2(@PathVariable(value = "name") String name, @PathVariable(value = "skill") String skill) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name), String.format(template2, skill));
	}
}
