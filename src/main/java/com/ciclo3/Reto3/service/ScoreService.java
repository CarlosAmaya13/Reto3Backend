/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.Reto3.service;

import com.ciclo3.Reto3.model.Score;
import com.ciclo3.Reto3.repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carlos Andres
 */
@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id) {
        return scoreRepository.getScore(id);
    }

    public Score save(Score p) {
        if (p.getIdScore() == null) {
            return scoreRepository.save(p);
        } else {
            Optional<Score> paux = scoreRepository.getScore(p.getIdScore());
            if (paux.isEmpty()) {
                return scoreRepository.save(p);
            } else {
                return p;
            }
        }
    }

    public Score update(Score c) {
        if (c.getIdScore() != null) {
            Optional<Score> g = scoreRepository.getScore(c.getIdScore());
            if (!g.isEmpty()) {
                if (c.getMessageText() != null) {
                    g.get().setMessageText(c.getMessageText());
                }
                if (c.getStars() != null) {
                    g.get().setStars(c.getStars());
                }
                return scoreRepository.save(g.get());
            }
        }
        return c;

    }

    public boolean deleteScore(int id) {
        Optional<Score> c = getScore(id);
        if (!c.isEmpty()) {
            scoreRepository.delete(c.get());
            return true;
        }
        return false;
    }
}
