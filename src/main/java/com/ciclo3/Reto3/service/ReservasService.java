/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.Reto3.service;

import com.ciclo3.Reto3.model.Reservas;
import com.ciclo3.Reto3.repository.ReservasRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carlos Andres
 */
@Service
public class ReservasService {

    @Autowired
    private ReservasRepository reservasRepository;

    public List<Reservas> getAll() {
        return reservasRepository.getAll();
    }

    public Optional<Reservas> getReserva(int id) {
        return reservasRepository.getReserva(id);
    }

    public Reservas save(Reservas p) {
        if (p.getIdReservation() == null) {
            return reservasRepository.save(p);
        } else {
            Optional<Reservas> paux = reservasRepository.getReserva(p.getIdReservation());
            if (paux.isEmpty()) {
                return reservasRepository.save(p);
            } else {
                return p;
            }
        }
    }

    public Reservas update(Reservas c) {
        if (c.getIdReservation() != null) {
            Optional<Reservas> g = reservasRepository.getReserva(c.getIdReservation());
            if (!g.isEmpty()) {
                if (c.getStartDate() != null) {
                    g.get().setStartDate(c.getStartDate());
                }
                if (c.getDevolutionDate() != null) {
                    g.get().setDevolutionDate(c.getDevolutionDate());
                }

                if (c.getStatus() != null) {
                    g.get().setStatus(c.getStatus());
                }
                return reservasRepository.save(g.get());
            }
        }
        return c;

    }

    public boolean deleteReservation(int id) {
        Optional<Reservas> c = getReserva(id);
        if (!c.isEmpty()) {
            reservasRepository.delete(c.get());
            return true;
        }
        return false;

    }
}
