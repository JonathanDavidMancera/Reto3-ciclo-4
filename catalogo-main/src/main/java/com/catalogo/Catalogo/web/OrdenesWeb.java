package com.catalogo.Catalogo.web;

import com.catalogo.Catalogo.model.Ordenes;
import com.catalogo.Catalogo.service.ServiceOrdenes;
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

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class OrdenesWeb {
    @Autowired
    private ServiceOrdenes servicios;
    
    @GetMapping("/all")
    public List<Ordenes> getAll() {
        return servicios.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Ordenes> getOrder(@PathVariable("id") int id) {
        return servicios.getOrder(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Ordenes create(@RequestBody Ordenes gadget) {
        return servicios.save(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Ordenes update(@RequestBody Ordenes gadget) {
        return servicios.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return servicios.delete(id);
    }
    
    @GetMapping("/zona/{zona}")
    public List<Ordenes> findByZone(@PathVariable("zona") String zona) {
        return servicios.findByZone(zona);
    }
}
