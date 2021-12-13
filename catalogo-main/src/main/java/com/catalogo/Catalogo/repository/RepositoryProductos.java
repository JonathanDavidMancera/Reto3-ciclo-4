package com.catalogo.Catalogo.repository;

import com.catalogo.Catalogo.model.Productos;
import com.catalogo.Catalogo.repository.crud.InterfaceProductos;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryProductos {
    @Autowired
    private InterfaceProductos crud;
    
    public List<Productos> getAll(){
        return (List<Productos>) crud.findAll();
    }
    
    public Optional <Productos> getProducto(String reference){
        return crud.findByReference(reference);
    }
    
    public Productos save(Productos productos){
        return crud.save(productos);
    }
    
    public void delete(String reference){
        crud.deleteByReference(reference);
    }
}
