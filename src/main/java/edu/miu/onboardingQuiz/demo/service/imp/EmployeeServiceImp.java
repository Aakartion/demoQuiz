package edu.miu.onboardingQuiz.demo.service.imp;

import edu.miu.onboardingQuiz.demo.model.Employee;
import edu.miu.onboardingQuiz.demo.repository.EmployeeRepository;
import edu.miu.onboardingQuiz.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        Optional<Employee> foundEmployee = employeeRepository.findEmployeeByEmployeeId(employeeId);
        if(foundEmployee.isPresent()){
            employeeRepository.delete(foundEmployee.get());
        }else {
            System.out.println("Employee not found");
        }
    }

    @Override
    public void updateEmployee(Employee employee, int employeeId) {
        Optional<Employee> foundEmployee = employeeRepository.findEmployeeByEmployeeId(employeeId);
        if(foundEmployee.isEmpty()) {
            System.out.println("Employee not found");
        }
        System.out.println("Employee  found");

        foundEmployee.ifPresent(
                emp-> {
                    emp.setEmployeeFirstName(employee.getEmployeeFirstName());
                    emp.setEmployeeLastName(employee.getEmployeeLastName());
                    emp.setEmployeeSalary(employee.getEmployeeSalary());
                    employeeRepository.save(emp);
                }
        );

        System.out.println("updated employee"+foundEmployee.get().getEmployeeFirstName());
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}
