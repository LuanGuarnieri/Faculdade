package com.furb.snmpProject.data.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_usuario")
    private Long cdUsuario;
    @Column(name = "ds_usuario", nullable = false, unique = true, length = 20)
    private String dsUsuario;
    @Column(name = "ds_senha", nullable = false, length = 80)
    private String dsSenha;
    @Column(length = 1)
    private String inserir;
    @Column(length = 1)
    private String deletar;
    @Column(length = 1)
    private String editar;

    public Usuario(String dsUsuario, String dsSenha, String inserir, String deletar, String editar) {
        this.dsUsuario = dsUsuario;
        this.dsSenha = dsSenha;
        this.inserir = inserir;
        this.deletar = deletar;
        this.editar = editar;
    }

    public Usuario(String dsUsuario, String dsSenha) {
        this.dsUsuario = dsUsuario;
        this.dsSenha = dsSenha;
    }

    public Usuario() {}

    public Long getCd_usuario() {
        return cdUsuario;
    }

    public String getDsUsuario() {
        return dsUsuario;
    }

    public String getDsSenha() {
        return dsSenha;
    }

    public String getInserir() {
        return inserir;
    }

    public String getDeletar() {
        return deletar;
    }

    public String getEditar() {
        return editar;
    }

    public void setCdUsuario(Long cd_usuario) {
        this.cdUsuario = cd_usuario;
    }

    public void setDsUsuario(String ds_usuario) {
        this.dsUsuario = ds_usuario;
    }

    public void setDsSenha(String ds_senha) {
        this.dsSenha = ds_senha;
    }

    public void setInserir(String inserir) {
        this.inserir = inserir;
    }

    public void setDeletar(String deletar) {
        this.deletar = deletar;
    }

    public void setEditar(String editar) {
        this.editar = editar;
    }
}
