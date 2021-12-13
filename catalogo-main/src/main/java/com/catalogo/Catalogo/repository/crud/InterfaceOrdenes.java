package com.catalogo.Catalogo.repository.crud;

import com.catalogo.Catalogo.model.Ordenes;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface InterfaceOrdenes extends MongoRepository<Ordenes, Integer>{
    
    @Query("{'salesMan.zone': ?0}")
    List<Ordenes> findByZone(final String zone);
    
    @Query("{status: ?0}")
    List<Ordenes> findByStatus(final String status);
    
    Optional<Ordenes> findTopByOrderByIdDesc();
}
