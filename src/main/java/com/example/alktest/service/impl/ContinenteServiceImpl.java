package com.example.alktest.service.impl;

import com.example.alktest.dto.continenteDTO;
import com.example.alktest.entity.Continente;
import com.example.alktest.mapper.ContinenteMapper;
import com.example.alktest.repository.ContinenteRepository;
import com.example.alktest.service.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinenteServiceImpl implements ContinenteService {


    private ContinenteMapper continenteMapper;

    private ContinenteRepository continenteRepository;

    @Autowired
    public ContinenteServiceImpl(ContinenteRepository continenteRepository, ContinenteMapper continenteMapper) {
        this.continenteRepository = continenteRepository;
        this.continenteMapper = continenteMapper;
    }

    public continenteDTO save(continenteDTO dto){
        //se convierte a entity
        Continente entity = continenteMapper.continenteDTO2Entity(dto);
        //lo guarda
        Continente entitySaved = continenteRepository.save(entity);
        //lo convierto a dto
        continenteDTO result = continenteMapper.continenteEntity2DTO(entitySaved);
        //devolucion
       return result;
    }


    public List<continenteDTO> getAllContinentes() {
        List<Continente> entities = continenteRepository.findAll();
        List<continenteDTO> result = continenteMapper.continenteEntityList2DTOList(entities);
        return  result;
    }


    public void deleteContinente(Long id) {

        this.continenteRepository.deleteById(id);
    }


}
