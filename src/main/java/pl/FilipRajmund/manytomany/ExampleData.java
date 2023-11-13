package pl.FilipRajmund.manytomany;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class ExampleData {

    static EmployeeM someEmployee1() {
        return EmployeeM.builder()
                .name("Agnieszka")
                .surname("Kowalska")
                .salary(new BigDecimal("5910.73"))
                .since(OffsetDateTime.of(2020, 1, 1, 10, 10, 10, 0, ZoneOffset.UTC))
                .build();
    }

    static EmployeeM someEmployee2() {
        return EmployeeM.builder()
                .name("Stefan")
                .surname("Nowak")
                .salary(new BigDecimal("3455.13"))
                .since(OffsetDateTime.of(2021, 2, 2, 10, 10, 10, 0, ZoneOffset.UTC))
                .build();
    }

    static EmployeeM someEmployee3() {
        return EmployeeM.builder()
                .name("Tomasz")
                .surname("Adamsski")
                .salary(new BigDecimal("4112.73"))
                .since(OffsetDateTime.of(2022, 3, 3, 10, 10, 10, 0, ZoneOffset.UTC))
                .build();
    }

    static Project someProject1() {
        return Project.builder()
                .name("Database migration")
                .description("some project....")
                .deadline(OffsetDateTime.of(2027, 3, 3, 10, 10, 10, 0, ZoneOffset.UTC))
                .build();
    }

    static Project someProject2() {
        return Project.builder()
                .name("Some external Database migration")
                .description("some project.cos tam 2...")
                .deadline(OffsetDateTime.of(2025, 2, 28, 11, 13, 10, 0, ZoneOffset.UTC))
                .build();
    }

    static Project someProject3() {
        return Project.builder()
                .name("emil sending")
                .description("some email.cos tam 3...")
                .deadline(OffsetDateTime.of(2024, 6, 30, 8, 13, 10, 0, ZoneOffset.UTC))
                .build();
    }
}
