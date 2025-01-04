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

import com.mx.GS_MiniBlog.Models.Usuario;
import com.mx.GS_MiniBlog.Service.Impl.UsuarioServImpl;

@RestController
@RequestMapping(path = "/Blog/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServImpl usuarioService;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<Usuario> usuarios = usuarioService.listar();
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Mensaje\":\"No existen Usuarios.\"}");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(usuarios);
        }

    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Usuario usuario) {
        Usuario usuarioFinded = usuarioService.buscar(usuario);
        if (usuarioFinded == null) {
            usuarioService.guardar(usuario);
            return ResponseEntity.status(HttpStatus.OK).body("{\"Mensaje\":\"Resgistro Exitosamente Almacenado. \"}");
        } else {
            return ResponseEntity.status(HttpStatus.FOUND).body("{\"Mensaje\":\"Ya existe. \"}");

        }
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestBody Usuario usuario) {
        Usuario usuarioFinded = usuarioService.buscar(usuario);
        if (usuarioFinded == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Mensaje\":\"No existe el Usuario. \"}");
        } else {
            usuarioService.editar(usuario);
            return ResponseEntity.status(HttpStatus.OK).body(usuarioFinded);

        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Usuario usuario) {
        usuarioService.eliminar(usuario);
        return ResponseEntity.status(HttpStatus.OK).body("{\"Mensaje\":\"SE ELIMINO EL REGISTRO. \"}");
    }

    @PostMapping("/buscar")
    public ResponseEntity<?> buscar(@RequestBody Usuario usuario) {
        Usuario encontrado = usuarioService.buscar(usuario);
        if (encontrado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Mensaje\":\"No existe el Usuario. \"}");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(encontrado);

        }
    }

}
