package com.example.Employee.service;

import com.example.Employee.Employee;
import com.example.Employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeMethodsImpl implements EmployeeMethods {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeMethodsImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> showAllEmployee() {

        return this.employeeRepository.employeeInfo();
    }


    @Override
    public Optional<Employee> employeeInfo(int id) {
        return employeeRepository.getById(id);


    }
}
