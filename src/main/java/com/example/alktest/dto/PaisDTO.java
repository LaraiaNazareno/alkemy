package com.example.alktest.dto;

import java.util.List;

import com.example.alktest.entity.Continente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaisDTO {
    private Long id;
    private String imagen;
    private String denominacion;
    private Long cantidadHabitantes;
    private Long superficie;
    private Long continenteId;
    //private Continente continente;
    private List<IconDTO> icons;
}
