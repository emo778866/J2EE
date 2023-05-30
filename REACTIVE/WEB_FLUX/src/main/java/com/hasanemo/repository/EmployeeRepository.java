package com.hasanemo.repository;


import com.hasanemo.entity.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface EmployeeRepository extends ReactiveCrudRepository<Employee, String> {


}
