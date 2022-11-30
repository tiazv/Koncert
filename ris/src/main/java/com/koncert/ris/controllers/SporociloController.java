package com.koncert.ris.controllers;
import com.koncert.ris.dao.SporociloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sporocila")
public class SporociloController {
    @Autowired
    private SporociloRepository sporociloDao;

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
}
