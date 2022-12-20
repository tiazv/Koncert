package com.koncert.ris.controllers;

import com.koncert.ris.models.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
//@RequestMapping("/posljiEmail")

public class EmailServiceController {

    @Autowired
    private EmailService emailDao;

    @PostMapping("/posljiMail")
    public boolean poslji(@RequestBody Map<String, Object> podatki){
        System.out.println(podatki);
        return emailDao.sendMail(podatki.get("recipient").toString(), podatki.get("subject").toString(), podatki.get("body").toString());
    }


}
