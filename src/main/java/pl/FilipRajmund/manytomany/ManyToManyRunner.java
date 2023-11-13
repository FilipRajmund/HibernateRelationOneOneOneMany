package pl.FilipRajmund.manytomany;

import pl.FilipRajmund.HibernateUtil;

import java.util.List;
import java.util.Set;

public class ManyToManyRunner {
    public static void main(String[] args) {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        employeeRepository.deleteAll();

        List<EmployeeM> employeesCreated = createEmployees(employeeRepository);

        employeeRepository.listEmployees()
                .forEach(employeeM -> System.out.println("###Employees listing: " + employeeM));

        System.out.println("###Employee1: " + employeeRepository
                .getEmployee(employeesCreated.get(employeesCreated.size() - 1).getEmployeeId()));

        System.out.println("###Employee2: " + employeeRepository.getEmployee(employeesCreated.get(employeesCreated.size() - 2).getEmployeeId()));

        updateEmployess(employeeRepository, employeesCreated);

        employeeRepository.listEmployees()
                .forEach(employeeM -> System.out.println("###Employees listing: " + employeeM));

        employeeRepository.deleteEmployee(employeesCreated.get(employeesCreated.size() - 2).getEmployeeId());

        employeeRepository.listEmployees()
                .forEach(employeeM -> System.out.println("###Employees listing: " + employeeM));

        HibernateUtil.closesSessionFactory();

    }


    private static List<EmployeeM> createEmployees(EmployeeRepository employeeRepository) {
        Project project1 = ExampleData.someProject1();
        Project project2 = ExampleData.someProject2();
        Project project3 = ExampleData.someProject3();
        EmployeeM employee1 = ExampleData.someEmployee1();
        EmployeeM employee2 = ExampleData.someEmployee2();
        EmployeeM employee3 = ExampleData.someEmployee3();
        employee1.setProjects(Set.of(project1,project2));
        employee1.setProjects(Set.of(project2));
        employee1.setProjects(Set.of(project2,project3));
        return employeeRepository.insertData(List.of(employee1,employee2,employee3));

    }
    private static void updateEmployess(EmployeeRepository employeeRepository, List<EmployeeM> employeesCreated) {

    }
}
