package com.fj.FJCO202409012.Servicios.Implementaciones;

import com.fj.FJCO202409012.Modelos.ProductFJCO;
import com.fj.FJCO202409012.Repositorios.IProductoRepositoryFJCO;
import com.fj.FJCO202409012.Servicios.Interfaces.IProductoServiceFJCO;
import com.fj.FJCO202409012.dtos.ProductsFJCO.ProductFJCOEditar;
import com.fj.FJCO202409012.dtos.ProductsFJCO.ProductFJCOGuardar;
import com.fj.FJCO202409012.dtos.ProductsFJCO.ProductFJCOSalida;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceFJCO implements IProductoServiceFJCO {
    @Autowired
    private IProductoRepositoryFJCO productFJCORepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductFJCOSalida> obtenerTodos() {
        List<ProductFJCO> productsFJCOS = productFJCORepository.findAll();

        return productsFJCOS.stream()
                .map(productEISGS -> modelMapper.map(productEISGS, ProductFJCOSalida.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<ProductFJCOSalida> obtenerTodosPaginados(Pageable pageable) {
        Page<ProductFJCO> page = productFJCORepository.findAll(pageable);

        List<ProductFJCOSalida> productFJCOSDto = page.stream()
                .map(productFJCOS -> modelMapper.map(productFJCOS, ProductFJCOSalida.class))
                .collect(Collectors.toList());

        return new PageImpl<>(productFJCOSDto, page.getPageable(), page.getTotalElements());
    }

    @Override
    public ProductFJCOSalida obtenerPorId(Integer id) {
        return modelMapper.map(productFJCORepository.findById(id).get(), ProductFJCOSalida.class);
    }

    @Override
    public ProductFJCOSalida crear(ProductFJCOGuardar productFJCOGuardar) {
        ProductFJCO productEISGS = productFJCORepository.save(modelMapper.map(productFJCOGuardar, ProductFJCO.class));
        return modelMapper.map(productEISGS, ProductFJCOSalida.class);
    }

    @Override
    public ProductFJCOSalida editar(ProductFJCOEditar productFJCOEditar) {
        ProductFJCO productFJCOS = productFJCORepository.save(modelMapper.map(productFJCOEditar, ProductFJCO.class));
        return modelMapper.map(productFJCOS, ProductFJCOSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        productFJCORepository.deleteById(id);
    }
}
