/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.Reto3.service;

import com.ciclo3.Reto3.model.Admin;
import com.ciclo3.Reto3.repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carlos Andres
 */
@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll() {
        return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id) {
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin p) {
        if (p.getIdAdmin() == null) {
            return adminRepository.save(p);
        } else {
            Optional<Admin> paux = adminRepository.getAdmin(p.getIdAdmin());
            if (paux.isEmpty()) {
                return adminRepository.save(p);
            } else {
                return p;
            }
        }
    }

    public Admin update(Admin c) {
        if (c.getIdAdmin() != null) {
            Optional<Admin> g = adminRepository.getAdmin(c.getIdAdmin());
            if (!g.isEmpty()) {
                if (c.getName() != null) {
                    g.get().setName(c.getName());
                }
                if (c.getPassword() != null) {
                    g.get().setPassword(c.getPassword());
                }
                return adminRepository.save(g.get());
            }
        }
        return c;

    }

    public boolean deleteAdmin(int id) {
        Optional<Admin> c = getAdmin(id);
        if (!c.isEmpty()) {
            adminRepository.delete(c.get());
            return true;
        }
        return false;
    }
}
