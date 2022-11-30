package com.koncert.ris.controllers;
import com.koncert.ris.dao.OcenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ocene")
public class OcenaController {
    @Autowired
    private OcenaRepository ocenaDao;

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
}
