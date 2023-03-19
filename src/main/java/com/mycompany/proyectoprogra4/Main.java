/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.proyectoprogra4;



/**
 *
 * @author edgar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        conexion.conectarFirebase();
        
       inicio newframe = new inicio(); 
       newframe.setVisible(true);
        
    }
    
}
