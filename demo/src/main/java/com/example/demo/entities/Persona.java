package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Persona extends Base{


    @Column(name= "nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="dni")
    private int dni;

}
