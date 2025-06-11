package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Usuario extends Persona{

    @Column(name = "numero_telefono")
    private int numero;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name = "correo_electronico")
    private String correo;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tarjeta> tarjetas = new ArrayList();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consulta> consultas = new ArrayList();

    @OneToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;
}
