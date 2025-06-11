package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Pago extends Base{

    @Column(unique = true, nullable = false, name = "numero_pago")
    protected int numeroPago;

    @Column(unique = true, nullable = false, name = "valor_pago")
    protected int cantidadPago;

}
