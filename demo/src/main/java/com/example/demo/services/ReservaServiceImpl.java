package com.example.demo.services;

import com.example.demo.entities.Reserva;
import com.example.demo.entities.Vuelo;
import com.example.demo.repositories.BaseRepository;
import com.example.demo.repositories.ReservaRepository;
import com.example.demo.repositories.VueloRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ReservaServiceImpl extends BaseServiceImpl<Reserva, Long> implements ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;
    private final VueloRepository vueloRepository;

    @Autowired
    public ReservaServiceImpl(BaseRepository<Reserva, Long> baseRepository,
                              ReservaRepository reservaRepository,
                              VueloRepository vueloRepository) {
        super(baseRepository);
        this.reservaRepository = reservaRepository;
        this.vueloRepository = vueloRepository;
    }

    /**
     * Crea una nueva reserva, recibiendo directamente el ID del vuelo.
     * @param vueloId El ID del vuelo a reservar.
     * @return La Reserva creada.
     * @throws Exception Si el vuelo no se encuentra o ya está reservado.
     */
    @Override
    @Transactional
    public Reserva crearReserva(Long vueloId) throws Exception {
        // 1. Verificar si el vuelo ya está reservado
        if (reservaRepository.existsByVueloReservado_Id(vueloId)) {
            throw new Exception("Este vuelo ya está reservado. Por favor, seleccione otro vuelo.");
        }

        // 2. Buscar el vuelo por su ID
        Optional<Vuelo> vueloOpt = vueloRepository.findById(vueloId);
        if (vueloOpt.isEmpty()) {
            throw new Exception("Vuelo no encontrado con ID: " + vueloId);
        }
        Vuelo vuelo = vueloOpt.get();

        // 3. Crear la instancia de Reserva
        Reserva reserva = new Reserva();
        reserva.setNumeroReserva(generarNumeroReserva());
        reserva.setVueloReservado(vuelo);

        // 4. Guardar la reserva en la base de datos
        return reservaRepository.save(reserva);
    }

    @Override
    @Transactional
    public List<Reserva> traerReservas() throws Exception {
        return super.findAll();
    }

    /**
     * Verifica si un vuelo ya está reservado
     * @param vueloId ID del vuelo a verificar
     * @return true si el vuelo ya está reservado, false en caso contrario
     */
    public boolean estaVueloReservado(Long vueloId) {
        return reservaRepository.existsByVueloReservado_Id(vueloId);
    }

    private int generarNumeroReserva() {
        Random random = new Random();
        return random.nextInt(900000) + 100000;
    }
}