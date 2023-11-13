package pl.FilipRajmund.onetomany;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString(exclude = "owner")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pet")
public class Pet {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id", unique = true, nullable = false)
    private Integer Id;

    @Column(name = "name")
    private String name;

    //mapujemy enum z klasy Breed
    //.STRING w bazie danych będa zapisywane wartości stringowe
    @Enumerated(EnumType.STRING)
    @Column(name = "breed")
    private Breed breed;



    //mapowanie ownera i może mieć tylko jednego ownera
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

}
