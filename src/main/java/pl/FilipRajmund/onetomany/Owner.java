package pl.FilipRajmund.onetomany;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "owner")
public class Owner {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id", unique = true, nullable = false)
    private Integer Id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    //relacja zależności, owner moze miec wile zwierzatek
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Pet> pets;


}

