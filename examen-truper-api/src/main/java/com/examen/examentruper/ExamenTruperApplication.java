package com.examen.examentruper;

import com.examen.examentruper.controller.SucursalController;
import com.examen.examentruper.model.Sucursal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ExamenTruperApplication {

    @Autowired
    SucursalController sucursalController;

    public static void main(String[] args) {
        SpringApplication.run(ExamenTruperApplication.class, args);
    }

}
