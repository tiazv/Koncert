package com.koncert.ris.controllers;

import com.koncert.ris.dao.SkupinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skupine")
public class SkupinaController {
    @Autowired
    private SkupinaRepository skupinaDao;

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
}
