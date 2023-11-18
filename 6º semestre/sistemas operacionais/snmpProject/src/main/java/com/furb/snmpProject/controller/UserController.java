package com.furb.snmpProject.controller;

import com.furb.snmpProject.data.entities.Usuario;
import com.furb.snmpProject.data.repositories.UsuarioRepository;
import com.furb.snmpProject.services.logs.Log;
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

    @PostMapping("/teste")
    public Usuario cadastrarUsuario2(@RequestBody Usuario usuario) {
        usuario.setEditar("S");
        usuario.setDeletar("S");
        usuario.setInserir("S");

        return usuario;
    }

}
