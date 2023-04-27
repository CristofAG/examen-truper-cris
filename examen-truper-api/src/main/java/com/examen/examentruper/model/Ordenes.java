package com.examen.examentruper.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "ordenes")
public class Ordenes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orden_id")
    private int orden_id;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "total", nullable = false)
    private double total;

    @ManyToOne()
    @JoinColumn(name = "sucursal", referencedColumnName = "sucursal_id")
    private Sucursal sucursal;

    @OneToMany(mappedBy = "ordenes")
    private List<Productos> productos;
}
