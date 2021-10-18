/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.Reto3.service;

import com.ciclo3.Reto3.model.Mensajes;
import com.ciclo3.Reto3.repository.MensajesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carlos Andres
 */
@Service
public class MensajesService {

    @Autowired
    private MensajesRepository mensajesRepository;

    public List<Mensajes> getAll() {
        return mensajesRepository.getAll();
    }

    public Optional<Mensajes> getMensaje(int id) {
        return mensajesRepository.getMensaje(id);
    }

    public Mensajes save(Mensajes p) {
        if (p.getIdMessage() == null) {
            return mensajesRepository.save(p);
        } else {
            Optional<Mensajes> paux = mensajesRepository.getMensaje(p.getIdMessage());
            if (paux.isEmpty()) {
                return mensajesRepository.save(p);
            } else {
                return p;
            }
        }
    }

    public Mensajes update(Mensajes c) {
        if (c.getIdMessage() != null) {
            Optional<Mensajes> g = mensajesRepository.getMensaje(c.getIdMessage());
            if (!g.isEmpty()) {
                if (c.getMessageText() != null) {
                    g.get().setMessageText(c.getMessageText());
                    return mensajesRepository.save(g.get());
                }
            }
        }
        return c;
    }

    public boolean deleteMessage(int id) {
        Optional<Mensajes> c = getMensaje(id);
        if (!c.isEmpty()) {
            mensajesRepository.delete(c.get());
            return true;
        }
        return false;

    }
}
