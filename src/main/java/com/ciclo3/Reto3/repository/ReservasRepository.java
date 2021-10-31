/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.Reto3.repository;

import com.ciclo3.Reto3.model.Car;
import com.ciclo3.Reto3.model.Clientes;
import com.ciclo3.Reto3.model.Reservas;
import com.ciclo3.Reto3.model.custom.CountCar;
import com.ciclo3.Reto3.model.custom.CountClient;
import com.ciclo3.Reto3.repository.crud.ReservasCrudRepository;
import java.util.ArrayList;
import java.util.Date;
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

    public void delete(Reservas c) {
        reservasCrudRepository.delete(c);
    }

    public List<CountCar> getTopCars() {
        List<CountCar> res = new ArrayList<>();
        List<Object[]> report = reservasCrudRepository.countTotalReservationsByCar();
        for (int i = 0; i < report.size(); i++) {
            res.add(new CountCar((Long) report.get(i)[1], (Car) report.get(i)[0]));
        }
        return res;
    }

    public List<CountClient> getTopClients() {
        List<CountClient> res = new ArrayList<>();
        List<Object[]> report = reservasCrudRepository.countTotalReservationsByClient();
        for (int i = 0; i < report.size(); i++) {
            res.add(new CountClient((Long) report.get(i)[1], (Clientes) report.get(i)[0]));
        }
        return res;
    }

    public List<Reservas> getReservationPeriod(Date a, Date b) {
        return reservasCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
    }

    public List<Reservas> getReservationsByStatus(String status) {
        return reservasCrudRepository.findAllByStatus(status);
    }

}
