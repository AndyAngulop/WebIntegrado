package com.example.domain.ecommerce.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedores")
public class Proveedor implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ruc;

    private String nombre;

    private int telefono;

    private String email;


    @OneToMany (mappedBy = "proveedor", cascade = CascadeType.ALL)
    private List<Producto> productos = new ArrayList<>();


    public Proveedor() {
    }


    public Proveedor(int ruc, String nombre, int telefono, String email, List<Producto> productos) {
        this.ruc = ruc;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.productos = productos;
    }


    public int getRuc() {
        return ruc;
    }


    public void setRuc(int ruc) {
        this.ruc = ruc;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getTelefono() {
        return telefono;
    }


    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public List<Producto> getProductos() {
        return productos;
    }


    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }





}