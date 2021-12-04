package com.example.alktest.mapper;

import com.example.alktest.dto.ContinenteDTO;
import com.example.alktest.entity.Continente;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContinenteMapper {

    public Continente continenteDTO2Entity(ContinenteDTO dto){
        Continente Continente = new Continente();
        Continente.setImagen(dto.getImagen());
        Continente.setDenominacion(dto.getDenominacion());
        return Continente;
    }

    public ContinenteDTO continenteEntity2DTO(Continente entity){
        ContinenteDTO dto = new ContinenteDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        return dto;

    }
    public List<ContinenteDTO> continenteEntityList2DTOList(List<Continente> entities){
        List<ContinenteDTO> dtos = new ArrayList<>();
        for (Continente entity: entities){
            dtos.add(this.continenteEntity2DTO(entity));
        }
        return dtos;
    }
}
