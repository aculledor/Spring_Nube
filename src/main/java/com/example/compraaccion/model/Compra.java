package com.example.compraaccion.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Document(collection = "compras")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(
        name = "Compra",
        description = "A complete buy transaction representation"
)
public class Compra {
    @Id
    @Schema(hidden = true)
    private String id;
    @Schema(title = "Date", description = "The day that the transaction was realized",
            type = "String", example = "2010-03-01")
    private String fecha;
    @NotEmpty(message = "El símbolo no puede ser vacío")
    @Schema(title = "Symbol", description = "The identifying symbol of the currency or share being acquired",
            type = "String", required = true, example = "IND")
    private String simbolo;
    @NotNull(message = "El volumen no puede ser vacío")
    @Schema(title = "Shares", description = "The amount of shares that were acquired",
            type = "Long", required = true, minimum = "1", example = "50")
    private Long volumen;
    @NotNull(message = "El precio por unidad no puede ser vacío")
    @Schema(title = "Share price", description = "The price of each individual share that was acquired",
            type = "Float", required = true, minimum = "1", example = "5")
    private Float unidad;
    @NotNull(message = "El precio total no puede ser vacío")
    @Schema(title = "Total Price", description = "The total amount that was paid during the transaction",
            type = "Float", required = true, minimum = "1", example = "250")
    private Float total;

    public Compra() {
    }

    public Compra(String id, String fecha, String simbolo, Long volumen, Float unidad, Float total) {
        this.id = id;
        this.fecha = fecha;
        this.simbolo = simbolo;
        this.volumen = volumen;
        this.unidad = unidad;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public Compra setFecha(String fecha) {
        this.fecha = fecha;
        return this;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public Compra setSimbolo(String simbolo) {
        this.simbolo = simbolo;
        return this;
    }

    public Long getVolumen() {
        return volumen;
    }

    public Compra setVolumen(Long volumen) {
        this.volumen = volumen;
        return this;
    }

    public Float getUnidad() {
        return unidad;
    }

    public Compra setUnidad(Float unidad) {
        this.unidad = unidad;
        return this;
    }

    public Float getTotal() {
        return total;
    }

    public Compra setTotal(Float total) {
        this.total = total;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Compra compra = (Compra) o;

        return id != null ? id.equals(compra.id) : compra.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id='" + id + '\'' +
                ", fecha='" + fecha + '\'' +
                ", simbolo='" + simbolo + '\'' +
                ", volumen=" + volumen +
                ", unidad=" + unidad +
                ", total=" + total +
                '}';
    }
}
