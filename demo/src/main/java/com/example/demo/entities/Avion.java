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
@Table(name="avion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Avion extends Base {

    @OneToMany(mappedBy = "avion",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Asiento> asientos = new ArrayList<>();
}
