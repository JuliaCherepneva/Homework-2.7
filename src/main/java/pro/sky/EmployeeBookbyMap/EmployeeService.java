package pro.sky.EmployeeBookbyMap;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    String hello();
    String addEmployee(String firstName, String lastName, int salary);
    String removeEmployee(String firstName, String lastName);
    String findEmployee(String firstName, String lastName);
    String allEmployees();
}
