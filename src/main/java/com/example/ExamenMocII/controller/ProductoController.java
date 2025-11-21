package com.example.ExamenMocII.controller;

import com.example.ExamenMocII.entity.Producto;
import com.example.ExamenMocII.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping(value = "/productos")
    public Producto addProducto(@RequestBody Producto producto) {
        return this.productoService.addProducto(producto);
    }

    @DeleteMapping(value = "/producto/{productoId}")
    public void deleteProducto(@PathVariable Long productoId) {
    }

    @PutMapping(value = "/producto/{productoId}")
    public Producto modificarProducto(@PathVariable Long productoId, @RequestBody Producto producto) {
        return this.productoService.modificarProducto(productoId, producto);
    }

    @GetMapping(value = "/productos")
    public Object getProductos(@RequestParam(defaultValue = "0.0") Float precio,
                               @RequestParam(defaultValue = "") String categoria) {
        while (this.productoService.findByPrecioAndCategoria(precio, categoria)){
            return this.productoService.findAllProductos();
        }

        while (this.productoService.findByPrecio(precio)){
            return this.productoService.findByPrecio(precio);
        }

        while (this.productoService.findByCategoria(categoria)){
            return this.productoService.findByCategoria(categoria);
        }
        return null;
    }

    @GetMapping(value = "/producto/{productoId}")
    public Optional<Producto> getProducto(@PathVariable Long productoId) {
        return this.productoService.findProducto(productoId);
    }

}