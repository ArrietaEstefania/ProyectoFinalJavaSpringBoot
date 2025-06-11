package com.example.demo.services;

import com.example.demo.entities.Fecha;
import com.example.demo.repositories.BaseRepository;
import com.example.demo.repositories.FechaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FechaServiceImpl extends BaseServiceImpl<Fecha, Long> implements FechaService {
    @Autowired
    private FechaRepository fechaRepository;

    public FechaServiceImpl(BaseRepository<Fecha, Long> baseRepository, FechaRepository fechaRepository) {
        super(baseRepository);
        this.fechaRepository = fechaRepository;
    }
}
