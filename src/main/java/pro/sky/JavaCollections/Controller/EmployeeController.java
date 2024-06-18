package pro.sky.JavaCollections.Controller;

import org.apache.commons.lang3.StringUtils;
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


    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        if (StringUtils.isAlphaSpace(firstName) && StringUtils.isAlphaSpace(lastName)) {
            if (Character.isUpperCase(firstName.charAt(0)) && Character.isUpperCase(lastName.charAt(0))) {
                return employeeService.addEmployee(firstName, lastName);
            } else {
                throw new RuntimeException("Имя и фамилия не с большой буквы");
            }
        } else {
            throw new RuntimeException("Используйте только буквы");
        }
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        if (StringUtils.isAlphaSpace(firstName) && StringUtils.isAlphaSpace(lastName)) {
            if (Character.isUpperCase(firstName.charAt(0)) && Character.isUpperCase(lastName.charAt(0))) {
                return employeeService.removeEmployee(firstName, lastName);
            } else {
                throw new RuntimeException("Имя и фамилия не с большой буквы");
            }
        } else {
            throw new RuntimeException("Используйте только буквы");
        }

    }

    @GetMapping("/search")
    public Employee searchEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        if (StringUtils.isAlphaSpace(firstName) && StringUtils.isAlphaSpace(lastName)) {
            if (Character.isUpperCase(firstName.charAt(0)) && Character.isUpperCase(lastName.charAt(0))) {
                return employeeService.searchEmployee(firstName, lastName);
            } else {
                throw new RuntimeException("Имя и фамилия не с большой буквы");
            }
        } else {
            throw new RuntimeException("Используйте только буквы");
        }

    }

    @GetMapping
    public Collection<Employee> searchAllEmployee() {
        return employeeService.searchAllEmployee();
    }
}