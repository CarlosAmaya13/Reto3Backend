/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.Reto3.service;

import com.ciclo3.Reto3.model.Reservas;
import com.ciclo3.Reto3.model.custom.CountCar;
import com.ciclo3.Reto3.model.custom.CountClient;
import com.ciclo3.Reto3.model.custom.StatusAmount;
import com.ciclo3.Reto3.repository.ReservasRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    /**
     * Objeto reservasRepository de la clase ReservasRepository
     */
    @Autowired
    private ReservasRepository reservasRepository;

    /**
     * Metodo Obtener todo
     *
     * @return reservasRepository
     */
    public List<Reservas> getAll() {
        return reservasRepository.getAll();
    }

    /**
     * Metodo obtener uno
     *
     * @param id
     * @return reservasRepostitory
     */
    public Optional<Reservas> getReserva(int id) {
        return reservasRepository.getReserva(id);
    }

    /**
     * Metodo Guardar
     *
     * @param p
     * @return reservasRepository
     */
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

    /**
     * Metodo actualizar
     *
     * @param c
     * @return reservasRepository
     */
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

    /**
     * Metodo eliminar
     *
     * @param id
     * @return reservasRepository
     */
    public boolean deleteReservation(int id) {
        Optional<Reservas> c = getReserva(id);
        if (!c.isEmpty()) {
            reservasRepository.delete(c.get());
            return true;
        }
        return false;

    }
    
    //RETO 5
    public List<CountCar> getTopCars(){
        return reservasRepository.getTopCars();
    }

    public List<CountClient> getTopClients(){
        return reservasRepository.getTopClients();
    }

    public List<Reservas> getReservationsPeriod(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date a= new Date();
        Date b=new Date();
        try {
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(a.before(b)){
            return reservasRepository.getReservationPeriod(a,b);
        }else{
            return new ArrayList<>();
        }

    }
    public StatusAmount getReservationsStatusReport(){
        List<Reservas>completed=reservasRepository.getReservationsByStatus("completed");
        List<Reservas>cancelled=reservasRepository.getReservationsByStatus("cancelled");
        return new StatusAmount(completed.size(),cancelled.size());

    }
    
}
