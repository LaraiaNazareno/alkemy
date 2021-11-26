package com.example.alktest.service;

import com.example.alktest.dto.continenteDTO;

import java.util.List;

public interface ContinenteService {

     continenteDTO save(continenteDTO dto );
     List<continenteDTO> getAllContinentes();

     void deleteContinente(Long id);



}
