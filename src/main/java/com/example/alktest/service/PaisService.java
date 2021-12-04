package com.example.alktest.service;

import com.example.alktest.dto.PaisBasicDTO;
import com.example.alktest.dto.PaisDTO;
import com.example.alktest.entity.Pais;
import com.example.alktest.mapper.PaisMapper;

import java.util.List;

public interface PaisService {

  // List<PaisDTO> getALLPaises();

    PaisDTO getDetailsById(Long id);

    PaisDTO save(PaisDTO paisDTO);

    Pais getEntityById(Long id);

    List<PaisBasicDTO> getAll();

    void delete(Long id);

}
