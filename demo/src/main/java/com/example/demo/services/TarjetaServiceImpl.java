package com.example.demo.services;

import com.example.demo.entities.Base;
import com.example.demo.entities.Tarjeta;
import com.example.demo.repositories.BaseRepository;
import com.example.demo.repositories.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarjetaServiceImpl extends BaseServiceImpl<Tarjeta, Long> implements TarjetaService {
    @Autowired
    private TarjetaRepository tarjetaRepository;

    public TarjetaServiceImpl(BaseRepository<Tarjeta, Long> baseRepository, TarjetaRepository tarjetaRepository) {
        super(baseRepository);
        this.tarjetaRepository = tarjetaRepository;
    }
}
