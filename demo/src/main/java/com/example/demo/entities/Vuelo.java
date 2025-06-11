package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="vuelo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Vuelo extends Base{

    @OneToOne
    @JoinColumn(name = "id_avion")
    private Avion avion;

    @ManyToOne
    @JoinColumn(name = "aeropuerto_origen_id")
    private Aeropuerto origen;

    @ManyToOne
    @JoinColumn(name = "aeropuerto_destino_id")
    private Aeropuerto destino;

    //cascade = CascadeType.ALL si querés que al guardar un vuelo se guarden sus objetos relacionados automáticamente
    //orphanRemoval = true si querés que se borren tarifas huérfanas cuando se eliminan del vuelo

    @OneToMany(mappedBy = "vuelo",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tarifa> tarifas = new ArrayList();

    @ManyToOne
    @JoinColumn(name = "aerolinea_id")
    private Aerolinea aerolinea;

    @OneToOne
    @JoinColumn(name = "piloto_id")
    private Piloto piloto;

    @OneToOne
    @JoinColumn(name = "fecha_id")
    private Fecha fecha;
}
