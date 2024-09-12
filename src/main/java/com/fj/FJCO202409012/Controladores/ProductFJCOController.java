package com.fj.FJCO202409012.Controladores;

import com.fj.FJCO202409012.Repositorios.IProductoRepositoryFJCO;
import com.fj.FJCO202409012.Servicios.Interfaces.IProductoServiceFJCO;
import com.fj.FJCO202409012.dtos.ProductsFJCO.ProductFJCOEditar;
import com.fj.FJCO202409012.dtos.ProductsFJCO.ProductFJCOGuardar;
import com.fj.FJCO202409012.dtos.ProductsFJCO.ProductFJCOSalida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductFJCOController {
    @Autowired
    private IProductoServiceFJCO productoServiceFJCO;

    @GetMapping
    public ResponseEntity<Page<ProductFJCOSalida>> mostrarTodosPaginados(Pageable pageable){
        Page<ProductFJCOSalida> productsEISG = productoServiceFJCO.obtenerTodosPaginados(pageable);
        if(productsEISG.hasContent()){
            return ResponseEntity.ok(productsEISG);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<ProductFJCOSalida>> mostrarTodos(){
        List<ProductFJCOSalida> productsFJCO = productoServiceFJCO.obtenerTodos();
        if(!productsFJCO.isEmpty()){
            return ResponseEntity.ok(productsFJCO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductFJCOSalida> buscarPorId(@PathVariable Integer id){
        ProductFJCOSalida productEISG = productoServiceFJCO.obtenerPorId(id);

        if(productEISG != null){
            return ResponseEntity.ok(productEISG);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProductFJCOSalida> crear(@RequestBody ProductFJCOGuardar productFJCOGuardar){
        ProductFJCOSalida productFJCO = productoServiceFJCO.crear(productFJCOGuardar);
        return ResponseEntity.ok(productFJCO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductFJCOSalida> editar(@PathVariable Integer id, @RequestBody ProductFJCOEditar productFJCOEditar){
        ProductFJCOSalida productFJCO = productoServiceFJCO.editar(productFJCOEditar);
        return ResponseEntity.ok(productFJCO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){
        productoServiceFJCO.eliminarPorId(id);
        return ResponseEntity.ok("Producto eliminado correctamente");
    }
}
