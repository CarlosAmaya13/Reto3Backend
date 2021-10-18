/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.Reto3.repository;

import com.ciclo3.Reto3.model.Mensajes;
import com.ciclo3.Reto3.repository.crud.MensajesCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Carlos Andres
 */
@Repository
public class MensajesRepository {

    @Autowired
    private MensajesCrudRepository mensajesCrudRepository;

    public List<Mensajes> getAll() {
        return (List<Mensajes>) mensajesCrudRepository.findAll();
    }

    public Optional<Mensajes> getMensaje(int id) {
        return mensajesCrudRepository.findById(id);
    }

    public Mensajes save(Mensajes p) {
        return mensajesCrudRepository.save(p);
    }

    public void delete(Mensajes c) {
        mensajesCrudRepository.delete(c);
    }
}
