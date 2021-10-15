/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.Reto3.repository;

import com.ciclo3.Reto3.model.Car;
import com.ciclo3.Reto3.repository.crud.CarCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Carlos Andres
 */
@Repository
public class CarRepository {

    @Autowired
    private CarCrudRepository carCrudRepository;

    public List<Car> getAll() {
        return (List<Car>) carCrudRepository.findAll();
    }

    public Optional<Car> getCar(int id) {
        return carCrudRepository.findById(id);
    }

    public Car save(Car p) {
        return carCrudRepository.save(p);
    }
}
