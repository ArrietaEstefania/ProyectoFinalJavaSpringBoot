package com.example.demo.services;

import com.example.demo.entities.Consulta;
import com.example.demo.repositories.BaseRepository;
import com.example.demo.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaServiceImpl extends BaseServiceImpl<Consulta,Long> implements ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;

    public ConsultaServiceImpl(BaseRepository<Consulta, Long> baseRepository, ConsultaRepository consultaRepository) {
        super(baseRepository);
        this.consultaRepository = consultaRepository;
    }
}
