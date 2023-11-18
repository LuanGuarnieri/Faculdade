package com.furb.snmpProject.data.repositories;

import com.furb.snmpProject.data.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
