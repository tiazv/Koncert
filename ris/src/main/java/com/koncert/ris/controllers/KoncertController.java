package com.koncert.ris.controllers;

import com.koncert.ris.dao.KoncertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/koncerti")

public class KoncertController {
    @Autowired
    private KoncertRepository koncertDao;

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
