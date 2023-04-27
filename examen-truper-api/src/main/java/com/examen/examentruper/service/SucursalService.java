package com.examen.examentruper.service;

import com.examen.examentruper.model.Sucursal;

import java.util.List;

public interface SucursalService {
    public Sucursal guardaSucursal(Sucursal sucursal);

    public Sucursal obtenSucursalPorId(int idSucursal);

    public List<Sucursal> obtenTodasSucursales();
}
