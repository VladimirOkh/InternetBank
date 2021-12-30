package com.skillfactory.mvc.demo.controller;

import com.skillfactory.mvc.demo.model.Client;
import com.skillfactory.mvc.demo.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private ClientRepository clientRepository;



    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(
            @AuthenticationPrincipal Client client,
            Map<String, Object> model){
        model.put("client", client);
        return "main";
    }

    @PostMapping("/main")
    public String clientInfo(
            @AuthenticationPrincipal Client client,
            Map<String, Object> model) throws NullPointerException{

        client = clientRepository.findByUsername(client.getUsername());

        clientRepository.save(client);

        model.put("client", client);

        return "main";
    }



}
