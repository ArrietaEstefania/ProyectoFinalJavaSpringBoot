package com.example.demo.repositories;
import com.example.demo.entities.Reserva;

import java.util.List;

public interface ReservaRepository extends BaseRepository<Reserva, Long>{
    List<Reserva> findByVueloReservado_Id(Long vueloId);
    boolean existsByVueloReservado_Id(Long vueloId);
}
