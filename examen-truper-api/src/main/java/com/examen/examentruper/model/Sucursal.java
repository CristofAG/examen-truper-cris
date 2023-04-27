package com.examen.examentruper.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "sucursales")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sucursal_id")
    private int sucursal_id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    /*@OneToMany(mappedBy = "sucursal")
    //@JsonIgnore()
    private List<Ordenes> ordenes;*/
}
