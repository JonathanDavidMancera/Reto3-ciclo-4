package com.catalogo.Catalogo.repository.crud;

import com.catalogo.Catalogo.model.Usuarios;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InterfaceUsuarios extends MongoRepository<Usuarios, Integer>{
    
    public Optional <Usuarios> findByEmail(String email);
    
    public Optional <Usuarios> findByEmailAndPassword(String email, String password);
    
    Optional<Usuarios> findTopByOrderByIdDesc();
}
