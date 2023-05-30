package com.hasanemo.mapper;

import com.hasanemo.dto.EmployeeDto;
import com.hasanemo.entity.Employee;

public class EmployeeMapper {

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(employeeDto.getId(), employeeDto.getName());
    }

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(employee.getId(), employee.getName());
    }

}
