package com.catalogo.Catalogo.repository;

import com.catalogo.Catalogo.model.Usuarios;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.catalogo.Catalogo.repository.crud.InterfaceUsuarios;
 
@Repository
public class RepositoryUsuarios {
    @Autowired
    private InterfaceUsuarios crud;
    
    public List<Usuarios> getAll(){
        return (List<Usuarios>) crud.findAll();
    }
    
    public Optional <Usuarios> getUser(int id){
        return crud.findById(id);
    }
    
    public Usuarios save(Usuarios user){
        return crud.save(user);
    }
    
    public void delete(Usuarios user){
        crud.delete(user);
    }
    
    public Optional <Usuarios> getUserByEmail(String email){
        return crud.findByEmail(email);
    }
    
    public Optional <Usuarios> getUserEmailPass(String email, String password){
        return crud.findByEmailAndPassword(email, password);
    }
    
    public Optional<Usuarios> lastUserId(){
        return crud.findTopByOrderByIdDesc();
    }
}
