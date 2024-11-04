package edu.miu.onboardingQuiz.demo.repository;

import edu.miu.onboardingQuiz.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findEmployeeByEmployeeId(int employeeId);
}
