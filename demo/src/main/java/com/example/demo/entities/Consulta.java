package com.example.demo.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name="consulta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Consulta extends Base{

    @ManyToOne
    @JoinColumn(name = "vuelo_consultado")
    private Vuelo vueloConsultado;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
