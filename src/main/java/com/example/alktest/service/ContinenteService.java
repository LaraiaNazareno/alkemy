package com.example.alktest.service;

import com.example.alktest.dto.ContinenteDTO;

import java.util.List;

public interface ContinenteService {

     ContinenteDTO save(ContinenteDTO dto );
     List<ContinenteDTO> getAllContinentes();

     void deleteContinente(Long id);



}
