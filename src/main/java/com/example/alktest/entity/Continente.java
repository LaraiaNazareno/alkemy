package com.example.alktest.entity;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
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
