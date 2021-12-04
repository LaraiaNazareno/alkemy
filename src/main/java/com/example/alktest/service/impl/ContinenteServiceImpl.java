package com.example.alktest.service.impl;

import com.example.alktest.dto.ContinenteDTO;
import com.example.alktest.entity.Continente;
import com.example.alktest.mapper.ContinenteMapper;
import com.example.alktest.repository.ContinenteRepository;
import com.example.alktest.service.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinenteServiceImpl implements ContinenteService {

    @Autowired
    private ContinenteMapper continenteMapper;
    @Autowired
    private ContinenteRepository continenteRepository;


    @Override
    public ContinenteDTO save(ContinenteDTO dto){
        //se convierte a entity
        Continente entity = continenteMapper.continenteDTO2Entity(dto);
        //lo guarda
        Continente entitySaved = continenteRepository.save(entity);
        //lo convierto a dto
        ContinenteDTO result = continenteMapper.continenteEntity2DTO(entitySaved);
        //devolucion
       return result;
    }

    @Override
    public List<ContinenteDTO> getAllContinentes() {
        List<Continente> entities = continenteRepository.findAll();
        List<ContinenteDTO> result = continenteMapper.continenteEntityList2DTOList(entities);
        return  result;
    }

    @Override
    public void deleteContinente(Long id) {

        this.continenteRepository.deleteById(id);
    }


}
