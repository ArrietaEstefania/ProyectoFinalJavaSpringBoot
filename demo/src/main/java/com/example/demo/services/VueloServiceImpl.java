package com.example.demo.services;

import com.example.demo.entities.Vuelo;
import com.example.demo.repositories.BaseRepository;
import com.example.demo.repositories.VueloRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VueloServiceImpl extends BaseServiceImpl<Vuelo, Long> implements VueloService {

    @Autowired
    private VueloRepository vueloRepository;

    public VueloServiceImpl(BaseRepository<Vuelo, Long> baseRepository, VueloRepository vueloRepository) {
        super(baseRepository);
        this.vueloRepository = vueloRepository;
    }

    @Override
    @Transactional
    public List<Vuelo> buscarVuelos(String origen, String destino, Date fecha) throws Exception {
        try{
            //List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            //List<Persona> personas = personaRepository.search(filtro);
            List<Vuelo> vuelos = vueloRepository.buscarPorOrigenDestinoYFecha(origen, destino, fecha);

            return vuelos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    // public List<Vuelo> buscarVuelos(String origen, String destino, Date fecha) {
    //    return vueloRepository.buscarPorOrigenDestinoYFecha(origen, destino, fecha);

    //}

}
