package com.catalogo.Catalogo.repository;

import com.catalogo.Catalogo.model.Ordenes;
import com.catalogo.Catalogo.repository.crud.InterfaceOrdenes;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryOrdenes {
    @Autowired
    private InterfaceOrdenes crud;
    
    public List<Ordenes> getAll() {
        return (List<Ordenes>) crud.findAll();
    }

    public Optional<Ordenes> getOrder(int id) {
        return crud.findById(id);
    }

    public Ordenes save(Ordenes order) {
        return crud.save(order);
    }

    public void update(Ordenes orden) {
        crud.save(orden);
    }

    public void delete(Ordenes orden) {
        crud.delete(orden);
    }
    
    public Optional<Ordenes> lastUserId(){
        return crud.findTopByOrderByIdDesc();
    }
    
    public List<Ordenes> findByZone(String zona) {
        return crud.findByZone(zona);
    }
}
