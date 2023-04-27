package com.examen.examentruper.service;

import com.examen.examentruper.model.Ordenes;

import java.util.List;

public interface OrdenService {
    public Ordenes guardaOrden(Ordenes orden);

    public Ordenes obtenOrdenPorId(int idOrden);

    public List<Ordenes> obtenTodasOrdenes();
}
