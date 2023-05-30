package com.hasanemo.services.impl;

import com.hasanemo.dto.EmployeeDto;
import com.hasanemo.entity.Employee;
import com.hasanemo.exception.IdNotFoundException;
import com.hasanemo.mapper.EmployeeMapper;
import com.hasanemo.repository.EmployeeRepository;
import com.hasanemo.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Mono<EmployeeDto> saveEmployee(Employee employee) {
        return employeeRepository.save(employee)
                .map(EmployeeMapper::mapToEmployeeDto);
    }

    @Override
    public Flux<EmployeeDto> saveAllEmployee(Iterable<Employee> entities) {
        return employeeRepository.saveAll(entities)
                .map(EmployeeMapper::mapToEmployeeDto);
    }

    @Override
    public Mono<EmployeeDto> getEmployeeById(String employeeId) {
        return employeeRepository.findById(employeeId)
                .switchIfEmpty(Mono.error(new IdNotFoundException("Invalid Id")))
                .map(EmployeeMapper::mapToEmployeeDto);
    }

    @Override
    public Mono<Void> deleteEmployeeById(String employeeId) {
        return employeeRepository.findById(employeeId)
                .switchIfEmpty(Mono.error(new IdNotFoundException("Invalid Id")))
                .flatMap(employeeRepository::delete);
    }

    @Override
    public Flux<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Mono<Long> countTotalEmployee() {
        return employeeRepository.count();
    }

    @Override
    public Mono<EmployeeDto> updateEmployeeById(Employee employee, String employeeId) {
        return employeeRepository.findById(employeeId)
                .switchIfEmpty(Mono.error(new IdNotFoundException("Invalid Id")))
                .flatMap(existingEmployee -> {
                    existingEmployee.setName(employee.getName());
                    return employeeRepository.save(existingEmployee);
                })
                .map(EmployeeMapper::mapToEmployeeDto);
    }
}
