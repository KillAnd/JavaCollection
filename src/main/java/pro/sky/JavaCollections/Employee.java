package pro.sky.JavaCollections;

import java.util.Objects;

public class Employee {

    private final String name;
    private final String surname;
    private final String lastName;
    private int department;
    private int salary;
    private static int counter = 1;
    private final int id;

    public Employee(String name, String surname, String lastName, int department, int salary) {
        this.name = name;
        this.surname = surname;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.id = counter++;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
            this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCounter() {
        return counter;
    }


    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && id == employee.id && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, lastName, department, salary, id);
    }

    @Override
    public String toString() {
        return "Сотрудник: " + name + " " + surname + " " + lastName + " Отдела №" + department +
                " Зарплата:" + salary + ".";
    }

    public String fullDataDepartment() {
        return "Сотрудник: " + name + " " + surname + " " + lastName +
                " Зарплата:" + salary + ".";
    }
}
