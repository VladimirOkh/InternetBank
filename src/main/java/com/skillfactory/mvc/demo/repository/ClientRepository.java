package com.skillfactory.mvc.demo.repository;

import com.skillfactory.mvc.demo.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findByUsername(String username);
}
