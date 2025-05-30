package com.example.domain.ecommerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.ecommerce.dto.ProveedorDTO;
import com.example.domain.ecommerce.models.entities.Proveedor;
import com.example.domain.ecommerce.repositories.ProveedorDAO;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProveedorService {
   
    @Autowired
    private ProveedorDAO proveedorDAO;


    public Iterable<Proveedor> obtenerProveedores() {
        return proveedorDAO.findAll();
    }

    public void createProv(ProveedorDTO proveedorDTO){
        Proveedor nuevo_proveedor = new Proveedor();
        nuevo_proveedor.setNombre(proveedorDTO.getNombre());
        nuevo_proveedor.setEmail(proveedorDTO.getEmail());
        nuevo_proveedor.setTelefono(proveedorDTO.getTelefono());

        proveedorDAO.save(nuevo_proveedor);

    }

    public void updateProv(ProveedorDTO proveedorDTO, int id) {

        Optional<Proveedor> prov = proveedorDAO.findById(Long.valueOf(id));

        if (prov.isEmpty()) {
            throw new EntityNotFoundException("Usuario con id " + id + " no encontrado");

        }

        Proveedor proveedor = prov.get();
        proveedor.setNombre(proveedorDTO.getNombre());
        proveedor.setEmail(proveedorDTO.getEmail());
        proveedor.setTelefono(proveedorDTO.getTelefono());

        proveedorDAO.save(proveedor);
    }


    public void eliminarProveedor(int id) {
        proveedorDAO.deleteById(Long.valueOf(id));
    }

}
