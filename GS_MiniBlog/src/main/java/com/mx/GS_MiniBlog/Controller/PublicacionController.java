package com.mx.GS_MiniBlog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.GS_MiniBlog.Models.Publicacion;
import com.mx.GS_MiniBlog.Service.Impl.PublicacionServImpl;

@RestController
@RequestMapping(path = "/Blog/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionServImpl publicacionService;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<Publicacion> publicaciones = publicacionService.listar();
        if (publicaciones.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Mensaje\":\"No existen Publicaciones.\"}");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(publicaciones);
        }
    }

    @PostMapping("/buscar")
    public ResponseEntity<?> buscar(Publicacion publicacion) {
        Publicacion encontrado = publicacionService.buscar(publicacion);
        if (encontrado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Mensaje\":\"No existe la Publicacion. \"}");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(encontrado);

        }
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Publicacion publicacion) {
        Publicacion publicacionFinded = publicacionService.buscar(publicacion);
        if (publicacionFinded == null) {
            publicacionService.guardar(publicacion);
            return ResponseEntity.status(HttpStatus.OK).body("{\"Mensaje\":\"Resgistro Exitosamente Almacenado. \"}");
        } else {
            return ResponseEntity.status(HttpStatus.FOUND).body("{\"Mensaje\":\"Ya existe. \"}");

        }
    }
}
