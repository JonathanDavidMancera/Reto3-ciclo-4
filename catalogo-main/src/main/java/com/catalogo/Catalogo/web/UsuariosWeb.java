package com.catalogo.Catalogo.web;

import com.catalogo.Catalogo.model.Usuarios;
import com.catalogo.Catalogo.service.ServiceUsuarios;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jonathan Mancera 
 * @version 1
 */

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UsuariosWeb {
    /**
     * Inyección de dependencias
     */
    @Autowired
    private ServiceUsuarios servicios;
    
    /**
     * Método para obtener todos los usuarios
     * @return
     */
    @GetMapping("/all")
    public List<Usuarios> getUser(){
        return servicios.getAll();
    }
    
    /**
     * Método para obtener usuarios por id
     * @param idUser
     * @return
     */
    @GetMapping("/{id}")
    public Optional<Usuarios> getUser(@PathVariable("id") int idUser){
        return servicios.getUser(idUser);
    }

    /**
     * Crear usuarios
     * @return Retorna un objeto de user
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuarios save(@RequestBody Usuarios user){
        return servicios.save(user);
    }

    /**
     * Actualizar usuarios
     * @param user
     * @return
     */
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuarios update(@RequestBody Usuarios user){
        return servicios.update(user);
    }

    /**
     * Borrar usuarios
     * @return Retorna un valor booleano
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int idUser){
        return servicios.delete(idUser);
    }
    
    /**
     * Obtener usuario por email
     * @param email
     * @return
     */
    @GetMapping("/emailexist/{email}")
    public boolean getValUserEmail(@PathVariable("email") String email){
        return servicios.getUserEmail(email);
    }

    /**
     * Obtener usuario por email y contraseña
     * @param email
     * @param password
     * @return
     */
    @GetMapping("/{email}/{password}")
    public Optional<Usuarios> getValUserEmailPass(@PathVariable("email") String email, @PathVariable("password") String password){
        return servicios.getUserEmailPass(email, password);
    }
}
