package pro.sky.JavaCollections.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pro.sky.JavaCollections.Employee;
import pro.sky.JavaCollections.EmployeeService;
import pro.sky.JavaCollections.Exceptions.ArrayIsFullException;
import pro.sky.JavaCollections.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.JavaCollections.Exceptions.EmployeeNotFoundException;

@RestController
@RequestMapping
public class EmployeeController {

    public EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employee/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            employeeService.addEmployee(firstName,lastName);
            return employee;
        } catch (ArrayIsFullException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Array is full");
        } catch (EmployeeAlreadyAddedException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Employee already added");
        }
    }

    @GetMapping("/employee/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            employeeService.removeEmployee(firstName,lastName);
            return employee;
        } catch (EmployeeNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
    }

    @GetMapping("/employee/search")
    public Employee searchEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeService.searchEmployee(firstName, lastName)) {
            return employee;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
    }
}
