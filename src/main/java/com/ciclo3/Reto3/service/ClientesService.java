/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.Reto3.service;

import com.ciclo3.Reto3.model.Clientes;
import com.ciclo3.Reto3.repository.ClientesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carlos Andres
 */
@Service
public class ClientesService {

    @Autowired
    private ClientesRepository ClientesRepository;

    public List<Clientes> getAll() {
        return ClientesRepository.getAll();
    }

    public Optional<Clientes> getCliente(int id) {
        return ClientesRepository.getCliente(id);
    }

    public Clientes save(Clientes p) {
        if (p.getIdClient() == null) {
            return ClientesRepository.save(p);
        } else {
            Optional<Clientes> paux = ClientesRepository.getCliente(p.getIdClient());
            if (paux.isEmpty()) {
                return ClientesRepository.save(p);
            } else {
                return p;
            }
        }
    }
}
