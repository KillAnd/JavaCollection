package pro.sky.JavaCollections.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.JavaCollections.Employee;
import pro.sky.JavaCollections.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employee/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping("/employee/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/employee/search")
    public Employee searchEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.searchEmployee(firstName, lastName);
    }

    @GetMapping("/employee")
    public Collection<Employee> searchAllEmployee() {
        return employeeService.searchAllEmployee();
    }
}