package com.example.ExamenMocII.service;

import com.example.ExamenMocII.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> findAllProductos();
    Optional<Producto> findProducto(Long id);
    boolean findByCategoria(String categoria);
    boolean findByPrecio(float precio);

    boolean findByPrecioAndCategoria(float precio, String categoria);

    Producto addProducto(Producto producto);
    void eliminarProductoById(Long productoId);
    Producto modificarProducto(Long productoId, Producto producto);
}
