package com.examen.examentruper.controller;

import com.examen.examentruper.model.Ordenes;
import com.examen.examentruper.model.Productos;
import com.examen.examentruper.service.OrdenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-examen")
@CrossOrigin(origins = "*")
public class OrdenController {

    @Autowired
    OrdenService ordenService;

    private final Logger LOGGER = LoggerFactory.getLogger(OrdenController.class);

    @PostMapping("/orden")
    public ResponseEntity<?> createOrden(@RequestBody Ordenes orden) {
        double startTime = System.nanoTime();
        LOGGER.info("Comenzando conteo de tiempo que tarda el servicio POST orden...");
        try {
            Ordenes response = ordenService.guardaOrden(orden);
            double finishTime = System.nanoTime() - startTime;
            LOGGER.info("El tiempo del servicio POST orden fue de " + String.format("%.2f", finishTime/100000000) + " segundos");
            return new ResponseEntity<Ordenes>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            double finishTime = System.nanoTime() - startTime;
            LOGGER.info("El tiempo del servicio POST orden fue de " + String.format("%.2f", finishTime/100000000) + " segundos");
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/orden/{idOrden}")
    public ResponseEntity<Ordenes> getOrdenById(@PathVariable int idOrden) {
        double startTime = System.nanoTime();
        LOGGER.info("Comenzando conteo de tiempo que tarda el servicio GET orden...");
        try {
            Ordenes response = ordenService.obtenOrdenPorId(idOrden);
            double finishTime = System.nanoTime() - startTime;
            LOGGER.info("El tiempo del servicio POST orden fue de " + String.format("%.2f", finishTime/100000000) + " segundos");
            return new ResponseEntity<Ordenes>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            double finishTime = System.nanoTime() - startTime;
            LOGGER.info("El tiempo del servicio POST orden fue de " + String.format("%.2f", finishTime/100000000) + " segundos");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
