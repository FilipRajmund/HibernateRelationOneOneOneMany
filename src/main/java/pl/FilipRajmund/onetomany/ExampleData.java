package pl.FilipRajmund.onetomany;

public class ExampleData {

    static Address someAddress1() {
        return Address.builder()
                .country("Poland")
                .city("Szczecin")
                .postalCode("70-112")
                .address("Witolda Starkiewicza")
                .build();
    }

    static Address someAddress2() {
        return Address.builder()
                .country("Poland")
                .city("Gdynia")
                .postalCode("81-212")
                .address("3 maja")
                .build();
    }

    static Customer someCustomer1() {
        return Customer.builder()
                .name("Agnieszka")
                .surname("Kowalska")
                .phone("+48 589 245 114")
                .email("AGNIESZKA@zajavka.pl")
                .address(someAddress1())
                .build();
    }

    static Customer someCustomer2() {
        return Customer.builder()
                .name("Stefan")
                .surname("Nowak")
                .phone("+48 589 245 114")
                .email("stefanIK@zajavka.pl")
                .address(someAddress2())
                .build();
    }
    //hibernate zapisuje addres automatycznie do customera
//    //wynika to tez z zapisu w Customerze relacji one one:
//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", unique = true)
//    private Address address;
}
