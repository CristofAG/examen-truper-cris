package com.examen.examentruper.service.impl;

import com.examen.examentruper.model.Sucursal;
import com.examen.examentruper.repository.SucursalRepository;
import com.examen.examentruper.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalServiceImpl implements SucursalService {

    @Autowired
    SucursalRepository sucursalRepository;

    @Override
    public Sucursal guardaSucursal(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    @Override
    public Sucursal obtenSucursalPorId(int idSucursal) {
        Sucursal repoSucursal = null;
        Optional<Sucursal> responseSuc = sucursalRepository.findById(idSucursal);
        if (responseSuc.isPresent()) {
            repoSucursal = responseSuc.get();
            return repoSucursal;
        } else {
            return repoSucursal;
        }
    }

    @Override
    public List<Sucursal> obtenTodasSucursales() {
        return sucursalRepository.findAll();
    }
}
