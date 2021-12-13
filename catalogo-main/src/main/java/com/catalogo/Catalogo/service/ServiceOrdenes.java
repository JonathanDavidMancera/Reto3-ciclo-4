package com.catalogo.Catalogo.service;

import com.catalogo.Catalogo.model.Ordenes;
import com.catalogo.Catalogo.repository.RepositoryOrdenes;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceOrdenes {
    
    @Autowired
    private RepositoryOrdenes metodosCrud;
    
    public List<Ordenes> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Ordenes> getOrder(int id) {
        return metodosCrud.getOrder(id);
    }

    public Ordenes save(Ordenes order) {
        
        Optional<Ordenes> orderIdMaxima = metodosCrud.lastUserId();
        
        if (order.getId() == null) {
            if (orderIdMaxima.isEmpty()){
                order.setId(1);
            }else{
                order.setId(orderIdMaxima.get().getId() + 1);
            }
        }
        
        Optional<Ordenes> e = metodosCrud.getOrder(order.getId());
        if (e.isEmpty()) {
            return metodosCrud.save(order);            
        }else{
            return order;
        }        
    }

    public Ordenes update(Ordenes order) {

        if (order.getId() != null) {
            Optional<Ordenes> orderDb = metodosCrud.getOrder(order.getId());
            if (!orderDb.isEmpty()) {
                if (order.getStatus() != null) {
                    orderDb.get().setStatus(order.getStatus());
                }
                metodosCrud.update(orderDb.get());
                return orderDb.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(int idOrder) {
        Boolean aBoolean = getOrder(idOrder).map(order -> {
            metodosCrud.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Ordenes> findByZone(String zona) {
        return metodosCrud.findByZone(zona);
    }
}
