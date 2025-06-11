package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name="tarjeta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Tarjeta extends Pago{

    @Column(name = "numero_tarjeta")
    private int numeroTarjeta;

    @Column(name = "tipo_tarjeta")
    @Enumerated(EnumType.STRING)
    private TipoTarjeta tipoTarjeta;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
