package com.ciclo3.Reto3.model.custom;

import com.ciclo3.Reto3.model.Clientes;

public class CountClient {
    private Long total;
    private Clientes client;

    public CountClient(Long total, Clientes client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Clientes getClient() {
        return client;
    }

    public void setClient(Clientes client) {
        this.client = client;
    }
}
