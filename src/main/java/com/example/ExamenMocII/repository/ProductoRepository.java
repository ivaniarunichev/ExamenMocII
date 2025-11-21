package com.example.ExamenMocII.repository;

import com.example.ExamenMocII.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    boolean findByPrecio(float precio);
    boolean findByCategoria(String categoria);

    boolean findByPrecioAndCategoria(float precio, String categoria);
}
