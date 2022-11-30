package com.koncert.ris.controllers;

import com.koncert.ris.dao.UporabnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/uporabniki")
public class UporabnikController {
    @Autowired
    private UporabnikRepository uporabnikDao;

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
}
