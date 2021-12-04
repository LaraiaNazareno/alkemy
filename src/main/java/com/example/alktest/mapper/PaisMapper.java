package com.example.alktest.mapper;


import com.example.alktest.dto.*;
import com.example.alktest.entity.Continente;
import com.example.alktest.entity.Icon;
import com.example.alktest.entity.Pais;
import com.example.alktest.repository.ContinenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PaisMapper {
    @Autowired
    private IconMapper iconMapper;


    @Autowired
    private ContinenteRepository continenteRepository;


    public Pais paisDTO2Entity(PaisDTO dto){
        Continente conti = continenteRepository.findById(dto.getContinenteId()).orElseThrow();

       // conti = continenteRepository.save(conti);

        Pais pais = new Pais();
        //Continente conti = new Continente();

        pais.setImagen(dto.getImagen());
        pais.setDenominacion(dto.getDenominacion());
        pais.setCantidadHabitantes(dto.getCantidadHabitantes());
        pais.setSuperficie(dto.getSuperficie());


        //REVISAR
        /*
        Continente continente = continenteRepository.findById(dto.getContinenteId()).orElseThrow(()->
                new ParamNotFound("no se encontro id")
                );
        //PaisDTO paisDTO = dto ;

        pais.setContinente(new Continente(continente.getId(), continente.getImagen(),continente.getDenominacion(),false));
            */


        pais.setContinente(conti);



        //icons hay que meterlos en una lista
        Set<Icon> icons = this.iconMapper.iconDTOList2Entity(dto.getIcons());
        pais.setIcons(icons);

        return pais;
    }

    public PaisDTO paisEntity2DTO(Pais entity, boolean loadIcons){

        PaisDTO dto = new PaisDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        dto.setCantidadHabitantes(entity.getCantidadHabitantes());
        dto.setSuperficie(entity.getSuperficie());

        dto.setContinenteId(entity.getContinente().getId());




        if(loadIcons) {
            List<IconDTO> iconDTOS = this.iconMapper.iconEntitySet2DTOList(entity.getIcons(), false);
            dto.setIcons(iconDTOS);
        }



        return dto;

    }

    public List<PaisDTO> paisEntityList2DTOList(List<Pais> entities, boolean loadIcons){
        List<PaisDTO> dtos = new ArrayList<>();
        for (Pais entity: entities){
            dtos.add(this.paisEntity2DTO(entity,loadIcons));
        }
        return dtos;
    }

    public List<PaisBasicDTO> paisEntitySet2BasicDTOList(Collection<Pais> entities) {
        List<PaisBasicDTO> dtos = new ArrayList<>();
        PaisBasicDTO basicDTO;

        for (Pais entity : entities) {
            basicDTO = new PaisBasicDTO();
            basicDTO.setId(entity.getId());
            basicDTO.setImagen(entity.getImagen());
            basicDTO.setDenominacion(entity.getDenominacion());
            basicDTO.setCantidadHabitantes(entity.getCantidadHabitantes());
            dtos.add(basicDTO);
        }

        return dtos;
    }



}
