package com.catalogo.Catalogo.service;

import com.catalogo.Catalogo.model.Productos;
import com.catalogo.Catalogo.repository.RepositoryProductos;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceProductos {
    @Autowired
    
    private RepositoryProductos metodosCrud;
    
    public List<Productos> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Productos> getProducto(String reference){
        return metodosCrud.getProducto(reference);
    }
    
    public Productos save(Productos productos){
        if (productos.getReference() == null) {
            return metodosCrud.save(productos);
        }else{
            Optional<Productos> evt = metodosCrud.getProducto(productos.getReference());
            if(evt.isEmpty()){
                return metodosCrud.save(productos);
            }else{
                return productos;
            }
        }
    }
    
    public Productos update(Productos productos){
        if(productos.getReference()!= null){
            Optional<Productos> evt = metodosCrud.getProducto(productos.getReference());
            if(!evt.isEmpty()){
                if(productos.getBrand() != null){
                    evt.get().setBrand(productos.getBrand());
                }
                
                if(productos.getCategory() != null){
                    evt.get().setCategory(productos.getCategory());
                }
                
                if(productos.getMaterial() != null){
                    evt.get().setMaterial(productos.getMaterial());
                }
                
                if(productos.getPresentacion() != null){
                    evt.get().setPresentacion(productos.getPresentacion());
                }
                
                if(productos.getDescription() != null){
                    evt.get().setDescription(productos.getDescription());
                }
                
                if(productos.getAvailability() != null){
                    evt.get().setAvailability(productos.getAvailability());
                }
                
                if(productos.getPrice() != null){
                    evt.get().setPrice(productos.getPrice());
                }
                
                if(productos.getQuantity() != null){
                    evt.get().setQuantity(productos.getQuantity());
                }
                
                if(productos.getPhotography()!= null){
                    evt.get().setPhotography(productos.getPhotography());
                }
            }
            
            return metodosCrud.save(evt.get());
        }
        return productos;
    }
    
    public boolean delete(String reference){
        Optional<Productos> evt = metodosCrud.getProducto(reference);
        if(!evt.isEmpty()){
            metodosCrud.delete(reference);
            return true;
        }
        
        return false;
    }
}
