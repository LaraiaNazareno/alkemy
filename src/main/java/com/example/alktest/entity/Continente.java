package com.example.alktest.entity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
//@Table(name = "continente")
@Getter
@Setter

@SQLDelete(sql = "UPDATE continente SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")

public class Continente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagen;
    private String denominacion;

    private boolean deleted = Boolean.FALSE;
}
