package com.example.alktest.controller;


import com.example.alktest.dto.PaisBasicDTO;
import com.example.alktest.dto.PaisDTO;
import com.example.alktest.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping
    public ResponseEntity<List<PaisBasicDTO> > getALL(){
        List<PaisBasicDTO> paises = this.paisService.getAll();
        return ResponseEntity.ok(paises);

    }

    @PostMapping
    public ResponseEntity<PaisDTO> save(@RequestBody PaisDTO pais){


        PaisDTO paisDTO = this.paisService.save(pais);
        return ResponseEntity.ok().body(paisDTO);


    }

    @GetMapping("/{id}")
    public  ResponseEntity<PaisDTO> getDetailsById(@PathVariable Long id){

        PaisDTO pais = this.paisService.getDetailsById(id);
        return ResponseEntity.ok(pais);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PaisDTO> delete(@PathVariable Long id){


        this.paisService.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();



    }




}
