/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.Reto3.service;

import com.ciclo3.Reto3.model.Gama;
import com.ciclo3.Reto3.repository.GamaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carlos Andres
 */
@Service
public class GamaService {

    @Autowired
    private GamaRepository gamaRepository;

    public List<Gama> getAll() {
        return gamaRepository.getAll();
    }

    public Optional<Gama> getGama(int id) {
        return gamaRepository.getGama(id);
    }

    public Gama save(Gama p) {
        if (p.getIdGama() == null) {
            return gamaRepository.save(p);
        } else {
            Optional<Gama> paux = gamaRepository.getGama(p.getIdGama());
            if (paux.isEmpty()) {
                return gamaRepository.save(p);
            } else {
                return p;
            }
        }
    }
}
