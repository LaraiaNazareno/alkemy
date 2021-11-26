package com.example.alktest.service.impl;


import com.example.alktest.dto.PaisBasicDTO;
import com.example.alktest.dto.PaisDTO;
import com.example.alktest.entity.Pais;
import com.example.alktest.exeptions.ParamNotFound;
import com.example.alktest.mapper.PaisMapper;
import com.example.alktest.repository.PaisRepository;
import com.example.alktest.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisServiceImpl implements PaisService {

    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private PaisMapper paisMapper;


    public List<PaisDTO> getALLPaises(){
        List<Pais>  entities = paisRepository.findAll();
        List<PaisDTO> result = paisMapper.paisEntityList2DTOList(entities,true);
        return result;

    }

    public List<PaisBasicDTO> getAll() {
        List<Pais> entities = this.paisRepository.findAll();
        List<PaisBasicDTO> iconBasicDTOS = this.paisMapper.paisEntitySet2BasicDTOList(entities);
        return iconBasicDTOS;
    }

    public PaisDTO saved(PaisDTO paisDTO){

      //pasamos dto a entidad
        Pais pEntity = this.paisMapper.paisDTO2Entity(paisDTO);
      // guardamos
        Pais paisSaved = this.paisRepository.save(pEntity);
      //pasamos de entity a dto para devolver result
        PaisDTO result = this.paisMapper.paisEntity2DTO(paisSaved,true);

        return result;



    }
    public Pais getEntityById(Long id) {
        return this.paisRepository.getById(id);
    }

    public PaisDTO getDetailsById(Long id) {
        Optional<Pais> entity = this.paisRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Id pais no valido");
        }
        PaisDTO paisDTO = this.paisMapper.paisEntity2DTO(entity.get(), true);
        return paisDTO;
    }

    public void delete(Long id) {

        this.paisRepository.deleteById(id);
    }

}
