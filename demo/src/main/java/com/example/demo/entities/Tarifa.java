package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name="tarifa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Tarifa extends Base{

    @Column(name = "valor_impuesto")
    private int impuestoTarifa;

    @Column(name = "valor_tarifa")
    private int precioTarifa;

    @Column(name = "clase_tarifa")
    private Clase claseTarifa;

    @ManyToOne
    @JoinColumn(name = "vuelo_id")
    private Vuelo vuelo;
}
