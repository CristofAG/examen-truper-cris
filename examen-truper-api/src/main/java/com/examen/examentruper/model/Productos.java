package com.examen.examentruper.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private int producto_id;

    @Column(name = "codigo", nullable = false, length = 20)
    private String codigo;

    @Column(name = "descripcion", nullable = false, length = 20)
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private double precio;

    @ManyToOne()
    @JoinColumn(name = "orden_id", referencedColumnName = "orden_id")
    @JsonIgnore()
    private Ordenes ordenes;
}
