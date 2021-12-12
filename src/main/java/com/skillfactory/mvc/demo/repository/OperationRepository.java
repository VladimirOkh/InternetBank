package com.skillfactory.mvc.demo.repository;

import com.skillfactory.mvc.demo.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Integer> {

    Operation findByUsername(String username);
}
