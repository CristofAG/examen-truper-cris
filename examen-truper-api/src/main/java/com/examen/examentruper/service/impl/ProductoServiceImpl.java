package com.examen.examentruper.service.impl;

import com.examen.examentruper.model.Productos;
import com.examen.examentruper.repository.ProductoRepository;
import com.examen.examentruper.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public Productos guardaProducto(Productos productos) {
        return productoRepository.save(productos);
    }

    @Override
    public Productos obtenProductoPorId(int idProducto) {
        Productos repoProd = null;
        Optional<Productos> responseProd = productoRepository.findById(idProducto);
        if (responseProd.isPresent()) {
            repoProd = responseProd.get();
            return repoProd;
        } else {
            return repoProd;
        }
    }

    @Override
    public List<Productos> obtenTodosProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Productos buscaProductoPorCodigo(String codigo) {
        Productos repoProd = null;
        Optional<Productos> responseProd = Optional.ofNullable(productoRepository.findByCodigo(codigo));
        if (responseProd.isPresent()) {
            return repoProd;
        } else {
            return repoProd;
        }
    }

    @Override
    public Productos actualizaProducto(Productos producto, int idProducto) {
        Productos repoProd = null;
        Optional<Productos> responseProd = productoRepository.findById(idProducto);
        if (responseProd.isPresent()) {
            repoProd = responseProd.get();
            repoProd.setCodigo(producto.getCodigo());
            repoProd.setDescripcion(producto.getDescripcion());
            repoProd.setPrecio(producto.getPrecio());
            Productos responseUpdate = productoRepository.save(repoProd);
            return responseUpdate;
        } else {
            return repoProd;
        }
    }
}
