package pl.FilipRajmund.onetooneJednokierunkowa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", unique = true, nullable = false)
    private Integer Id;
    //wartosc musi być unikatowa i nie moze być pusta
    //przydatne jesli hibenrate definiowałby nam tabele
    //dodatkowo w obrebie kodu  sprawdzamy czy nie przekazujemy nulla

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    //mapowanie relacji w kodzie, aby uzyskać relację one-one - tak jak utworzylismy w
    //bazie danych - plik resources: postgresdrr.txt
    //kilku klientów nie może mieć tego samego adresu
    //relacja jest jednokierunkowa to adres nie ma zielonego pojecia o kliencie

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
  //  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", unique = true)
    private Address address;
}
