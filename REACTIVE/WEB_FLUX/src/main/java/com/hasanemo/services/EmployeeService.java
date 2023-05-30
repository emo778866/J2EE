package com.hasanemo.services;

import com.hasanemo.dto.EmployeeDto;
import com.hasanemo.entity.Employee;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public interface EmployeeService {

    Mono<EmployeeDto> saveEmployee(Employee employee);

    Flux<EmployeeDto> saveAllEmployee(Iterable<Employee> entities);

    Mono<EmployeeDto> getEmployeeById(String employeeId);

    Mono<Void> deleteEmployeeById(String employeeId);

    Flux<Employee> findAllEmployee();

    Mono<Long> countTotalEmployee();

    Mono<EmployeeDto> updateEmployeeById(Employee employee, String employeeId);

}
