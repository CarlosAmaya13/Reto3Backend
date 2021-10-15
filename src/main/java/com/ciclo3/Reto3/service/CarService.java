/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.Reto3.service;

import com.ciclo3.Reto3.model.Car;
import com.ciclo3.Reto3.repository.CarRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carlos Andres
 */
@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAll() {
        return carRepository.getAll();
    }

    public Optional<Car> getCar(int id) {
        return carRepository.getCar(id);
    }

    public Car save(Car p) {
        if (p.getIdCar() == null) {
            return carRepository.save(p);
        } else {
            Optional<Car> paux = carRepository.getCar(p.getIdCar());
            if (paux.isEmpty()) {
                return carRepository.save(p);
            } else {
                return p;
            }
        }
    }
}
