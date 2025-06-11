package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.Date;

@Entity
@Table(name="fecha")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Fecha extends Base{

    @Temporal(TemporalType.DATE)
    private Date fecha;
}
