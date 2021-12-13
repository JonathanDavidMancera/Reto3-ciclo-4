package com.catalogo.Catalogo.repository.crud;

import com.catalogo.Catalogo.model.Productos;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InterfaceProductos extends MongoRepository<Productos, Integer>{
    
    public Optional <Productos> findByReference(String reference);
    
    public void deleteByReference(String reference);
    
}
