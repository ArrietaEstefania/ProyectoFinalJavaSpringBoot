package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name="reserva")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Reserva extends Base{
    @Column(name = "numero_reserva")
    private int numeroReserva;

    @OneToOne
    @JoinColumn(name = "vuelo_id")
    private Vuelo vueloReservado;

    @OneToOne
    @JoinColumn(name = "pago_id")
    private Tarjeta pago;
}
