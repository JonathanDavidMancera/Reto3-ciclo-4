package com.catalogo.Catalogo.web;

import com.catalogo.Catalogo.model.Productos;
import com.catalogo.Catalogo.service.ServiceProductos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
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

@RestController
@Transactional
@RequestMapping("/api/cleaningproduct")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class ProductosWeb {
    /**
     * Inyección de dependencias
     */
    @Autowired
    
    private ServiceProductos servicios;
    
    /**
     * Método para o
     * @return
     */
    @GetMapping("/all")
    public List<Productos> getProducto(){
        return servicios.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional<Productos> getProducto(@PathVariable("reference") String reference){
        return servicios.getProducto(reference);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Productos save(@RequestBody Productos productos){
        return servicios.save(productos);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Productos update(@RequestBody Productos productos){
        return servicios.update(productos);
    }
    
    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference){
        return servicios.delete(reference);
    }
}
