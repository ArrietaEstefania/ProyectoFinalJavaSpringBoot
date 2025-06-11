package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name="ciudad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Ciudad extends Base{

    @Column(name = "nombre_ciudad")
    private String nombre;

}
