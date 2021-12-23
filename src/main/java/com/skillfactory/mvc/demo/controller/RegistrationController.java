package com.skillfactory.mvc.demo.controller;
import com.skillfactory.mvc.demo.model.Client;
import com.skillfactory.mvc.demo.model.Role;
import com.skillfactory.mvc.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {


    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addClient(Client client, Map<String, Object> model) {
        try {
            client.setBalance(0);
            client.setRoles(Collections.singleton(Role.USER));
            clientRepository.save(client);
        }catch (Exception e) {
            model.put("message1","Username already registered!");
            return "registration";
        }

        return "redirect:/login";
    }
}