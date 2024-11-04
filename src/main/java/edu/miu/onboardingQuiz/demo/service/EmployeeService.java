package edu.miu.onboardingQuiz.demo.service;

import edu.miu.onboardingQuiz.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);
    void deleteEmployee(int employeeId);

    void updateEmployee(Employee employee, int employeeId);

    List<Employee> getAllEmployee();
}
