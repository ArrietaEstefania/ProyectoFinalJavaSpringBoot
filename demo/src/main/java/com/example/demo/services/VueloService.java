package com.example.demo.services;
import com.example.demo.entities.Vuelo;

import java.util.Date;
import java.util.List;

public interface VueloService extends BaseService<Vuelo, Long>{

    public List<Vuelo> buscarVuelos(String origen, String destino, Date fecha) throws Exception;

}
