package com.example.demo.services;

import com.example.demo.entities.Ciudad;
import com.example.demo.repositories.BaseRepository;
import com.example.demo.repositories.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiudadServiceImpl extends BaseServiceImpl<Ciudad,Long> implements CiudadService{
    @Autowired
    private CiudadRepository ciudadRepository;

    public CiudadServiceImpl(BaseRepository<Ciudad, Long> baseRepository, CiudadRepository ciudadRepository) {
        super(baseRepository);
        this.ciudadRepository = ciudadRepository;
    }
}
