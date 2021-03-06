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

    public Car update(Car c) {
        if (c.getIdCar() != null) {
            Optional<Car> g = carRepository.getCar(c.getIdCar());
            if (!g.isEmpty()) {
                if (c.getName() != null) {
                    g.get().setName(c.getName());
                }
                if (c.getDescription() != null) {
                    g.get().setDescription(c.getDescription());
                }

                if (c.getBrand() != null) {
                    g.get().setBrand(c.getBrand());
                }
                if (c.getYear() != null) {
                    g.get().setYear(c.getYear());
                }
                return carRepository.save(g.get());
            }
        }
        return c;

    }

    public boolean deleteCar(int id) {
        Optional<Car> c = getCar(id);
        if (!c.isEmpty()) {
            carRepository.delete(c.get());
            return true;
        }
        return false;
    }
}
