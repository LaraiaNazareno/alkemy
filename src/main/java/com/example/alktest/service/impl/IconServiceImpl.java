package com.example.alktest.service.impl;

import com.example.alktest.dto.IconBasicDTO;
import com.example.alktest.dto.IconDTO;
import com.example.alktest.dto.IconFiltersDTO;
import com.example.alktest.entity.Icon;
import com.example.alktest.entity.Pais;
import com.example.alktest.exeptions.ParamNotFound;
import com.example.alktest.mapper.IconMapper;
import com.example.alktest.repository.IconRepository;
import com.example.alktest.repository.specifications.IconSpecification;
import com.example.alktest.service.IconService;
import com.example.alktest.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class IconServiceImpl implements IconService {


    private IconRepository iconRepository;
    private IconMapper iconMapper;
    private PaisService paisService;
    private IconSpecification iconSpecification;

    @Autowired
    public IconServiceImpl(
            IconRepository iconRepository,
           IconSpecification iconSpecification,
            PaisService paisService,
            IconMapper iconMapper) {
        this.iconRepository = iconRepository;
       this.iconSpecification = iconSpecification;
        this.iconMapper = iconMapper;
        this.paisService = paisService;
    }


    public List<IconBasicDTO> getAll(){
        List<Icon> entities = this.iconRepository.findAll();
        List<IconBasicDTO> iconBasicDTOS = this.iconMapper.iconEntitySet2BasicDTOList(entities);

        return iconBasicDTOS;
    }
    public IconDTO save(IconDTO iconDTO){
        //pasamos de dto a entity
        Icon entity = this.iconMapper.iconDTO2Entity(iconDTO);
        //guardamos la entity
        Icon entitySaved = this.iconRepository.save(entity);

        //pasamos de entity a dto y  devolvemos el resultado
        IconDTO result = this.iconMapper.iconEntity2DTO(entitySaved,false);

        return result;

    }

    public void addPais(Long id, Long idPais) {
        Icon entity = this.iconRepository.getById(id);
        entity.getPais().size();
        Pais paisEntity = this.paisService.getEntityById(idPais);
        entity.addPais(paisEntity);
        this.iconRepository.save(entity);
    }

    public void removePais(Long id, Long idPais) {
        Icon entity = this.iconRepository.getById(id);
        entity.getPais().size();
        Pais paisEntity = this.paisService.getEntityById(idPais);
        entity.removePais(paisEntity);
        this.iconRepository.save(entity);
    }

    public IconDTO getDetailsById(Long id){
        Optional <Icon> entity = this.iconRepository.findById(id);
       if (!entity.isPresent()){
           throw new ParamNotFound("Id icono no valido");
        }
        IconDTO iconDTO = this.iconMapper.iconEntity2DTO(entity.get(),true);
        return iconDTO;
    }



    public void delete(Long id) {

        this.iconRepository.deleteById(id);
    }

    public List<IconDTO> getByFilters(String name, String date, Set<Long> cities, String order) {
        IconFiltersDTO filtersDTO = new IconFiltersDTO(name, date, cities, order);
        List<Icon> entities = this.iconRepository.findAll(
                this.iconSpecification.getByFilters(filtersDTO)
        );
        List<IconDTO> dtos = this.iconMapper.iconEntitySet2DTOList(entities, true);
        return dtos;
    }
    public IconDTO update(Long id, IconDTO iconDTO) {
        Optional<Icon> entity = this.iconRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Id icono no valido");
        }
        this.iconMapper.iconEntityRefreshValues(entity.get(), iconDTO);
        Icon entitySaved = this.iconRepository.save(entity.get());
        IconDTO result = this.iconMapper.iconEntity2DTO(entitySaved, false);
        return result;
    }

}
