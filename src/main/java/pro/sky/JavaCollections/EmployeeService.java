package pro.sky.JavaCollections;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.JavaCollections.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.JavaCollections.Exceptions.EmployeeNotFoundException;
import pro.sky.JavaCollections.Exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;
@Service
@RestController
@RequestMapping("JavaCollections")
public class EmployeeService{

    private final int MAX_SIZE_EMPLOYEE = 3;

    private final List<Employee> employeeList = new ArrayList<>(List.of(
            new Employee("Логинов", "Виталий"),
            new Employee("Маркова", "Антонина"),
            new Employee("Маркова", "Анна")
    ));

    @GetMapping(path = "addEmployee")
    public String addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            if (employeeList.size() > MAX_SIZE_EMPLOYEE) {
                throw new EmployeeStorageIsFullException("Колличество сотрудников превышает допустимое значение!");
            } else if (employeeList.contains(employee))
            {
                throw new EmployeeAlreadyAddedException("Сотрудник уже существует!");
            } else {
                    employeeList.add(employee);
            }
            return firstName + " " + lastName +
                    "Сотрудник добавлен успешно!";
        } catch (EmployeeStorageIsFullException e) {
            System.out.println("Превышено максимальное количество сотрудников!");
            return "Коллекция переполнена!";
        } catch (EmployeeAlreadyAddedException e) {
            System.out.println("Такой сотрудник уже есть!");
            return "Сотрудник уже имеется в коллекции!";
        }
    }

    @GetMapping(path = "removeEmployee")
    public String removeEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            employeeList.remove(employee);
            throw new EmployeeNotFoundException("Удаляемый сотрудник не существует!");
        } catch (EmployeeNotFoundException e) {
            System.out.println("Удаляемого сотрудника нет!");
            return "Удаляемого сотрудника нет!";
        }
    }

    @GetMapping(path = "searchEmployee")
    public String searchEmployee(@RequestParam("firstName") String firstName,
                                  @RequestParam("lastName") String lastName) {
        try {
            for (Employee employee : employeeList) {
                if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                    return "Сотрудник " + firstName + " " + lastName + " " + " найден!";
                }
                throw new EmployeeNotFoundException(firstName + " " + lastName + "Не найден, введен неизвестный сотрудник");
            }
        }catch(EmployeeNotFoundException e){
                System.out.println("Сотрудник не найден!");
                return "Сотрудник не найден!";
            }
        return null;
    }
}

