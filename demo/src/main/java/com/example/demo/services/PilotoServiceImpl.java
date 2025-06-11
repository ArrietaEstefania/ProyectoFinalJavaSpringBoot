package com.example.demo.services;

import com.example.demo.entities.Piloto;
import com.example.demo.repositories.BaseRepository;
import com.example.demo.repositories.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PilotoServiceImpl extends BaseServiceImpl<Piloto, Long> implements PilotoService {
    @Autowired
    private PilotoRepository PilotoRepository;

    public PilotoServiceImpl(BaseRepository<Piloto, Long> baseRepository, PilotoRepository pilotoRepository) {
        super(baseRepository);
        PilotoRepository = pilotoRepository;
    }
}
