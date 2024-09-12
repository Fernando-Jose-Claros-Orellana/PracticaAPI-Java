package com.fj.FJCO202409012.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "productsFJCO")
public class ProductFJCO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombreFJCO;

    private String descripcionFJCO;

    private double precio;
}
