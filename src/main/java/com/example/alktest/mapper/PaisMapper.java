package com.example.alktest.mapper;


import com.example.alktest.dto.*;
import com.example.alktest.entity.Continente;
import com.example.alktest.entity.Icon;
import com.example.alktest.entity.Pais;
import com.example.alktest.repository.ContinenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Component
public class PaisMapper {
    @Autowired
    private IconMapper iconMapper;
    @Autowired
    private ContinenteMapper continenteMapper;

    private continenteDTO continenteDTO;
    @Autowired
    private ContinenteRepository continenteRepository;


    public Pais paisDTO2Entity(PaisDTO dto){
        Pais pais = new Pais();
        pais.setImagen(dto.getImagen());
        pais.setDenominacion(dto.getDenominacion());
        pais.setCantidadHabitantes(dto.getCantidadHabitantes());
        pais.setSuperficie(dto.getSuperficie());

        //REVISAR
        //pais.setContinente(dto.getContinenteId());


        //icons hay que meterlos en una lista
        Set<Icon> icons = this.iconMapper.iconDTOList2Entity(dto.getIcons());
        pais.setIcons(icons);

        return pais;
    }
    /*
    public Employee addEmployee(Employee employee) {
        Department dept = departmentRepository.findById(employee.getDepartment().getId()).orElse(null);
        if (null == dept) {
            dept = new Department();
        }
        dept.setDeptName(employee.getDepartment().getDeptName());
        employee.setDepartment(dept);
        return employeeRepository.save(employee);
    }*/

    public PaisDTO paisEntity2DTO(Pais entity, boolean loadIcons){
        PaisDTO dto = new PaisDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        dto.setCantidadHabitantes(entity.getCantidadHabitantes());
        dto.setSuperficie(entity.getSuperficie());


        //dto.setContinenteId(entity.getContinenteId());
       // dto.setContinenteId(entity.getContinente().getId());


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
