package com.fj.FJCO202409012.Servicios.Interfaces;

import com.fj.FJCO202409012.dtos.ProductsFJCO.ProductFJCOEditar;
import com.fj.FJCO202409012.dtos.ProductsFJCO.ProductFJCOGuardar;
import com.fj.FJCO202409012.dtos.ProductsFJCO.ProductFJCOSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductoServiceFJCO {
    List<ProductFJCOSalida> obtenerTodos();

    Page<ProductFJCOSalida> obtenerTodosPaginados(Pageable pageable);

    ProductFJCOSalida obtenerPorId(Integer id);

    ProductFJCOSalida crear(ProductFJCOGuardar productFJCOGuardar);

    ProductFJCOSalida editar(ProductFJCOEditar productFJCOEditar);

    void eliminarPorId(Integer id);
}
