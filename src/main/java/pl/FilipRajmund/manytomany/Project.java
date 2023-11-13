package pl.FilipRajmund.manytomany;


import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Integer projectId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "deadline")
    private OffsetDateTime deadline;

    @ManyToMany(mappedBy = "projects")
    private Set<EmployeeM> employeeM;
}
