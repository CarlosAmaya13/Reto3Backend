/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.Reto3.repository.crud;

import com.ciclo3.Reto3.model.Reservas;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Carlos Andres
 */
public interface ReservasCrudRepository extends CrudRepository<Reservas, Integer> {
//select count(*) as "total", carId from reservation group by carId order by total desc;

    @Query("SELECT c.car, COUNT(c.car) from Reservas AS c group by c.car order by COUNT(c.car) DESC")
    public List<Object[]> countTotalReservationsByCar();


    //select clientId, count(*) as "total" from reservation group by clientId order by total desc;
    @Query("SELECT c.client, COUNT(c.client) from Reservas AS c group by c.client order by COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationsByClient();

    public List<Reservas> findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo );

    public List<Reservas>findAllByStatus(String status);
}
