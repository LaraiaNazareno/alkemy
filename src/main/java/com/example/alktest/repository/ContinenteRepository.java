package com.example.alktest.repository;


import com.example.alktest.entity.Continente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ContinenteRepository extends JpaRepository<Continente, Long> {



}
