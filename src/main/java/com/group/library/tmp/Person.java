package com.group.library.tmp;

import jakarta.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    private String name;
    @OneToOne
    private Address address;

    public Person() {
    }

    public void setAddress(Address address){
        this.address = address;
        this.address.setPerson(this);
    }
}
