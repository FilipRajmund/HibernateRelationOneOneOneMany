package pl.FilipRajmund.onetomany;

import pl.FilipRajmund.onetooneJednokierunkowa.Customer;

public class ExampleData {
    static Owner someOwner1() {
        return Owner.builder()
                .name("Stefan")
                .surname("Nowacki")
                .phone("+48 689 445 114")
                .email("stefan@zajavka.pl")
                .build();
    }

    static Owner someOwner2() {
        return Owner.builder()
                .name("Adrian")
                .surname("Kowalsk1")
                .phone("+48 589 245 114")
                .email("adrian@zajavka.pl")
                .build();
    }

    static Pet somePet1() {
        return Pet.builder()
                .name("fafik")
                .breed(Breed.DOG)
                .build();
    }

    static Pet somePet2() {
        return Pet.builder()
                .name("kiciek")
                .breed(Breed.CAT)
                .build();
    }

    static Pet somePet3() {
        return Pet.builder()
                .name("Mafi")
                .breed(Breed.MONKEY)
                .build();
    }

    static Pet somePet4() {
        return Pet.builder()
                .name("Gucio")
                .breed(Breed.DOG)
                .build();
    }
}
