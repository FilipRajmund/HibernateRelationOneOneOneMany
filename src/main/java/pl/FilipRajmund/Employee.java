package pl.FilipRajmund;
//CREATE TABLE employee
//        (
//        employee_id serial not null,
//        name varchar(20) not null,
//        surname varchar(20) not null,
//        salary Numeric(7,2) not null,
//        since timeStamp with time zone not null,
//        primary key(employee_id)
//
//        );

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "since")
    private OffsetDateTime since;
}
