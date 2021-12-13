package com.catalogo.Catalogo.service;

import com.catalogo.Catalogo.model.Usuarios;
import com.catalogo.Catalogo.repository.RepositoryUsuarios;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceUsuarios {
    @Autowired
    
    private RepositoryUsuarios metodosCrud;
    
    public List<Usuarios> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Usuarios> getUser(int idUser){
        return metodosCrud.getUser(idUser);
    }
    
    public Usuarios save(Usuarios user){
        
        Optional<Usuarios> userIdMaximo = metodosCrud.lastUserId();
        
        if (user.getId()== null) {
            if(userIdMaximo.isEmpty()){
                user.setId(1);
            }else{
                user.setId(userIdMaximo.get().getId() + 1);
            }
        }
        
        Optional<Usuarios> e = metodosCrud.getUser(user.getId());
        if (e.isEmpty()) {
            if (getUserEmail(user.getEmail())==false){
                return metodosCrud.save(user);
            }else{
                return user;
            }
        }else{
            return user;
        }
    }
    
    public Usuarios update(Usuarios user){
        if(user.getId()!= null){
            Optional<Usuarios> evt = metodosCrud.getUser(user.getId());
            if(!evt.isEmpty()){
                if(user.getIdentification() != null){
                    evt.get().setIdentification(user.getIdentification());
                }
                
                if(user.getName() != null){
                    evt.get().setName(user.getName());
                }
                
                if(user.getAddress() != null){
                    evt.get().setAddress(user.getAddress());
                }
                
                if(user.getCellPhone() != null){
                    evt.get().setCellPhone(user.getCellPhone());
                }
                
                if(user.getEmail() != null){
                    evt.get().setEmail(user.getEmail());
                }
                
                if(user.getPassword() != null){
                    evt.get().setPassword(user.getPassword());
                }
                
                if(user.getZone() != null){
                    evt.get().setZone(user.getZone());
                }
                
                if(user.getType() != null){
                    evt.get().setType(user.getType());
                }
            }
            
            metodosCrud.save(evt.get());
            return evt.get();
        }
        return user;
    }
    
    public boolean delete(int idUser){
        Boolean valid = getUser(idUser).map(usuario ->{
            metodosCrud.delete(usuario);
            return true;
        }).orElse(false);
        
        return valid;
    }
    
    public boolean getUserEmail(String email){
        Optional<Usuarios> evt = metodosCrud.getUserByEmail(email);
        if(!evt.isEmpty()){
            return true;
        }
        
        return false;
    }
    
    public Optional<Usuarios> getUserEmailPass(String email, String password){
        
        Optional<Usuarios> evt = metodosCrud.getUserEmailPass(email, password);
        if(!evt.isEmpty()){
            return metodosCrud.getUserEmailPass(email, password);
        }else{
            Usuarios usuario = new Usuarios();
            usuario.setId(null);
            usuario.setIdentification(null);
            usuario.setName(null);
            usuario.setAddress(null);
            usuario.setCellPhone(null);
            usuario.setEmail(null);
            usuario.setPassword(null);
            usuario.setZone(null);
            usuario.setType(null);
            
            Optional<Usuarios> evt1 = Optional.of(usuario);
            
            return evt1;
        }
    }
}
