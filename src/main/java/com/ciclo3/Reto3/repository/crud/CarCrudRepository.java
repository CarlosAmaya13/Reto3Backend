/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.Reto3.repository.crud;

import com.ciclo3.Reto3.model.Car;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Carlos Andres
 */
public interface CarCrudRepository extends CrudRepository<Car, Integer> {

}
