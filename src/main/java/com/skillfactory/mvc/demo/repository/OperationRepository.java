package com.skillfactory.mvc.demo.repository;

import com.skillfactory.mvc.demo.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OperationRepository extends JpaRepository<Operation, Integer> {

    Operation findByUsername(String username);
    List<Operation> findOperationsByUsername(String username);

}
