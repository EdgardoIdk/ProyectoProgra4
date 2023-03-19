/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprogra4;

/**
 *
 * @author edgar
 */
public class Nombres {
    
    private String id;
    private String usuario;
    private String marca;
    private String modelo;
    private String mantenimiento;
    private String ram;
    private String discoduro;

    public Nombres(String id, String usuario, String marca, String modelo, String mantenimiento, String ram, String discoduro) {
        this.id = id;
        this.usuario = usuario;
        this.marca = marca;
        this.modelo = modelo;
        this.mantenimiento = mantenimiento;
        this.ram = ram;
        this.discoduro = discoduro;
    }

    public String getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMantenimiento() {
        return mantenimiento;
    }

    public String getRam() {
        return ram;
    }

    public String getDiscoduro() {
        return discoduro;
    }
    
    
}
