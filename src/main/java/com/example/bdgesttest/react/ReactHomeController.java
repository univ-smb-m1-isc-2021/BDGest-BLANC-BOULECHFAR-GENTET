package com.example.bdgesttest.react;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReactHomeController {

    @GetMapping
    public String homePage() {
        return new InitialHtml("BDGest").serialize();
    }

}
