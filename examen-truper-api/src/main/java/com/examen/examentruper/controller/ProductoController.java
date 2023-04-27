package com.examen.examentruper.controller;

import com.examen.examentruper.model.Ordenes;
import com.examen.examentruper.model.Productos;
import com.examen.examentruper.service.OrdenService;
import com.examen.examentruper.service.ProductoService;
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
public class ProductoController {

    @Autowired
    ProductoService productoService;

    private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

    @PostMapping("/producto")
    public ResponseEntity<?> createProducto(@RequestBody Productos producto) {
        try {
            Productos response = productoService.guardaProducto(producto);
            return new ResponseEntity<Productos>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/producto/{idProducto}")
    public ResponseEntity<?> updateProducto(@RequestBody Productos producto, @PathVariable int idProducto) {
        double startTime = System.nanoTime();
        LOGGER.info("Comenzando conteo de tiempo que tarda el servicio PUT Producto...");
        try {
            Productos response = productoService.actualizaProducto(producto, idProducto);
            double finishTime = System.nanoTime() - startTime;
            LOGGER.info("El tiempo del servicio POST orden fue de " + String.format("%.2f", finishTime/100000000) + " segundos");
            return new ResponseEntity<Productos>(response, HttpStatus.OK);
        } catch (Exception e) {
            double finishTime = System.nanoTime() - startTime;
            LOGGER.info("El tiempo del servicio POST orden fue de " + String.format("%.2f", finishTime/100000000) + " segundos");
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/producto/{idProducto}")
    public ResponseEntity<Productos> getProductoById(@PathVariable int idProducto) {
        try {
            Productos response = productoService.obtenProductoPorId(idProducto);
            return new ResponseEntity<Productos>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/producto")
    public ResponseEntity<Productos> getProductoByCodigo(@RequestParam("codigo") String codigo) {
        try {
            Productos response = productoService.buscaProductoPorCodigo(codigo);
            return new ResponseEntity<Productos>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/productos")
    public ResponseEntity<List<Productos>> getAllProductos() {
        try {
            List<Productos> response = productoService.obtenTodosProductos();
            return new ResponseEntity<List<Productos>>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
