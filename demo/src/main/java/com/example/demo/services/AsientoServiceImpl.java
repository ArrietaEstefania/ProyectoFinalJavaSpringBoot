package com.example.demo.services;

import com.example.demo.entities.Asiento;
import com.example.demo.repositories.AsientoRepository;
import com.example.demo.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsientoServiceImpl extends BaseServiceImpl<Asiento,Long> implements AsientoService{
    @Autowired
    private AsientoRepository asientoRepository;

    public AsientoServiceImpl(BaseRepository<Asiento, Long> baseRepository, AsientoRepository asientoRepository) {
        super(baseRepository);
        this.asientoRepository = asientoRepository;
    }
}
