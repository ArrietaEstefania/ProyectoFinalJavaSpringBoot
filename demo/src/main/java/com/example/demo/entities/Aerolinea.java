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
@Table(name="aerolinea")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Aerolinea extends Base{

    @Column(name="nombreAerolinea")
    private String nombreAerolinea;

}
