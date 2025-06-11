package com.example.demo.services;

import com.example.demo.entities.Aerolinea;
import com.example.demo.entities.Aeropuerto;
import com.example.demo.repositories.AerolineaRepository;
import com.example.demo.repositories.AeropuertoRepository;
import com.example.demo.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AeropuertoServiceImpl extends BaseServiceImpl<Aeropuerto,Long> implements AeropuertoService{
    @Autowired
    private AeropuertoRepository aeropuertoRepository;

    public AeropuertoServiceImpl(BaseRepository<Aeropuerto, Long> baseRepository, AeropuertoRepository aeropuertoRepository) {
        super(baseRepository);
        this.aeropuertoRepository = aeropuertoRepository;
    }
}
