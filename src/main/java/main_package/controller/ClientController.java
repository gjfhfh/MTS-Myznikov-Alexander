package main_package.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    private int field = 0;

    @GetMapping("/client/random-url")
    public String randomUrl() {
        field += 2; // Увеличиваем поле на 2
        return "Response from random URL";
    }

    public int getField() {
        return field;
    }
}
