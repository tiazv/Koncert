package com.koncert.ris.controllers;

import com.koncert.ris.dao.NastopajociRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nastopajoci")
public class NastopajociController {
    @Autowired
    private NastopajociRepository nastopajociDao;

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
