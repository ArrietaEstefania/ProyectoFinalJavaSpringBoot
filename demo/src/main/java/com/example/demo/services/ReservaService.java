package com.example.demo.services;

import com.example.demo.entities.Reserva;

import java.util.List;

public interface ReservaService extends BaseService<Reserva, Long>{
    public Reserva crearReserva(Long vueloId) throws Exception; // AHORA RECIBE DIRECTAMENTE Long vueloId

    public List<Reserva> traerReservas() throws Exception;
}
