package com.example.ExamenMocII.controller;

import com.example.ExamenMocII.entity.Producto;
import com.example.ExamenMocII.service.ProductoService;
import com.example.ExamenMocII.service.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class ProductoController {
    //ProductoController solucionado
    @Autowired
    private ProductoServiceImpl productoService;

    @PostMapping("/productos")
    public Producto addProducto(@RequestBody Producto producto) {
        return this.productoService.addProducto(producto);
    }

    @DeleteMapping("/producto/{productoId}")
    public void deleteProducto(@PathVariable Long productoId) {
    }

    @PutMapping("/producto/{productoId}")
    public Producto modificarProducto(@PathVariable Long productoId, @RequestBody Producto producto) {
        return this.productoService.modificarProducto(productoId, producto);
    }

    @GetMapping("/productos")
    public List<Producto> getProductos(@RequestParam(defaultValue = "0.0") Float precio,
                                       @RequestParam(defaultValue = "") String categoria) {

            if (precio == 0.0 && categoria == ""){
                return this.productoService.findAllProductos();
            } else if (categoria == ""){
                return this.productoService.findByPrecio(precio);
            } else{
                return this.productoService.findByCategoria(categoria);
            }
    }

    @GetMapping("/producto/{productoId}")
    public Optional<Producto> getProducto(@PathVariable Long productoId) {
        return this.productoService.findProducto(productoId);
    }

}