/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.Reto3.repository;

import com.ciclo3.Reto3.model.Gama;
import com.ciclo3.Reto3.repository.crud.GamaCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Carlos Andres
 */
@Repository
public class GamaRepository {

    @Autowired
    private GamaCrudRepository gamaCrudRepository;

    public List<Gama> getAll() {
        return (List<Gama>) gamaCrudRepository.findAll();
    }

    public Optional<Gama> getGama(int id) {
        return gamaCrudRepository.findById(id);
    }

    public Gama save(Gama p) {
        return gamaCrudRepository.save(p);
    }

    public void delete(Gama c) {
        gamaCrudRepository.delete(c);
    }
}
