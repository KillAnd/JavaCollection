package pro.sky.JavaCollections;

import org.springframework.stereotype.Service;
import pro.sky.JavaCollections.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.JavaCollections.Exceptions.EmployeeNotFoundException;
import pro.sky.JavaCollections.Exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final int MAX_SIZE_EMPLOYEE = 5;

    private final List<Employee> employeeList;

    public EmployeeServiceImpl() {
        this.employeeList = new ArrayList <>(List.of(
                new Employee("Логинов", "Виталий"),
                new Employee("Маркова", "Антонина"),
                new Employee("Маркова", "Анна")));
    }
    @Override
    public Employee addEmployee(String firstName, String lastName) {
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
            return employee;
        } catch (EmployeeStorageIsFullException e) {
            System.out.println("Превышено максимальное количество сотрудников!");
            return null;
        } catch (EmployeeAlreadyAddedException e) {
            System.out.println("Такой сотрудник уже есть!");
            return null;
        }
    }
    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            if (employeeList.remove(employee)) {
                return employee;
            }
            throw new EmployeeNotFoundException("Удаляемый сотрудник не существует!");
        } catch (EmployeeNotFoundException e) {
            System.out.println("Удаляемого сотрудника нет!");
        }
        return null;
    }
    @Override
    public Employee searchEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            if (employeeList.contains(employee)) {
                return employee;
            }
            throw new EmployeeNotFoundException(firstName + " " + lastName + "Не найден, введен неизвестный сотрудник");
        } catch(EmployeeNotFoundException e){
                System.out.println("Сотрудник не найден!");
            }
        return null;
    }
    @Override
    public Collection<Employee> searchAllEmployee() {
        return new ArrayList<>(employeeList);
    }
}

