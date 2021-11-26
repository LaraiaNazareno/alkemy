package com.example.alktest.mapper;

import com.example.alktest.dto.continenteDTO;
import com.example.alktest.entity.Continente;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContinenteMapper {

    public Continente continenteDTO2Entity(continenteDTO dto){
        Continente Continente = new Continente();
        Continente.setImagen(dto.getImagen());
        Continente.setDenominacion(dto.getDenominacion());
        return Continente;
    }

    public continenteDTO continenteEntity2DTO(Continente entity){
        continenteDTO dto = new continenteDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        return dto;

    }
    public List<continenteDTO> continenteEntityList2DTOList(List<Continente> entities){
        List<continenteDTO> dtos = new ArrayList<>();
        for (Continente entity: entities){
            dtos.add(this.continenteEntity2DTO(entity));
        }
        return dtos;
    }
}
