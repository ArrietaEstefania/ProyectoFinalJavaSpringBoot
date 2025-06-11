package com.example.demo.repositories;
import com.example.demo.entities.Vuelo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface VueloRepository extends BaseRepository<Vuelo, Long>{


    @Query("SELECT v FROM Vuelo v " +
            "WHERE v.origen.ciudad.nombre = :origen " +
            "AND v.destino.ciudad.nombre = :destino " +
            "AND FUNCTION('DATE', v.fecha.fecha) = :fecha")
    List<Vuelo> buscarPorOrigenDestinoYFecha(
            @Param("origen") String origen,
            @Param("destino") String destino,
            @Param("fecha") Date fecha
    );
}
