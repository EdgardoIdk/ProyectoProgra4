/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprogra4;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Precondition;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.DatabaseReference;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.ArrayList;
import static javax.swing.UIManager.getString;
//import com.google.firebase.database.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import com.google.cloud.firestore.*;


/**
 *
 * @author edgar
 */
public class dataprovider {
    
    CollectionReference reference;
    static Firestore db;
    
    public static boolean guardar(String coleccion, String documento, Map<String, Object> data){
        db = FirestoreClient.getFirestore();
        
        try{
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.set(data);
            System.out.println("Guardado Correctamente");
            return true;
        } catch (Exception e){
            System.out.println("Error");
        }
        return false;
    }
    
    public static boolean editar(String coleccion, String documento, Map<String, Object> data){
        db = FirestoreClient.getFirestore();
        
        try{
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.update(data);
            System.out.println("Actualizado Correctamente");
            return true;
        } catch (Exception e){
            System.out.println("Error");
        }
        return false;
    }
    
    public static boolean eliminar(String coleccion, String documento){
        db = FirestoreClient.getFirestore();
        
        try{
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.delete(Precondition.NONE);
            System.out.println("Eliminado Correctamente");
            return true;
        } catch (Exception e){
            System.out.println("Error");
        }
        return false;
    }
    public static void cargarTablaComputadora(JTable table){
        
        DefaultTableModel model= new DefaultTableModel ();
        model.addColumn("ID");
        model.addColumn("Usuario");
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Mantenimiento");
        model.addColumn("Ram");
        model.addColumn("Disco Duro");
        
        try {
            CollectionReference computadoras = conexion.db.collection("Computadora");
            ApiFuture<QuerySnapshot> querySnap= computadoras.get();
            
            for(DocumentSnapshot document: querySnap.get().getDocuments()){
                model.addRow(new Object[]{
                    document.getId(),
                    document.getString("Usuario"),
                    document.getString("Marca"),
                    document.getString("Modelo"),
                    document.getString("Mantenimiento"),
                    document.getString("Ram"),
                    document.getString("Disco Duro"),
                });
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: "+ e.getMessage());
        }
        
        table.setModel(model);
    }
    
    public static void buscar(JTable table) throws InterruptedException, ExecutionException{
        
        CollectionReference ref = conexion.db.collection("Computadora");

        // Define el ID del registro que se desea buscar
        
        
        Buscar buscar=new Buscar();
        String idBuscado = ("8310");
        
        
            // Crea una consulta para buscar el documento por ID
            Query query = ref.whereEqualTo(FieldPath.documentId(), idBuscado);

        // Ejecuta la consulta y obtiene los resultados
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        QuerySnapshot documentSnapshots = querySnapshot.get();

        // Crea un modelo de tabla para almacenar los resultados
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID");
                model.addColumn("Usuario");
                model.addColumn("Marca");
                model.addColumn("Modelo");
                model.addColumn("Mantenimiento");
                model.addColumn("Ram");
                model.addColumn("Disco Duro");

        // Recorre los resultados y los agrega al modelo de tabla
        for (DocumentSnapshot document : documentSnapshots.getDocuments()) {
            String id = document.getId();
            String Usuario = document.getString("Usuario");
            String Marca = document.getString("Marca");
            String Modelo = document.getString("Modelo");
            String Mantenimiento = document.getString("Mantenimiento");
            String Ram = document.getString("Ram");
            String discoduro = document.getString("Disco Duro");

                    model.addRow(new Object[] { id, Usuario, Marca, Modelo, Mantenimiento, Ram, discoduro });
        }
        table.setModel(model);
    }
}
