package com.catalogo.Catalogo;

import com.catalogo.Catalogo.repository.crud.InterfaceOrdenes;
import com.catalogo.Catalogo.repository.crud.InterfaceProductos;
import com.catalogo.Catalogo.repository.crud.InterfaceUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogoApplication implements CommandLineRunner{
    
    @Autowired
    private InterfaceUsuarios usuInterf;
    @Autowired
    private InterfaceProductos prodInterf;
    @Autowired
    private InterfaceOrdenes ordInterf;

    public static void main(String[] args) {
            SpringApplication.run(CatalogoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        usuInterf.deleteAll();
        prodInterf.deleteAll();
        ordInterf.deleteAll();
    }

}
