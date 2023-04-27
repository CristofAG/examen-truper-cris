package com.examen.examentruper.service.impl;

import com.examen.examentruper.model.Ordenes;
import com.examen.examentruper.repository.OrdenRepository;
import com.examen.examentruper.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenServiceImpl implements OrdenService {

    @Autowired
    OrdenRepository ordenRepository;


    @Override
    public Ordenes guardaOrden(Ordenes orden) {

        return ordenRepository.save(orden);
    }

    @Override
    public Ordenes obtenOrdenPorId(int idOrden) {
        Ordenes repoOrden = null;
        Optional<Ordenes> responseOrden = ordenRepository.findById(idOrden);
        if (responseOrden.isPresent()) {
            repoOrden = responseOrden.get();
            return repoOrden;
        } else {
            return repoOrden;
        }
    }

    @Override
    public List<Ordenes> obtenTodasOrdenes() {
        return ordenRepository.findAll();
    }
}
