package com.example.domain.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import com.example.domain.ecommerce.dto.RequestDTO;
import com.example.domain.ecommerce.models.entities.Producto;
import com.example.domain.ecommerce.models.entities.Usuario;
import com.example.domain.ecommerce.models.entities.Venta;
import com.example.domain.ecommerce.models.entities.Venta_producto;
import com.example.domain.ecommerce.repositories.VentasDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VentaService {

    @Autowired
    private VentasDAO ventasDAO;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ProductoService productosService;


    public Venta crearVenta(RequestDTO data){
        Usuario usuario = usuarioService.obtenerUsuarioPorId(data.getId_usuario());

        Venta venta = new Venta();
        venta.setFechaVenta(venta.getFechaVenta());
        venta.setUsuario(usuario);

        List<Venta_producto> listasProductos = new ArrayList<>();


        double total = 0.00;

        for (RequestDTO.ItemsVentaDTO productos : data.getItem()) {

            Producto p = productosService.obtenerProductoPorId(productos.getProducto().getIdProducto());

            Venta_producto vp = new Venta_producto();
            vp.setCantidad(productos.getCantidad());
            vp.setProducto(p);
            vp.setVenta(venta);

            total += vp.getSubtotal();

            listasProductos.add(vp);

        }

        venta.setTotal(total);
        venta.setVentaProductos(listasProductos);

        return ventasDAO.save(venta);

    }

}
