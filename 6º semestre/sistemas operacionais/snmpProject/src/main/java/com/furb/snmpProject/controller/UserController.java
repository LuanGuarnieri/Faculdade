package com.furb.snmpProject.controller;

import com.furb.snmpProject.data.entities.Usuario;
import com.furb.snmpProject.data.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/usuario")
public class UserController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/cadastro")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        usuario.setEditar("S");
        usuario.setDeletar("S");
        usuario.setInserir("S");

        return usuarioRepository.save(usuario);
    }

    @GetMapping("")
    public String ok() {
        return  "OK";
    }


}
