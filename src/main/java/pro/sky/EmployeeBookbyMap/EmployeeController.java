package pro.sky.EmployeeBookbyMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController (EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String hello () {
        return employeeService.hello();
    }

    @GetMapping(path = "/add")
    public String addEmployeee (@RequestParam ("firstName") String firstName, @RequestParam ("lastName") String lastName, @RequestParam ("salary") Integer salary) {
        return employeeService.addEmployee(firstName, lastName, salary);
    }

    @GetMapping(path = "/remove")
    public String removeEmployee (@RequestParam ("firstName") String firstName, @RequestParam ("lastName") String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public String findEmployee (@RequestParam ("firstName") String firstName, @RequestParam ("lastName") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }


    @GetMapping(path = "/all")
    public String allEmployees () {
        return employeeService.allEmployees();
    }

}
