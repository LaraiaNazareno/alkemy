package com.example.alktest.service.impl;


import com.example.alktest.dto.PaisBasicDTO;
import com.example.alktest.dto.PaisDTO;
import com.example.alktest.entity.Continente;
import com.example.alktest.entity.Pais;
import com.example.alktest.exeptions.ParamNotFound;
import com.example.alktest.mapper.PaisMapper;
import com.example.alktest.repository.ContinenteRepository;
import com.example.alktest.repository.PaisRepository;
import com.example.alktest.service.PaisService;
import org.modelmapper.ModelMapper;
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
    @Autowired
    private ContinenteRepository continenteRepository;

    @Autowired
    private ModelMapper modelMapper;

    /*
    @Override
    public List<PaisDTO> getALLPaises(){
        List<Pais>  entities = paisRepository.findAll();
        List<PaisDTO> result = paisMapper.paisEntityList2DTOList(entities,true);
        return result;

    }*/
    @Override
    public List<PaisBasicDTO> getAll() {
        List<Pais> entities = this.paisRepository.findAll();
        List<PaisBasicDTO> iconBasicDTOS = this.paisMapper.paisEntitySet2BasicDTOList(entities);
        return iconBasicDTOS;
    }
    @Override
    public PaisDTO save(PaisDTO paisDTO){


        /*
        Pais paisRequest = modelMapper.map(paisDTO, Pais.class);

        Pais paisSaved = paisRepository.save(paisRequest);

        PaisDTO result = modelMapper.map(paisSaved, PaisDTO.class);
            */

        //pasamos dto a entidad
        Pais pEntity = this.paisMapper.paisDTO2Entity(paisDTO);
      // guardamos
        Pais paisSaved = this.paisRepository.save(pEntity);
      //pasamos de entity a dto para devolver result
        PaisDTO result = this.paisMapper.paisEntity2DTO(paisSaved,true);


        return result;



    }
    @Override
    public Pais getEntityById(Long id) {
        return this.paisRepository.getById(id);
    }
    @Override
    public PaisDTO getDetailsById(Long id) {
        Optional<Pais> entity = this.paisRepository.findById(id);

        if (!entity.isPresent()) {
            throw new ParamNotFound("Id pais no valido");
        }

        PaisDTO paisDTO = this.paisMapper.paisEntity2DTO(entity.get(), true);

        return paisDTO;
    }
    @Override
    public void delete(Long id) {

        this.paisRepository.deleteById(id);
    }

}
