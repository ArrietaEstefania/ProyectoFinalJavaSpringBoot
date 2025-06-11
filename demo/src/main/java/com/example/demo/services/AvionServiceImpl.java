package com.example.demo.services;

import com.example.demo.entities.Avion;
import com.example.demo.repositories.AvionRepository;
import com.example.demo.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvionServiceImpl extends BaseServiceImpl<Avion,Long> implements AvionService{
    @Autowired
    private AvionRepository avionRepository;

    public AvionServiceImpl(BaseRepository<Avion, Long> baseRepository, AvionRepository avionRepository) {
        super(baseRepository);
        this.avionRepository = avionRepository;
    }
}
