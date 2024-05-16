package pro.sky.JavaCollections;

public class EmployeeBook {

    private static final Employee[] employee = new Employee[11];

    {
        employee[0] = new Employee("Логинов", "Виталий", "Юрьевич", 2, 267000);
        employee[1] = new Employee("Маркова", "Антонина", "Витальевна", 2, 246000);
        employee[2] = new Employee("Пономарев", "Илья", "Игоревич", 2, 250000);
        employee[3] = new Employee("Иванов", "Константин", "Валерьевич", 2, 270000);
        employee[4] = new Employee("Петров", "Иван", "Сергеевич", 3, 220000);
        employee[5] = new Employee("Сидоров", "Андрей", "Ильич", 3, 258000);
        employee[6] = new Employee("Гавриков", "Никита", "Андреевич", 3, 213000);
        employee[7] = new Employee("Мамонтов", "Анатолий", "Георгиевич", 5, 289000);
        employee[8] = new Employee("Селезнева", "Анна", "Григорьевна", 5, 245000);
        employee[9] = new Employee("Юрченко", "Александр", "Потапович", 5, 265000);
    }


    public void printSeparator() {
        System.out.println("========================");
    }

    public void fullList() {
        for (int i = 0; i < employee.length; i++) {
            System.out.println(employee[i]);
        }
    }

    public void salaryMonth() {
        int sum = 0;
        for (int i = 0; i < employee.length; i++) {
            sum += employee[i].getSalary();
        }
        System.out.println("Зарплата всех сотрудников составляет - " + sum);

        double medium = (double) sum / employee.length;
        System.out.println("Средняя зарплата среди сотрудников составляет -" + medium);
    }

    public void salaryMinMax() {
        int max = 0;
        for (int i = 0; i < employee.length; i++) {
            if (max < employee[i].getSalary()) {
                max = employee[i].getSalary();
            }
        }
        int min = max;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() < min) {
                min = employee[i].getSalary();
            }
        }
        System.out.println("Максимальная зарплата составляет - " + max + "\n"
                + "Минимальная зарплата составляет - " + min);
    }

    public void fullNameEmployee() {
        for (int i = 0; i < employee.length; i++) {
            System.out.println(employee[i].getName() + " " + employee[i].getSurname() +
                    " " + employee[i].getLastName());

        }
    }

    public void indexSalary() {
        double sum = 0;
        for (int i = 0; i < employee.length; i++) {
            sum = (double) employee[i].getSalary() * 1.07;
            System.out.println("Зарплата сотрудника " + employee[i].getName() +
                    " " + employee[i].getSurname() + " " + employee[i].getLastName()
                    + " с учётом индексации на 7% составляет " + sum);
        }
    }

    public void departmentCode(int departmentCode) {
        boolean questionDepartment = departmentCode < 6 && departmentCode > 0;
        if (questionDepartment) {
            int max = 0;
            for (int i = 0; i < employee.length; i++) {
                if (departmentCode == employee[i].getDepartment() && max < employee[i].getSalary()) {
                    max = employee[i].getSalary();
                }
            }
            int min = max;
            for (int i = 0; i < employee.length; i++) {
                if (departmentCode == employee[i].getDepartment() && employee[i].getSalary() < min) {
                    min = employee[i].getSalary();
                }
            }
            System.out.println("Максимальная зарплата сотрудника из " + departmentCode + " отдела составляет " + max
                    + '\n' + "Минимальнада я зарплата сотрудника из " + departmentCode + " отдела составляет " + min);
            printSeparator();
            int sum = 0;
            for (int i = 0; i < employee.length; i++) {
                if (departmentCode == employee[i].getDepartment()) {
                    sum += employee[i].getSalary();
                }
            }
            System.out.println("Сумма затрат на зарплату " + departmentCode + " отдела " + sum);
            printSeparator();
            float mediumSalary = 0;
            for (int i = 0; i < employee.length; i++) {
                if (departmentCode == employee[i].getDepartment()) {
                    mediumSalary++;
                }
            }
            mediumSalary = sum / mediumSalary;
            System.out.println(mediumSalary);
            printSeparator();
            for (int i = 0; i < employee.length; i++) {
                if (departmentCode == employee[i].getDepartment()) {
                    System.out.println("Отдел номер №" + departmentCode + " " + employee[i].fullDataDepartment());
                }
            }
        } else {
            System.out.println("нет такого отдела!");
        }
    }

    public void salaryDeterminant(int salaryDeterminant) {
        //Сотрудники с зп меньше числа
        for (int i = 0; i < employee.length; i++) {
            if (salaryDeterminant > employee[i].getSalary()) {
                System.out.println("Сотрудник: " + employee[i].getId() + " " + employee[i].getName() + " " +
                        employee[i].getSurname() + " " + employee[i].getLastName() + " " + employee[i].getSalary());
            }
        }
        printSeparator();
//Сотрудники с зп больше числа
        for (int i = 0; i < employee.length; i++) {
            if (salaryDeterminant < employee[i].getSalary()) {
                System.out.println("Сотрудник: " + employee[i].getId() + " " + employee[i].getName() + " " +
                        employee[i].getSurname() + " " + employee[i].getLastName() + " " + employee[i].getSalary());
            }
        }

    }
//методы 3 уровня курсовой работы
    public void addEmployee(String name, String surname, String lastName, int department, int salary) {
        boolean addNew = false;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] == null) {
                addNew=true;
                Employee addNewEmployee = new Employee(name,surname,lastName,department,salary);
                employee[i] = addNewEmployee;
            }
        }
        System.out.println(addNew);
    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < employee.length; i++) {
            if (id == employee[i].getId()) {
                employee[i] = null;
            }
        }
        System.out.println("Сотрудник уволен...");
    }

    public void employeeId(int id){
        for (int i = 0; i <= employee.length; i++) {
            if (id == employee[i].getId()) {
                System.out.println(employee[i]);
                break;
            }
        }
    }
}