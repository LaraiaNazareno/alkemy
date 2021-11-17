package com.example.alktest.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "icon")
@Getter
@Setter

public class iconEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String denominacion;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCreacion;

    private Long altura;

    private String historia;

    // private  boolean deleted = Boolean.FALSE;

    @ManyToMany(mappedBy = "icons", cascade = CascadeType.ALL)
    private List<paisEntity> pais = new ArrayList<>();

    //public void addPais(paisEntity pais){this.paises.add(pais);}

    //public void removePais(paisEntity pais){this.paises.remove(pais);}





}
