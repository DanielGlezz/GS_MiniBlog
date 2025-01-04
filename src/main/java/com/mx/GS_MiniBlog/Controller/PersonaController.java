package com.mx.GS_MiniBlog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.GS_MiniBlog.Models.Persona;
import com.mx.GS_MiniBlog.Service.Impl.PersonaServImpl;

@RestController
@RequestMapping(path = "/Blog/personas")
public class PersonaController {

    @Autowired
    private PersonaServImpl personaService;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<Persona> personas = personaService.listar();
        if (personas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Mensaje\":\"No existen personas.\"}");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(personas);
        }

    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Persona persona) {
        Persona usuarioFinded = personaService.buscar(persona);
        if (usuarioFinded == null) {
            personaService.guardar(persona);
            return ResponseEntity.status(HttpStatus.OK).body("{\"Mensaje\":\"Resgistro Exitosamente Almacenado. \"}");
        } else {
            return ResponseEntity.status(HttpStatus.FOUND).body("{\"Mensaje\":\"Ya existe. \"}");

        }
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestBody Persona persona) {
        Persona usuarioFinded = personaService.buscar(persona);
        if (usuarioFinded == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Mensaje\":\"No existe la Persona. \"}");
        } else {
            personaService.editar(persona);
            return ResponseEntity.status(HttpStatus.OK).body(usuarioFinded);

        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Persona persona) {
        personaService.eliminar(persona);
        return ResponseEntity.status(HttpStatus.OK).body("{\"Mensaje\":\"SE ELIMINO EL REGISTRO. \"}");
    }

    @PostMapping("/buscar")
    public ResponseEntity<?> buscar(@RequestBody Persona persona) {
        Persona encontrado = personaService.buscar(persona);
        if (encontrado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Mensaje\":\"No existe la Persona. \"}");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(encontrado);

        }
    }

}