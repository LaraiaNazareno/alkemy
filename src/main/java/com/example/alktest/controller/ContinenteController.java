package com.example.alktest.controller;


import com.example.alktest.dto.continenteDTO;
import com.example.alktest.service.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("continentes")
public class ContinenteController {

    //@PostMapping("algo")

    //@Autowired para inicializar el servicio

    private ContinenteService continenteService;

    @Autowired
    public ContinenteController(ContinenteService contienteService) {
        this.continenteService = contienteService;
    }


    @GetMapping
    public ResponseEntity<List<continenteDTO>> getALL(){
        List<continenteDTO> continentes = this.continenteService.getAllContinentes();
        return ResponseEntity.ok().body(continentes);
    }

    @PostMapping
    public ResponseEntity<continenteDTO> saved(@RequestBody continenteDTO continente){
        //redireccionar a service

        continenteDTO continenteSaved = continenteService.save(continente);
        //Respuesta
        return ResponseEntity.status(HttpStatus.CREATED).body(continenteSaved);


    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteContienente (@PathVariable Long id){
        this.continenteService.deleteContinente(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();


    }
}
