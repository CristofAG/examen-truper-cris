package com.examen.examentruper.controller;

import com.examen.examentruper.model.Sucursal;
import com.examen.examentruper.service.SucursalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-examen")
@CrossOrigin(origins = "*")
public class SucursalController {

    @Autowired
    SucursalService sucursalService;

    private final Logger LOGGER = LoggerFactory.getLogger(SucursalController.class);

    @PostMapping("/sucursal")
    public ResponseEntity<?> createSucursal(@RequestBody Sucursal sucursal) {
        try {
            Sucursal response = sucursalService.guardaSucursal(sucursal);
            return new ResponseEntity<Sucursal>(response, HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/sucursal/{idSucursal}")
    public ResponseEntity<Sucursal> getSucursalById(@PathVariable int idSucursal) {
        try {
            Sucursal response = sucursalService.obtenSucursalPorId(idSucursal);
            return new ResponseEntity<Sucursal>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/sucursales")
    public ResponseEntity<List<Sucursal>> getAllSucursalees() {
        try {
            List<Sucursal> response = sucursalService.obtenTodasSucursales();
            return new ResponseEntity<List<Sucursal>>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
