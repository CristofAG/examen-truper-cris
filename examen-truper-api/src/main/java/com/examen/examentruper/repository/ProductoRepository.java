package com.examen.examentruper.repository;

import com.examen.examentruper.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Productos, Integer> {
    Productos findByCodigo(String codigo);
}
