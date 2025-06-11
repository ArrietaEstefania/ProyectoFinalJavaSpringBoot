package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name="aeropuerto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Aeropuerto extends Base {

    @OneToOne
    @JoinColumn(name = "fk_ciudad")
    private Ciudad ciudad;

    @Column(name= "nombre_aeropuerto")
    private String nombreAeropuerto;
}
