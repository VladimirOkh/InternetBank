package com.skillfactory.mvc.demo.repository;

import com.skillfactory.mvc.demo.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface OperationRepository extends JpaRepository<Operation, Integer> {

    List<Operation> findOperationsByUsername(String username);
    List<Operation> findOperationsByDayIsBetween(Integer day1, Integer day2);
    List<Operation> findOperationsByDayAndMonthAndYear(Integer day, Integer month, Integer year);
}
