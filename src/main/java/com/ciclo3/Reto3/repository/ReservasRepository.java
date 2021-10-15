/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.Reto3.repository;

import com.ciclo3.Reto3.model.Reservas;
import com.ciclo3.Reto3.repository.crud.ReservasCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Carlos Andres
 */
@Repository
public class ReservasRepository {

    @Autowired
    private ReservasCrudRepository reservasCrudRepository;

    public List<Reservas> getAll() {
        return (List<Reservas>) reservasCrudRepository.findAll();
    }

    public Optional<Reservas> getReserva(int id) {
        return reservasCrudRepository.findById(id);
    }

    public Reservas save(Reservas p) {
        return reservasCrudRepository.save(p);
    }
}
