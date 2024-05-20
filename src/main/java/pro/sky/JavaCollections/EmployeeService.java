package pro.sky.JavaCollections;

import pro.sky.JavaCollections.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastname);
    Employee searchEmployee(String firstName, String lastName);

    Collection<Employee> searchAllEmployee();

}
