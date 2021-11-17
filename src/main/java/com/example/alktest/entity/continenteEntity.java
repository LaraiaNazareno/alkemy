package com.example.alktest.entity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "continente")
@Getter
@Setter



public class continenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;
    private String imagen;
    private String denominacion;
}
