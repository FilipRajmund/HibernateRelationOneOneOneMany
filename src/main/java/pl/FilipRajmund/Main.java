package pl.FilipRajmund;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args){
        EmployeeRepository employeeRepository = new EmployeeRepository();

        employeeRepository.deleteAll();

        Employee employee1 = employeeRepository.insert(EmployeeData.someEmployee1());
        Employee employee2 = employeeRepository.insert(EmployeeData.someEmployee2());
        Employee employee3 = employeeRepository.insert(EmployeeData.someEmployee3());

        System.out.println("###Employed1: " + employeeRepository.getEmployee(employee1.getEmployeeId()));
        System.out.println("###Employed2: " + employeeRepository.getEmployee(employee2.getEmployeeId()));

        employeeRepository.updateEmployee(employee3.getEmployeeId(),new BigDecimal("8300.65"));
        System.out.println("###Employed3: " + employeeRepository.getEmployee(employee3.getEmployeeId()));

        employeeRepository.listEmployees()
                .forEach(employee -> System.out.println("###Employee: " + employee));

        employeeRepository.deleteEmployee(employee2.getEmployeeId());

        employeeRepository.listEmployees()
                .forEach(employee -> System.out.println("###Employee: " + employee));

        HibernateUtil.closesSessionFactory();
    }
}