package com.demo;

import jakarta.persistence.*;

@Entity
public class Name {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Name() {}
    public Name(String name) { this.name = name; }

    public Long getId() { return id; }
    public String getName() { return name; }
}