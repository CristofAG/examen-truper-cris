package com.examen.examentruper.repository;

import com.examen.examentruper.model.Ordenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends JpaRepository<Ordenes, Integer> {
}
