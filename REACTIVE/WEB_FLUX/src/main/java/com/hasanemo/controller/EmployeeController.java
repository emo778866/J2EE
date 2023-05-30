package com.hasanemo.controller;


import com.hasanemo.dto.EmployeeDto;
import com.hasanemo.entity.Employee;
import com.hasanemo.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<EmployeeDto> saveRequestedEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PostMapping("/registerAll")
    @ResponseStatus(HttpStatus.CREATED)
    public Flux<EmployeeDto> saveAllRequestedEmployee(@RequestBody Iterable<Employee> employee) {
        return employeeService.saveAllEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.GONE)
    public Mono<Void> deleteRequestedEmployee(@PathVariable String id) {
        return employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Mono<EmployeeDto> getRequestedEmployee(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Employee> getAllEmployee() {
        return employeeService.findAllEmployee();
    }

    @GetMapping("/countAll")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Long> countTotalEmployee() {
        return employeeService.countTotalEmployee();
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Mono<EmployeeDto> updateEmployeeById(@RequestBody Employee employee) {
        return employeeService.updateEmployeeById(employee, employee.getId());
    }

}
