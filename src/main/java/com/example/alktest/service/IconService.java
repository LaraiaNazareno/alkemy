package com.example.alktest.service;


import com.example.alktest.dto.IconBasicDTO;
import com.example.alktest.dto.IconDTO;

import java.util.List;
import java.util.Set;

public interface IconService {

    //void delete(Long id);

    List<IconBasicDTO> getAll();

    IconDTO save(IconDTO iconDTO);

    void addPais(Long id,Long idPais);

    void removePais(Long id, Long idPais);


    IconDTO update(Long id, IconDTO icon);

    IconDTO getDetailsById(Long id);

    void delete(Long id);


    List<IconDTO> getByFilters(String name, String date, Set<Long> cities, String order);

}
