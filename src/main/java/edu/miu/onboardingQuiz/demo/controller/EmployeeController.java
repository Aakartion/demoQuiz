package edu.miu.onboardingQuiz.demo.controller;

import edu.miu.onboardingQuiz.demo.model.Employee;
import edu.miu.onboardingQuiz.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public String addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return "Employee is added";
    }

    @DeleteMapping("/{employeeId}")
    public String removeEmployee(@PathVariable("employeeId") int employeeId){
        employeeService.deleteEmployee(employeeId);
        return "Employee is deleted";
    }

    @PutMapping("/{employeeId}")
    public String updateEmployee(@RequestBody Employee employee, @PathVariable("employeeId") int employeeId){
        employeeService.updateEmployee(employee, employeeId);
        return "Employee is updated";
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployee();
    }

}
