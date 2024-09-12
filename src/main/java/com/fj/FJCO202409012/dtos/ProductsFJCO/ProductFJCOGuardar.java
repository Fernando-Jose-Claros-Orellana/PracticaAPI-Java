package com.fj.FJCO202409012.dtos.ProductsFJCO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProductFJCOGuardar implements Serializable {
    @NotBlank(message = "El nombre es obligatorio")
    @JsonProperty("Nombre")
    private String nombreFJCO;

    @JsonProperty("Descripción")
    private String descripcionFJCO;

    @NotNull(message = "El precio es obligatorio")
    @JsonProperty("Precio")
    private Double precio;
}
