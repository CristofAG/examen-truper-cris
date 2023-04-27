package com.examen.examentruper.service;

import com.examen.examentruper.model.Productos;

import java.util.List;

public interface ProductoService {
    public Productos guardaProducto(Productos productos);

    public Productos obtenProductoPorId(int idProducto);

    public List<Productos> obtenTodosProductos();

    public Productos  buscaProductoPorCodigo(String codigo);

    public Productos actualizaProducto(Productos producto, int idProducto);
}
