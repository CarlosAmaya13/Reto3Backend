/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.Reto3.repository;

import com.ciclo3.Reto3.model.Clientes;
import com.ciclo3.Reto3.repository.crud.ClientesCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Carlos Andres
 */
@Repository
public class ClientesRepository {

    @Autowired
    private ClientesCrudRepository clientesCrudRepository;

    public List<Clientes> getAll() {
        return (List<Clientes>) clientesCrudRepository.findAll();
    }

    public Optional<Clientes> getCliente(int id) {
        return clientesCrudRepository.findById(id);
    }

    public Clientes save(Clientes p) {
        return clientesCrudRepository.save(p);
    }
}
