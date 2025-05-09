package com.example.domain.ecommerce.repositories;

import com.example.domain.ecommerce.models.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoDAO extends JpaRepository<Producto, Long>{
    Producto findByNombre(String nombre);
}
