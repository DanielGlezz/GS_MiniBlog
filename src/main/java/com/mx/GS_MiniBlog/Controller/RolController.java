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

import com.mx.GS_MiniBlog.Models.Rol;
import com.mx.GS_MiniBlog.Service.Impl.RolServImpl;

@RestController
@RequestMapping(path = "/Blog/roles")
public class RolController {

    @Autowired
    private RolServImpl rolService;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<Rol> roles = rolService.listar();
        if (roles.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Mensaje\":\"No existen Roles.\"}");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(roles);
        }

    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Rol rol) {
        Rol rolFinded = rolService.buscar(rol);
        if (rolFinded == null) {
            rolService.guardar(rol);
            return ResponseEntity.status(HttpStatus.OK).body("{\"Mensaje\":\"Resgistro Exitosamente Almacenado. \"}");
        } else {
            return ResponseEntity.status(HttpStatus.FOUND).body("{\"Mensaje\":\"Ya existe. \"}");

        }
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestBody Rol rol) {
        Rol rolFinded = rolService.buscar(rol);
        if (rolFinded == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Mensaje\":\"No existe el Rol. \"}");
        } else {
            rolService.editar(rol);
            return ResponseEntity.status(HttpStatus.OK).body(rolFinded);

        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Rol rol) {
        rolService.eliminar(rol);
        return ResponseEntity.status(HttpStatus.OK).body("{\"Mensaje\":\"SE ELIMINO EL REGISTRO. \"}");
    }

    @PostMapping("/buscar")
    public ResponseEntity<?> buscar(@RequestBody Rol rol) {
        Rol encontrado = rolService.buscar(rol);
        if (encontrado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Mensaje\":\"No existe el Rol. \"}");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(encontrado);

        }
    }

}
