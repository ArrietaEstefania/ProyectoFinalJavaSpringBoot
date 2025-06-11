package com.example.demo.services;

import com.example.demo.entities.Aerolinea;
import com.example.demo.repositories.AerolineaRepository;
import com.example.demo.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AerolineaServiceImpl extends BaseServiceImpl<Aerolinea,Long> implements AerolineaService {

    @Autowired
    private AerolineaRepository aerolineaRepository;

    public AerolineaServiceImpl(BaseRepository<Aerolinea, Long> baseRepository, AerolineaRepository aerolineaRepository) {
        super(baseRepository);
        this.aerolineaRepository = aerolineaRepository;
    }
}
