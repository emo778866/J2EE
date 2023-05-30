package com.hasanemo.JPA.model;

import javax.persistence.*;

@Entity
@Table(name = "info")
public class Pharmacy {
    @Id
    @GeneratedValue
    private Long id;
    private String name = "";

    public Pharmacy(String name) {
        this.name = name;
    }

    public Pharmacy() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
