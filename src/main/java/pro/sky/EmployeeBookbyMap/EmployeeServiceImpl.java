package pro.sky.EmployeeBookbyMap;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int MAX_EMPLOYEES = 15;
    private final Map<Employee, Integer> employees = new HashMap(Map.of(
            new Employee("Petr", "Petrov"), 26700,
            new Employee("Dima"," Dmitriev"), 46870,
            new Employee("Maxim", "Maximov"), 24650
    ));

    public String hello () {
        return "Добро пожаловать в программу!";
    }

    @Override
    public String addEmployee(String firstName, String lastName, int salary) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException();
        } else if (employees.containsKey(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee,salary);
        return "Сотрудник " + employee + " добавлен. Его зарплата: " + salary + "руб.";
    }

    @Override
    public String removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employees.remove(employee);
        return "Сотрудник " + employee + " удален.";
    }

    @Override
    public String findEmployee(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        if (!employees.containsKey(newEmployee)) {
               throw new EmployeeNotFoundException();
            }
         return "Сотрудник " + newEmployee + " найден";
    }

    @Override
    public String allEmployees() {
        for (Map.Entry <Employee, Integer> employees :employees.entrySet() ) {
            System.out.println("Сотрудник " + employees.getKey() + ":" + employees.getValue() + "руб.");
        }
        return "Список распечатан: " + employees;
    }
}
